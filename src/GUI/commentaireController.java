package GUI;

import Entities.Artiste;
import Entities.Commentaire;
import Entities.Publication;
import Entities.Utilisateur;
import Services.CommentaireService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class commentaireController implements Initializable {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea comment;
    @FXML
    private Label likes;
    @FXML
    private Button like;
    @FXML
    private Button dislike;
    @FXML
    private Label idcomment;
    @FXML
    private Label id_post;

    @FXML
    private ImageView userpic;


    CommentaireService cs = new CommentaireService();

    public void setData(Commentaire commentaire) {
        id_post.setText(String.valueOf(commentaire.getPublication_id()));
        idcomment.setText(String.valueOf(commentaire.getId()));
        comment.setText(commentaire.getContenu());
        Image usrImg = new Image(getClass().getResourceAsStream("/Images/" + commentaire.getPhotoUser()));
        userpic.setImage(usrImg);
        likes.setText(String.valueOf(commentaire.getLikes()));
    }

    @FXML
    public void addLikes(ActionEvent event) throws SQLException {
        Commentaire commentaire = new Commentaire();
        commentaire.setId(Integer.parseInt(idcomment.getText()));
        cs.addLike(commentaire);
        like.setVisible(false);
        dislike.setVisible(true);
        likes.setText(String.valueOf(Integer.parseInt(likes.getText()) + 1));
    }

    @FXML
    public void removeLikes(ActionEvent event) throws SQLException {
        Commentaire commentaire = new Commentaire();
        commentaire.setId(Integer.parseInt(idcomment.getText()));
        cs.removeLike(commentaire);
        dislike.setVisible(false);
        like.setVisible(true);
        likes.setText(String.valueOf(Integer.parseInt(likes.getText()) - 1));
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }


}
