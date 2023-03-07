package GUI;

import Entities.Commentaire;
import Entities.Publication;
import Entities.Save;
import Services.CommentaireService;
import Services.PublicationService;
import Services.ServiceSaves;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class publicationController implements Initializable {


    @FXML
    private Label descriptionpub;
    @FXML
    private VBox commentList;
    @FXML
    private ImageView imagepub;
    @FXML
    private Button comment;

    @FXML
    private Label comments;
    @FXML
    private Button like;
    @FXML
    private Button dislike;

    @FXML
    private Label likes;
    @FXML
    private Button save;
    @FXML
    private ImageView profilepic2;
    @FXML
    private Label commentCount;

    @FXML
    private Label saves;
    @FXML
    private Label id_post;
    @FXML
    private TextArea newComment;
    @FXML
    private HBox pub_card;

    Stage stage;
    public static Publication currentpublication = null;

    PublicationService ps = new PublicationService();
    CommentaireService cs = new CommentaireService();
    ServiceSaves ss = new ServiceSaves();

    @FXML
    public void addLikes(ActionEvent event) throws SQLException {
        Publication publication = new Publication();
        publication.setId(Integer.parseInt(id_post.getText()));
        ps.addLike(publication);
        like.setVisible(false);
        dislike.setVisible(true);
        likes.setText(String.valueOf(Integer.parseInt(likes.getText()) + 1));
    }


    @FXML
    public void postComment(KeyEvent keyEvent) throws SQLException {
        if(keyEvent.getCode() == KeyCode.ENTER) {
            String text = newComment.getText();
            Commentaire commentaire = new Commentaire();
            commentaire.setContenu(newComment.getText());
            commentaire.setPublication_id(Integer.parseInt(id_post.getText()));
            commentaire.setId_user(1);
            commentaire.setPhotoUser("goku.png");
            cs.ajouter(commentaire);
            newComment.setText("");
            showComment(commentaire);
            commentCount.setText(String.valueOf(cs.counting(Integer.parseInt(id_post.getText()))));
        }
    }

    @FXML
    public void removeLikes(ActionEvent event) throws SQLException {
        Publication publication = new Publication();
        publication.setId(Integer.parseInt(id_post.getText()));
        ps.removeLike(publication);
        dislike.setVisible(false);
        like.setVisible(true);
        likes.setText(String.valueOf(Integer.parseInt(likes.getText()) - 1));
    }





    @FXML
    public void delete(ActionEvent event) throws SQLException {
        Publication publication = new Publication();
        publication.setId(Integer.parseInt(id_post.getText()));
        int hashcode = pub_card.hashCode();
        Profilepage.getInstance().deleteNode(hashcode, publication);
    }

    @FXML
    public void update(ActionEvent event) throws SQLException {
        Publication publication = new Publication();
        publication.setDescription(descriptionpub.getText());
        publication.setId(Integer.parseInt(id_post.getText()));
        publication.setPhoto(ps.recupererphoto(publication.getId()));
        currentpublication = publication;
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../GUI/editpub.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root);
        stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void savePost(ActionEvent event) throws SQLException{
        Save save = new Save();
        save.setIdpost(Integer.parseInt(id_post.getText()));
        save.setIduser(1);
        ss.ajouter(save);
    }


    public void setData(Publication publication) throws SQLException{
        id_post.setText(String.valueOf(publication.getId()));
        Image img = new Image(getClass().getResourceAsStream("/Images/" + publication.getPhoto()));
        imagepub.setImage(img);
        descriptionpub.setText(publication.getDescription());
        likes.setText(String.valueOf(publication.getLikes()));
        Image img2 = new Image(getClass().getResourceAsStream("/Images/" + publication.getPhotoArtiste()));
        profilepic2.setImage(img2);
        loadComments(publication.getId());
        commentCount.setText(String.valueOf(cs.counting(publication.getId())));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void loadComments(int id_post) {
        List<Commentaire> commentaires = new ArrayList<>(commentaires(id_post));
        for (Commentaire commentaire : commentaires) {
            showComment(commentaire);
        }
    }
    public void showComment(Commentaire commentaire){
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("commentaire.fxml"));
        try {
            HBox hbox = fxmlLoader.load();
            commentaireController cc = fxmlLoader.getController();
            cc.setData(commentaire);
            commentList.getChildren().add(hbox);
        } catch (IOException e) {
            System.out.println("Erreur 000000");
        }
    }

    private List<Commentaire> commentaires(int id) {
        CommentaireService cs = new CommentaireService();
        List<Commentaire> lc = null;
        try {
            lc = cs.recupererparId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lc;
    }


}