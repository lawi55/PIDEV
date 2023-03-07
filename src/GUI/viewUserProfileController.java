package GUI;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Entities.Publication;
import Services.ArtisteService;
import Services.PublicationService;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;

public class viewUserProfileController implements Initializable {

    @FXML
    private VBox publist;
    @FXML
    private ImageView profilepic2;
    @FXML
    private Label followersnumber;
    @FXML
    private ImageView photoPost;
    @FXML
    private Label artistid;

    PublicationService ps = new PublicationService();
    ArtisteService as = new ArtisteService();

    private static viewUserProfileController instance;

    public viewUserProfileController() {
        instance = this;
    }

    public static viewUserProfileController getInstance() {
        return instance;
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<Publication> publications = new ArrayList<>(publications(homePageUserController.currentId));
        System.out.println(publications);
        for (Publication publication : publications) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("publication.fxml"));
            try {
                HBox hbox = fxmlLoader.load();
                publicationController pc = fxmlLoader.getController();
                pc.setData(publication);
                publist.getChildren().add(hbox);
            } catch (IOException | SQLException e) {
                System.out.println("Erreur012 : " + e);
            }
        }
    }

    @FXML
    public void follow(ActionEvent event){
    }

    private List<Publication> publications(int id) {
        PublicationService ps = new PublicationService();
        List<Publication> lp = null;
        try {
            lp = ps.recupererParId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lp;
    }


}





