package fr.publicis;

import fr.publicis.model.Coordinates;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoordinatesTest {
    Coordinates coordinates;

    @Before
    public void initialisePosition(){
        coordinates = new Coordinates(2,2);
    }

    @Test
    public void moveTowardsNorth(){
        Coordinates positionExpected = new Coordinates(2,3);

        coordinates.moveTowardsNorth();
        assertEquals(positionExpected.toString(), coordinates.toString());
    }

    @Test
    public void moveTowardsSouth(){
        Coordinates positionExpected = new Coordinates(2,1);

        coordinates.moveTowardsSouth();
        assertEquals(positionExpected.toString(), coordinates.toString());
    }

    @Test
    public void moveTowardsEast(){
        Coordinates positionExpected = new Coordinates(3,2);

        coordinates.moveTowardsEast();
        assertEquals(positionExpected.toString(), coordinates.toString());
    }

    @Test
    public void moveTowardsWest(){
        Coordinates positionExpected = new Coordinates(1,2);

        coordinates.moveTowardsWest();
        assertEquals(positionExpected.toString(), coordinates.toString());
    }

    @Test
    public void giveCoordinates(){
        Coordinates coordinates = new Coordinates(2,2);
        String coordinatesExpected = "2 2";
        String coordinatesActual = coordinates.toString();
        assertEquals(coordinatesExpected, coordinatesActual);
    }

}
