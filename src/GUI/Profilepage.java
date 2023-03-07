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

public class Profilepage implements Initializable {

    @FXML
    private VBox publist;
    @FXML
    private ImageView profilepic2;
    @FXML
    private Label artistId;
    @FXML
    private ImageView photoPost;
    @FXML
    private Label photoPath;
    @FXML
    private TextField postDesc;
    PublicationService ps = new PublicationService();

    private static Profilepage instance;

    public Profilepage() {
        instance = this;
    }

    public static Profilepage getInstance() {
        return instance;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        artistId.setText("1");
        List<Publication> publications = new ArrayList<>(publications(Integer.parseInt(artistId.getText())));
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
    public void refresh(ActionEvent event){
        publist.getChildren().clear();
        artistId.setText("1");
        List<Publication> publications = new ArrayList<>(publications(Integer.parseInt(artistId.getText())));
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

    public void uploadImage(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter FilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter FilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        FileChooser.ExtensionFilter FilterJPEG = new FileChooser.ExtensionFilter("JPEG files (*.jpeg)", "*.JPEG");
        fileChooser.getExtensionFilters().addAll(FilterPNG, FilterJPG, FilterJPEG);
        File file = fileChooser.showOpenDialog(null);
        BufferedImage bufferedImage = ImageIO.read(file);
        Image image = SwingFXUtils.toFXImage(bufferedImage, null);
        photoPost.setImage(image);
        photoPath.setText(file.getPath());
    }

    public void postPost(ActionEvent event) throws SQLException {
        publist.getChildren().clear();
        postDesc.setText("");
        photoPost.setVisible(false);
        Publication publication = new Publication();
        publication.setArtiste_id(1);
        publication.setDescription(postDesc.getText());
        publication.setPhoto(photoPath.getText().substring(62));
        publication.setPhotoArtiste("goku.png");
        ps.ajouter(publication);
        List<Publication> publications = new ArrayList<>(publications(Integer.parseInt(artistId.getText())));
        for (int i = 0; i < publications.size(); i++) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("publication.fxml"));
            try {
                HBox hbox = fxmlLoader.load();
                publicationController pc = fxmlLoader.getController();
                pc.setData(publications.get(i));
                publist.getChildren().add(hbox);
            } catch (IOException e) {
                System.out.println("Erreur");
            }
        }
    }

    public void deleteNode(int hashcode, Publication publication) throws SQLException {
        publist.getChildren().removeIf(e -> e.hashCode() == hashcode);
        ps.supprimer(publication);
    }
}





