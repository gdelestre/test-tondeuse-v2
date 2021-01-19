package fr.publicis;

import fr.publicis.model.Coordinates;
import fr.publicis.model.Lawnmower;
import fr.publicis.model.Orientation;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LawnmowerInstructionsTest {
    private Coordinates coordinates;

    @Before
    public void createCoordinates() {
        coordinates = new Coordinates(2, 2);
    }

    @Test
    public void changeDirectionFromNorthToEast() {
        Lawnmower lawnmower = new Lawnmower(coordinates, Orientation.N);
        lawnmower.changeDirection('D');

        Orientation expectedOrientation = Orientation.E;
        assertEquals(expectedOrientation, lawnmower.getOrientation());
    }

    @Test
    public void changeDirectionFromNorthToWest() {
        Lawnmower lawnmower = new Lawnmower(coordinates, Orientation.N);
        lawnmower.changeDirection('G');

        Orientation expectedOrientation = Orientation.W;
        assertEquals(expectedOrientation, lawnmower.getOrientation());
    }

    @Test
    public void changeDirectionFromEastToSouth() {
        Lawnmower lawnmower = new Lawnmower(coordinates, Orientation.E);
        lawnmower.changeDirection('D');

        Orientation expectedOrientation = Orientation.S;
        assertEquals(expectedOrientation, lawnmower.getOrientation());
    }

    @Test
    public void changeDirectionFromEastToNorth() {
        Lawnmower lawnmower = new Lawnmower(coordinates, Orientation.E);
        lawnmower.changeDirection('G');

        Orientation expectedOrientation = Orientation.N;
        assertEquals(expectedOrientation, lawnmower.getOrientation());
    }

    @Test
    public void changeDirectionFromSouthToWest() {
        Lawnmower lawnmower = new Lawnmower(coordinates, Orientation.S);
        lawnmower.changeDirection('D');

        Orientation expectedOrientation = Orientation.W;
        assertEquals(expectedOrientation, lawnmower.getOrientation());
    }

    @Test
    public void changeDirectionFromSouthToEast() {
        Lawnmower lawnmower = new Lawnmower(coordinates, Orientation.S);
        lawnmower.changeDirection('G');

        Orientation expectedOrientation = Orientation.E;
        assertEquals(expectedOrientation, lawnmower.getOrientation());
    }

    @Test
    public void changeDirectionFromWestToNorth() {
        Lawnmower lawnmower = new Lawnmower(coordinates, Orientation.W);
        lawnmower.changeDirection('D');

        Orientation expectedOrientation = Orientation.N;
        assertEquals(expectedOrientation, lawnmower.getOrientation());
    }

    @Test
    public void changeDirectionFromWestToSouth() {
        Lawnmower lawnmower = new Lawnmower(coordinates, Orientation.W);
        lawnmower.changeDirection('G');

        Orientation expectedOrientation = Orientation.S;
        assertEquals(expectedOrientation, lawnmower.getOrientation());
    }

    @Test
    public void moveTowardNorth() {
        Lawnmower lawnmower = new Lawnmower(coordinates, Orientation.N);
        lawnmower.move();
        Coordinates expectedCoordinates = new Coordinates(2, 3);
        assertEquals(expectedCoordinates, lawnmower.getCoordinates());
    }

    @Test
    public void moveTowardEast() {
        Lawnmower lawnmower = new Lawnmower(coordinates, Orientation.E);
        lawnmower.move();
        Coordinates expectedCoordinates = new Coordinates(3, 2);
        assertEquals(expectedCoordinates, lawnmower.getCoordinates());
    }

    @Test
    public void moveTowardSouth() {
        Lawnmower lawnmower = new Lawnmower(coordinates, Orientation.S);
        lawnmower.move();
        Coordinates expectedCoordinates = new Coordinates(2, 1);
        assertEquals(expectedCoordinates, lawnmower.getCoordinates());
    }

    @Test
    public void moveTowardWest() {
        Lawnmower lawnmower = new Lawnmower(coordinates, Orientation.W);
        lawnmower.move();
        Coordinates expectedCoordinates = new Coordinates(1, 2);
        assertEquals(expectedCoordinates, lawnmower.getCoordinates());
    }

    @Test
    public void sayInformations() {
        Lawnmower lawnmower = new Lawnmower(coordinates, Orientation.W);
        String expectedInformations = "2 2 W";
        String actualInformations = lawnmower.sayInformations();
        assertEquals(expectedInformations, actualInformations);
    }

    @Test
    public void sayBadInformations() {
        Lawnmower lawnmower = new Lawnmower(coordinates, Orientation.W);
        String notExpectedInformations = "3 2 W";
        String actualInformations = lawnmower.sayInformations();
        assertNotEquals(notExpectedInformations, actualInformations);
    }
}
