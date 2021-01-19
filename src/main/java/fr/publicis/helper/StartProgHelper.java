package fr.publicis.helper;

import fr.publicis.model.Coordinates;
import fr.publicis.model.Lawnmower;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public abstract class StartProgHelper {
    public static Scanner keyboard = new Scanner(System.in);
    public static List<String> allData;
    public static String coordinatesTopRightCorner;
    public static List<String> allLawmnmowersInformations;
    public static List<String> allLawmnmowersInstructions;
    public static List<Coordinates> forbidenCoordinates;

    public static void loadAllData() {
        String dataName;

        while (true) {
            dataName = askForDataName();
            allData = LoadDataHelper.loadAllData(dataName);

            if (!allData.isEmpty()) {
                keyboard.close();
                return;
            }
        }
    }

    public static String askForDataName() {
        System.out.println("Le fichier de données doit être au même niveau que le programme.");
        System.out.println("Veuillez indiquer le nom complet du fichier de données (avec l'extension):");

        return keyboard.nextLine();
    }

    public static boolean loadInformationsFromData() {

        if (ValidDataHelper.validFormatData(allData)) {
            coordinatesTopRightCorner = LoadDataHelper.loadLawnCoordTopRight(allData);
            allLawmnmowersInformations = LoadDataHelper.loadLawnmowersPositions(allData);
            allLawmnmowersInstructions = LoadDataHelper.loadLawnmowersInstructions(allData);

            //Définition d'une liste où une tondeuse ne pourra pas aller,
            //a partir de la liste des positions de toutes les tondeuses
            forbidenCoordinates = allLawmnmowersInformations.stream()
                    .map(ConvertHelper::stringToCoordinates)
                    .collect(Collectors.toList());
            return true;
        }
        return false;
    }

    public static void startProgram() {
        if (isOkToStart()) {
            for (int i = 0; i < allLawmnmowersInformations.size(); i++) {
                Lawnmower lawnmower = ConvertHelper.stringToLawnmower(allLawmnmowersInformations.get(i));
                String instruction = allLawmnmowersInstructions.get(i);
                //La tondeuse va démarrer sa série d'instruction. J'enlève donc sa position des positions interdites
                forbidenCoordinates.remove(lawnmower.getCoordinates());

                for (int j = 0; j < instruction.length(); j++) {
                    if (instruction.charAt(j) == 'A') {
                        if (isOkToMove(lawnmower))
                            lawnmower.move();
                    } else {
                        lawnmower.changeDirection(instruction.charAt(j));
                    }
                }

                lawnmower.sayInformations();
                //La tondeuse a finie sa série d'instruction. Je rajoute donc sa position aux positions interdites
                forbidenCoordinates.add(lawnmower.getCoordinates());
            }
        }
    }

    public static boolean isOkToStart() {
        if (!ValidDataHelper.validPositionOnLawn(coordinatesTopRightCorner, allLawmnmowersInformations)) {
            System.out.println("Il y a au moins une tondeuse en dehors de la pelouse.");
            return false;
        }
        if (!ValidDataHelper.onlyOneLawnmowerPerPosition(allLawmnmowersInformations)) {
            System.out.println("Il y au moins deux tondeuses sur le même emplacement.");
            return false;
        }
        if (!ValidDataHelper.oneInstructionPerLawnmower(allLawmnmowersInformations, allLawmnmowersInstructions)) {
            System.out.println("La dernière tondeuse n'a pas de série d'instructions.");
            return false;
        }
        return true;
    }

    public static boolean isOkToMove(Lawnmower lawnmower) {
        Coordinates topRightCorner = ConvertHelper.stringToCoordinates(coordinatesTopRightCorner);
        Coordinates coordinatesAfterMove = null;

        switch (lawnmower.getOrientation()) {
            case N:
                coordinatesAfterMove = new Coordinates(lawnmower.getCoordinates().getCoordinateX(), lawnmower.getCoordinates().getCoordinateY() + 1);
                if (lawnmower.getCoordinates().getCoordinateY() == topRightCorner.getCoordinateY())
                    return false;

                break;

            case S:
                coordinatesAfterMove = new Coordinates(lawnmower.getCoordinates().getCoordinateX(), lawnmower.getCoordinates().getCoordinateY() - 1);
                if (lawnmower.getCoordinates().getCoordinateY() == 0)
                    return false;

                break;

            case E:
                coordinatesAfterMove = new Coordinates(lawnmower.getCoordinates().getCoordinateX() + 1, lawnmower.getCoordinates().getCoordinateY());
                if (lawnmower.getCoordinates().getCoordinateX() == topRightCorner.getCoordinateX())
                    return false;

                break;

            case W:
                coordinatesAfterMove = new Coordinates(lawnmower.getCoordinates().getCoordinateX() - 1, lawnmower.getCoordinates().getCoordinateY());
                if (lawnmower.getCoordinates().getCoordinateX() == 0)
                    return false;

                break;
        }

        return forbidenCoordinates.size() == 0 || !forbidenCoordinates.contains(coordinatesAfterMove);
    }


}
