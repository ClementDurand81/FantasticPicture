package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import Classe.Personne;

import java.io.FileNotFoundException;

import Classe.Enregistrement;
import Classe.Images;
import Classe.Lecture;
import Classe.Note;

public class VueController {

 	@FXML
    private TextField Nameid1;

    @FXML
    private TextField Noteid1;
    
    @FXML
    private Button btnValider1;
    
    @FXML
    private Button btnConnecter1;
    
    @FXML 
    private ImageView imgView1;
    
    @FXML
    private ListView<String> Listid1;
    
    @FXML
    private PasswordField Mdpid1;
    
    
    Personne personne1 = new Personne("Clement", "azerty");
    Personne personne2 = new Personne("Bob", "1234");
    
    Images image1 = new Images("https://upload.wikimedia.org/wikipedia/commons/thumb/4/4b/La_Tour_Eiffel_vue_de_la_Tour_Saint-Jacques%2C_Paris_ao%C3%BBt_2014_%282%29.jpg/1200px-La_Tour_Eiffel_vue_de_la_Tour_Saint-Jacques%2C_Paris_ao%C3%BBt_2014_%282%29.jpg","Paris");
    Images image2 = new Images("https://a.travel-assets.com/findyours-php/viewfinder/images/res70/481000/481844-Bordeaux.jpg","Bordeaux");
    Images image3 = new Images("https://www.larousse.fr/encyclopedie/data/images/1314872-Lyon.jpg","Lyon");
    
    public void initialize() {
        Listid1.getItems().addAll("Paris", "Bordeaux", "Lyon");
        
        Noteid1.setDisable(true);
        btnValider1.setDisable(true);
        
        Listid1.getSelectionModel().selectedItemProperty().addListener((observable, ancValeur, nouvValeur) -> {
            if (nouvValeur != null) {
                Image imageSelectionne = getNomImg(nouvValeur);
                imgView1.setImage(imageSelectionne);
            }
        });
    }

    @FXML
    private void btnConnexion(MouseEvent event) {
        String persoNom = Nameid1.getText();
        String persoMdp = Mdpid1.getText();
        String villeSelectionne = Listid1.getSelectionModel().getSelectedItem();
            
        if (personne1.verifierIdentifiants(persoNom, persoMdp) || personne2.verifierIdentifiants(persoNom, persoMdp)) {
            	
            Noteid1.setDisable(false);
            btnValider1.setDisable(false);
     
            Lecture lecture = new Lecture();
            try {
                String Note = lecture.lectureData(persoNom, villeSelectionne);
                
                if (Note != null) {
                    Noteid1.setText(Note);
                } else {
                	
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {

        }
    }
    
    @FXML
    private void btnValidation(MouseEvent event) {
        String villeSelectionne = Listid1.getSelectionModel().getSelectedItem();
        String valeurNote = Noteid1.getText();
        String persoNom = Nameid1.getText();
       
        String data = persoNom + ";" + villeSelectionne + ";" + valeurNote + "\n" ;

        Enregistrement enregistrement = new Enregistrement();
        enregistrement.enregistrementHistoriqu(data);
    }
    
    private Image getNomImg(String nom) {
        if (nom.equals("Paris")) {
            return new Image(image1.getUrl());
        } else if (nom.equals("Bordeaux")) {
            return new Image(image2.getUrl());
        } else if (nom.equals("Lyon")) {
            return new Image(image3.getUrl());
        }
        return null;
    }
    
}
