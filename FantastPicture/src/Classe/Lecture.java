package Classe;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lecture {

    public String lectureData(String persoNom, String villeSelectionne) throws FileNotFoundException {
        String fileName = "Sauvegarde.txt";
        
        Scanner scanner = new Scanner(new File("src/Sauvegarde/"+fileName));
        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            String[] parts = data.split(";");
            if (parts.length == 3) {
                String valeurNom = parts[0];
                String valeurVille = parts[1];
                String valeurNote = parts[2];

                if (valeurNom.equals(persoNom) && valeurVille.equals(villeSelectionne)) {
                    return valeurNote;
                }
            }
        }
        scanner.close();
        return null;
    }
}
