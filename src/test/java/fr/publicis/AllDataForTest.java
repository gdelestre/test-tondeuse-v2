package fr.publicis;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class AllDataForTest {
    private final static String dataName = "dataForTest.txt";
    private final static List<String> rightData = Stream.of("5 5", "1 2 N", "GAGAGAGAA", "3 3 E", "AADAADADDA").collect(Collectors.toList());
    private final static List<String> wrongData = Stream.of("B 1", "-1 9 N", "ABCDEF", "O 9 S", "dgaggad", "10 9 E", "AGDR").collect(Collectors.toList());
    private final static String topRightCorner = "5 5";
    private final static String lawnmowerInformations = "2 2 N";
    private final static List<String> goodLawnmowersInformations = Stream.of("1 2 N", "2 3 S", "5 0 E", "0 5 W").collect(Collectors.toList());
    private final static List<String> goodLawnmowersInstructions = Stream.of("AAGA", "AAADAGAA", "AADDAAA", "AAADGA").collect(Collectors.toList());

    public static String getDataName() {
        return dataName;
    }

    public static List<String> getRightData() {
        return rightData;
    }

    public static List<String> getWrongData() {
        return wrongData;
    }

    public static String getTopRightCorner() {
        return topRightCorner;
    }

    public static String getLawnmowerInformations() {
        return lawnmowerInformations;
    }

    public static List<String> getGoodLawnmowersInformations() {
        return goodLawnmowersInformations;
    }

    public static List<String> getGoodLawnmowersInstructions() {
        return goodLawnmowersInstructions;
    }
}
