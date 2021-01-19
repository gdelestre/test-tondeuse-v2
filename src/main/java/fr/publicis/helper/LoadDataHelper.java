package fr.publicis.helper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class LoadDataHelper {

    public static List<String> loadAllData(String dataName){

        List<String> allDataFromTxt = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(dataName));
            String line;

            //parcours le fichier. Tant qu'il y a une ligne, elle sera ajoutée à la variable data
            while ((line = br.readLine()) != null) {
                allDataFromTxt.add(line);
            }
            br.close();
            return allDataFromTxt;
        } catch (Exception ex) {
            System.out.println("Le fichier n'a pas été trouvé.\n");
            return Collections.emptyList();
        }
    }



    public static String loadLawnCoordTopRight(List<String> allDataFromTxt){
        return allDataFromTxt.get(0);
    }

    public static List<String> loadLawnmowersPositions(List<String> allDataFromTxt){
        return allDataFromTxt.stream()
                .filter(data -> data.matches("^[0-9][ ][0-9][ ][NSWE]$"))
                .collect(Collectors.toList());
    }

    public static List<String> loadLawnmowersInstructions(List<String> allDataFromTxt){
        return allDataFromTxt.stream()
                .filter(data -> data.matches("^[ADG]+$"))
                .collect(Collectors.toList());
    }
}
