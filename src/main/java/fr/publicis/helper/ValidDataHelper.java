package fr.publicis.helper;

import fr.publicis.model.Coordinates;

import java.util.List;
import java.util.stream.Collectors;

public abstract class ValidDataHelper {

    public static boolean validFormatData(List<String> allDataFromTxt){
        if(allDataFromTxt.size() > 0){
            String regex;
            for(int i = 0; i < allDataFromTxt.size(); i++){
                //La première ligne contient les coordonnées du coin supérieure de la pelouse
                if(i == 0){
                    regex = "^[0-9][ ][0-9]$";
                    //Ensuite, les lignes impairs correspondent aux coordonnées et orientation de la tondeuse
                }else if (i%2 != 0){
                    regex="^[0-9][ ][0-9][ ][NSWE]$";
                    //Et les lignes pairs correspondent aux séries d'instructions
                }else{
                    regex = "^[ADG]+$";
                }

                if(!allDataFromTxt.get(i).matches(regex))
                    return false;
            }
        }
        return true;
    }

    public static boolean validPositionOnLawn(String lawnCoordTopRight, List<String> lawnmowersInformations){
        Coordinates coordTopRight = ConvertHelper.stringToCoordinates(lawnCoordTopRight);

        List<Coordinates> lawnmowersPositions = getCoordinatesOnLawn(lawnmowersInformations);

        //La méthode validFormatData vérifie déjà que les coordonnées sont bien positives ou nulles
        for(Coordinates lawnmowerPosition : lawnmowersPositions){
            if(lawnmowerPosition.getCoordinateX() > coordTopRight.getCoordinateX() ||
                lawnmowerPosition.getCoordinateY() > coordTopRight.getCoordinateY())
                    return false;
        }
        return true;
    }

    public static boolean onlyOneLawnmowerPerPosition(List<String> lawnmowersInformations){

        List<Coordinates> lawnmowersPositions = getCoordinatesOnLawn(lawnmowersInformations);
        List<Coordinates> lawnmowersPositionsWithoutDuplicate =
                lawnmowersPositions.stream().distinct().collect(Collectors.toList());

        return lawnmowersPositions.size() == lawnmowersPositionsWithoutDuplicate.size();
    }

    private static List<Coordinates> getCoordinatesOnLawn(List<String> lawnmowersInformations) {
        return lawnmowersInformations.stream()
                .map(ConvertHelper::stringToCoordinates)
                .collect(Collectors.toList());
    }

    public static boolean oneInstructionPerLawnmower(List<String> lawnmowersInformations, List<String> lawnmowersInstructions){
        return lawnmowersInformations.size() == lawnmowersInstructions.size();
    }
}
