package fr.publicis;

import fr.publicis.helper.LoadDataHelper;
import fr.publicis.helper.ValidDataHelper;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static fr.publicis.AllDataForTest.*;
import static fr.publicis.AllDataForTest.getGoodLawnmowersInformations;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidDataTest {

    @Test
    public void rightControlData() {
        List<String> allDataFromTxt = LoadDataHelper.loadAllData(getDataName());
        boolean isValid = ValidDataHelper.validFormatData(allDataFromTxt);
        assertTrue(isValid);
    }

    @Test
    public void wrongControlData() {
        boolean isValid = ValidDataHelper.validFormatData(getWrongData());
        assertFalse(isValid);
    }

    @Test
    public void rightFormatTopRightCorner() {
        boolean isValid = ValidDataHelper.validFormatData(getRightData());
        assertTrue(isValid);
    }

    @Test
    public void wrongFormatTopRightCorner() {
        final List<String> wrongTopRightCorner = Arrays.asList("B 5", "1 2 N", "GAGAGAGAA", "3 3 E", "AADAADADDA");

        boolean isValid = ValidDataHelper.validFormatData(wrongTopRightCorner);
        assertFalse(isValid);
    }

    @Test
    public void wrongFormatLawnmowerPosition() {
        final List<String> wrongLawnmowerPosition = Arrays.asList("5 5", "-1 2 N", "GAGAGAGAA", "3 3 E", "AADAADADDA");

        boolean isValid = ValidDataHelper.validFormatData(wrongLawnmowerPosition);
        assertFalse(isValid);
    }

    @Test
    public void wrongFormatLawnmowerInstruction() {
        final List<String> wrongLawnmowerInstruction = Arrays.asList("5 5", "1 2 N", "GAGAGAGAAL", "3 3 E", "AADAADADDA");

        boolean isValid = ValidDataHelper.validFormatData(wrongLawnmowerInstruction);
        assertFalse(isValid);
    }

    @Test
    public void onlyValidPositionOnLawn(){

        //Coin supérieur droit : 5 5
        boolean isValid = ValidDataHelper.validPositionOnLawn(getTopRightCorner(), getGoodLawnmowersInformations());
        assertTrue(isValid);
    }

    @Test
    public void oneInvalidAbsOnLawn(){
        final List<String> badLawnmowersInformations = Arrays.asList("6 2 N", "2 3 S", "5 0 E", "0 5 W");

        //Coin supérieur droit : 5 5
        boolean isValid = ValidDataHelper.validPositionOnLawn(getTopRightCorner(), badLawnmowersInformations);
        assertFalse(isValid);
    }

    @Test
    public void oneInvalidOrdOnLawn(){
        final List<String> badLawnmowersInformations = Arrays.asList("1 2 N", "2 6 S", "5 0 E", "0 5 W");

        //Coin supérieur droit : 5 5
        boolean isValid = ValidDataHelper.validPositionOnLawn(getTopRightCorner(), badLawnmowersInformations);
        assertFalse(isValid);
    }

    @Test
    public void oneLawnmowerPerPosition(){
        boolean isValid = ValidDataHelper.onlyOneLawnmowerPerPosition(getGoodLawnmowersInformations());
        assertTrue(isValid);
    }

    @Test
    public void manyLawnmowerPerPosition(){
        final List<String> badLawnmowersInformations = Arrays.asList("1 2 N", "1 2 S", "2 0 E", "0 5 W");

        boolean isValid = ValidDataHelper.onlyOneLawnmowerPerPosition(badLawnmowersInformations);
        assertFalse(isValid);
    }

    @Test
    public void oneInstructionsPerLawnmower(){
        // Liste d'informations pour 4 tondeuses
        final List<String> goodLawnmowersInformations = getGoodLawnmowersInformations();
        final List<String> goodLawnmowersInstructions = Arrays.asList("AAAAADG", "AADAGAAD", "AADDAAGGDAG", "AADDGADGA");
        assertTrue(ValidDataHelper.oneInstructionPerLawnmower(goodLawnmowersInformations, goodLawnmowersInstructions));
    }

    @Test
    public void oneMoreLawnmower(){
        // Liste d'informations pour 4 tondeuses
        final List<String> goodLawnmowersInformations = getGoodLawnmowersInformations();
        //Seulement 3 instructions pour 4 tondeuses
        final List<String> badLawnmowersInstructions = Arrays.asList("AAAAADG", "AADAGAAD", "AADDAAGGDAG");
        assertFalse(ValidDataHelper.oneInstructionPerLawnmower(goodLawnmowersInformations, badLawnmowersInstructions));
    }

}
