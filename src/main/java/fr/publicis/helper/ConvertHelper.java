package fr.publicis.helper;

import fr.publicis.model.Coordinates;
import fr.publicis.model.Lawnmower;
import fr.publicis.model.Orientation;

public abstract class ConvertHelper {

    public static Coordinates stringToCoordinates(String lawnmowerInformations){
        //Format: positionX positionY orientation
        String[] allInformations = lawnmowerInformations.split(" ");
        return new Coordinates(Integer.parseInt(allInformations[0]), Integer.parseInt(allInformations[1]));
    }

    public static Lawnmower stringToLawnmower(String lawnmowerInformations){
        //Format: positionX positionY orientation
        String[] allInformations = lawnmowerInformations.split(" ");
        Coordinates coordinates = new Coordinates(Integer.parseInt(allInformations[0]), Integer.parseInt(allInformations[1]));
        Orientation orientation = Orientation.valueOf(allInformations[2]);
        return new Lawnmower(coordinates,orientation);
    }
}
