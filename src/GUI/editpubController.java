package GUI;

import Entities.Publication;
import Services.PublicationService;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class editpubController implements Initializable {
    @FXML
    private TextField contenuPost;
    @FXML
    private ImageView ImagePub;
    @FXML
    private javafx.scene.control.Label path;
    @FXML
    private javafx.scene.control.Label id_post;

    PublicationService ps = new PublicationService();

    @FXML
    private void confirmer(ActionEvent event) throws SQLException {
        Publication publication = new Publication();
        publication.setId(Integer.parseInt(id_post.getText()));
        publication.setPhoto(path.getText().substring(62));
        publication.setDescription(contenuPost.getText());
        ps.modifier(publication);
        ((Node)(event.getSource())).getScene().getWindow().hide();

    }
    @FXML
    public void annuler(ActionEvent event) {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
    @FXML
    public void uploadImage(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter FilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter FilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        FileChooser.ExtensionFilter FilterJPEG = new FileChooser.ExtensionFilter("JPEG files (*.jpeg)", "*.JPEG");
        fileChooser.getExtensionFilters().addAll(FilterPNG, FilterJPG, FilterJPEG);
        File file = fileChooser.showOpenDialog(null);
        BufferedImage bufferedImage = ImageIO.read(file);
        Image image = SwingFXUtils.toFXImage(bufferedImage, null);
        ImagePub.setImage(image);
        path.setText(file.getPath());
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        id_post.setText(String.valueOf(publicationController.currentpublication.getId()));
        contenuPost.setText(publicationController.currentpublication.getDescription());
        Image img = new Image(getClass().getResourceAsStream("/Images/" + publicationController.currentpublication.getPhoto()));
        ImagePub.setImage(img);






    }
}
