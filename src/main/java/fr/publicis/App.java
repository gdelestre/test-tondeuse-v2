package fr.publicis;

import fr.publicis.helper.StartProgHelper;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        StartProgHelper.loadAllData();
        if(StartProgHelper.loadInformationsFromData())
            StartProgHelper.startProgram();
        else{
            System.out.println("Des données sont invalides. Vérifiez le fichier d'entrée.");
        }
    }

}
