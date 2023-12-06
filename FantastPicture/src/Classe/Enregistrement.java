package Classe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Enregistrement {
	
    public void enregistrementHistoriqu(String data) {
        try {
            String fileName = "Sauvegarde.txt";
            File file = new File("src/Sauvegarde/"+fileName);
            FileOutputStream flux = new FileOutputStream(file,true);
            
            if (!file.exists()) {
                file.createNewFile();
            }
            
            String texte = data;
            
            for (int i = 0; i < texte.length(); i++) {
            	flux.write(texte.charAt(i));
            } flux.close();
            
        } catch (FileNotFoundException e) {
        	e.printStackTrace();
        } catch (IOException e) {
        	e.printStackTrace();
        }
    }
}
