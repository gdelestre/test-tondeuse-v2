package fr.publicis;

import fr.publicis.helper.ConvertHelper;
import fr.publicis.helper.StartProgHelper;
import fr.publicis.model.Coordinates;
import fr.publicis.model.Lawnmower;
import fr.publicis.model.Orientation;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StartProgTest {
    private Coordinates coordinates;

    @Test
    public void isOkToStart(){
        StartProgHelper.coordinatesTopRightCorner = AllDataForTest.getTopRightCorner();
        StartProgHelper.allLawmnmowersInformations = AllDataForTest.getGoodLawnmowersInformations();
        StartProgHelper.allLawmnmowersInstructions = AllDataForTest.getGoodLawnmowersInstructions();

        assertTrue(StartProgHelper.isOkToStart());
    }

    @Test
    public void lawnmowerOutOfLawn(){
        //Coin supérieur droit : 5 5
        StartProgHelper.coordinatesTopRightCorner = AllDataForTest.getTopRightCorner();
        StartProgHelper.allLawmnmowersInformations = Stream.of("6 2 N", "2 2 S", "1 3 E", "2 8 W").collect(Collectors.toList());
        StartProgHelper.allLawmnmowersInstructions = AllDataForTest.getGoodLawnmowersInstructions();

        assertFalse(StartProgHelper.isOkToStart());
    }

    @Test
    public void twoLawnmowersOnSamePlace(){
        StartProgHelper.coordinatesTopRightCorner = AllDataForTest.getTopRightCorner();
        StartProgHelper.allLawmnmowersInformations = Stream.of("2 2 N", "2 2 S", "1 3 E", "2 5 W").collect(Collectors.toList());
        StartProgHelper.allLawmnmowersInstructions = AllDataForTest.getGoodLawnmowersInstructions();

        assertFalse(StartProgHelper.isOkToStart());
    }

    @Test
    public void missOneInstruction(){
        StartProgHelper.coordinatesTopRightCorner = AllDataForTest.getTopRightCorner();
        StartProgHelper.allLawmnmowersInformations = AllDataForTest.getGoodLawnmowersInformations();

        //Il y a 4 tondeuses, donc il faut 4 séries d'instructions
        StartProgHelper.allLawmnmowersInstructions = Stream.of("AAGA", "AADDAA", "GAAGA").collect(Collectors.toList());

        assertFalse(StartProgHelper.isOkToStart());
    }



    @Test
    public void isOkToMove(){
        StartProgHelper.coordinatesTopRightCorner = AllDataForTest.getTopRightCorner();
        StartProgHelper.forbidenCoordinates = Collections.emptyList();
        Coordinates coordinates = new Coordinates(2, 2);
        Lawnmower lawnmower = new Lawnmower(coordinates, Orientation.N);
        assertTrue(StartProgHelper.isOkToMove(lawnmower));
    }

    @Test
    public void lawnmowerOnTheTop(){
        StartProgHelper.coordinatesTopRightCorner = AllDataForTest.getTopRightCorner();
        StartProgHelper.forbidenCoordinates = Collections.emptyList();

        //Coin supérieur droit : 5 5
        Coordinates coordinates = new Coordinates(2, 5);
        Lawnmower lawnmower = new Lawnmower(coordinates, Orientation.N);
        assertFalse(StartProgHelper.isOkToMove(lawnmower));
    }

    @Test
    public void lawnmowerOnTheBot(){
        StartProgHelper.coordinatesTopRightCorner = AllDataForTest.getTopRightCorner();
        StartProgHelper.forbidenCoordinates = Collections.emptyList();
        Coordinates coordinates = new Coordinates(2, 0);
        Lawnmower lawnmower = new Lawnmower(coordinates, Orientation.S);
        assertFalse(StartProgHelper.isOkToMove(lawnmower));
    }

    @Test
    public void lawnmowerOnTheLeft(){
        StartProgHelper.coordinatesTopRightCorner = AllDataForTest.getTopRightCorner();
        StartProgHelper.forbidenCoordinates = Collections.emptyList();
        Coordinates coordinates = new Coordinates(0, 2);
        Lawnmower lawnmower = new Lawnmower(coordinates, Orientation.W);
        assertFalse(StartProgHelper.isOkToMove(lawnmower));
    }

    @Test
    public void lawnmowerOnTheRight(){
        StartProgHelper.coordinatesTopRightCorner = AllDataForTest.getTopRightCorner();
        StartProgHelper.forbidenCoordinates = Collections.emptyList();

        //Coin supérieur droit : 5 5
        Coordinates coordinates = new Coordinates(5, 2);
        Lawnmower lawnmower = new Lawnmower(coordinates, Orientation.E);
        assertFalse(StartProgHelper.isOkToMove(lawnmower));
    }

    @Test
    public void lawnmowerOnTheWay(){
        StartProgHelper.coordinatesTopRightCorner = AllDataForTest.getTopRightCorner();
        StartProgHelper.forbidenCoordinates = Stream.of("2 3 S", "4 5 N")
                .map(ConvertHelper::stringToCoordinates)
                .collect(Collectors.toList());

        //Il y a une tondeuse en 2 3
        Coordinates coordinates = new Coordinates(2, 2);
        Lawnmower lawnmower = new Lawnmower(coordinates, Orientation.N);
        assertFalse(StartProgHelper.isOkToMove(lawnmower));
    }

    @Test
    public void lawnmowerOnTheWayBis(){
        StartProgHelper.coordinatesTopRightCorner = AllDataForTest.getTopRightCorner();
        StartProgHelper.forbidenCoordinates = Stream.of("2 3 S", "4 5 N")
                .map(ConvertHelper::stringToCoordinates)
                .collect(Collectors.toList());

        //Il y a une tondeuse en 4 5
        Coordinates coordinates = new Coordinates(3, 5);
        Lawnmower lawnmower = new Lawnmower(coordinates, Orientation.E);
        assertFalse(StartProgHelper.isOkToMove(lawnmower));
    }

}
