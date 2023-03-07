package Test;

import Entities.Commentaire;
import Entities.Publication;
import Entities.Utilisateur;
import Services.CommentaireService;
import Services.PublicationService;
import Utils.MyDB;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLException;

public class Test {

    public static void main(String[] args) {
        try {
            MyDB db = MyDB.getInstance();
            MyDB db1 = MyDB.getInstance();
            Publication p1 = new Publication(1, "please like this post", "yujtjyutyu");
            PublicationService ps = new PublicationService();
            CommentaireService cs = new CommentaireService();
            ps.ajouter(p1);
            ps.modifier(p1);
            Commentaire c1 = new Commentaire(1, "hhhhhhhhhhhhhhhhhhh so funny");
            cs.ajouter(c1);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }


    }


}
