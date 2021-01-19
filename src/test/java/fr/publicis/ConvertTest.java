package fr.publicis;

import fr.publicis.helper.ConvertHelper;
import fr.publicis.model.Coordinates;
import fr.publicis.model.Lawnmower;
import fr.publicis.model.Orientation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConvertTest {

    @Test
    public void convertStringToCoordinates(){
        // lawnmowerInformations = "2 2 N"
        String lawnmowerInformations = AllDataForTest.getLawnmowerInformations();
        Coordinates expectedPosition = new Coordinates(2, 2);

        Coordinates actualPosition = ConvertHelper.stringToCoordinates(lawnmowerInformations);

        assertEquals(expectedPosition, actualPosition);
    }

    @Test
    public void convertStringToLawnmower(){
        // lawnmowerInformations = "2 2 N"
        String lawnmowerInformations = AllDataForTest.getLawnmowerInformations();
        Coordinates coordinates = new Coordinates(2, 2);
        Lawnmower expectedLawnmower = new Lawnmower(coordinates, Orientation.N);

        Lawnmower actualLawnmower = ConvertHelper.stringToLawnmower(lawnmowerInformations);

        assertEquals(expectedLawnmower.toString(), actualLawnmower.toString());
    }
}
