package fr.publicis;

import fr.publicis.helper.LoadDataHelper;
import org.junit.Test;

import java.util.List;

import static fr.publicis.AllDataForTest.*;
import static org.junit.Assert.*;

public class LoadDataTest {



    @Test
    public void successLoadData() {
        //Presence d'un fichier dataForTest.txt
        List<String> allDataFromTxt = LoadDataHelper.loadAllData(getDataName());
        assertTrue(allDataFromTxt.size() > 0);
    }

    @Test
    public void failLoadData() {
        //Absence d'un fichier data
        List<String> allDataFromTxt = null;
        try{
            allDataFromTxt =  LoadDataHelper.loadAllData("data");
        }catch (Exception ex){
            fail();
        }

        assertEquals(0, allDataFromTxt.size());
    }

    @Test
    public void rightLoadLawnCoordTopRight() {
        String lawnCornerTopRight = LoadDataHelper.loadLawnCoordTopRight(getRightData());
        assertEquals("5 5", lawnCornerTopRight);
    }

    @Test
    public void wrongLoadLawnCoordTopRight() {
        String lawnCornerTopRight = LoadDataHelper.loadLawnCoordTopRight(getWrongData());
        assertNotEquals("5 5", lawnCornerTopRight);
    }

    @Test
    public void rightLoadLawnmowersPositions() {
        List<String> allLawnmowersPositions = LoadDataHelper.loadLawnmowersPositions(getRightData());
        assertEquals(2, allLawnmowersPositions.size());
    }

    @Test
    public void wrongLoadLawnmowersPositions() {
        List<String> allLawnmowersPositions = LoadDataHelper.loadLawnmowersPositions(getWrongData());
        assertNotEquals(2, allLawnmowersPositions.size());
    }

    @Test
    public void rightLoadLawnmowersInstructions() {
        List<String> allLawnmowersInstructions = LoadDataHelper.loadLawnmowersInstructions(getRightData());
        assertEquals(2, allLawnmowersInstructions.size());
    }

    @Test
    public void wrongLoadLawnmowersInstructions() {
        List<String> allLawnmowersInstructions = LoadDataHelper.loadLawnmowersInstructions(getWrongData());
        assertNotEquals(2, allLawnmowersInstructions.size());
    }


}
