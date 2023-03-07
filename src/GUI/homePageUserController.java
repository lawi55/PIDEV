package GUI;

import Services.ArtisteService;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class homePageUserController implements Initializable {

    private static homePageUserController instance;

    public homePageUserController() {
        instance = this;
    }

    public static homePageUserController getInstance() {
        return instance;
    }

    ArtisteService as = new ArtisteService();

    private Parent root;
    private Stage stage;
    private Scene scene;

    @FXML
    private VBox sugList;
    @FXML
    private TextField searchBar;
    public static int currentId = 0;


    @FXML
    private void showSuggestions(ActionEvent event) throws SQLException {
        sugList.getChildren().clear();
        List<String> names = new ArrayList<>(names(searchBar.getText()));
        System.out.println(names);
        int id = 0;
        for (int i = 0; i < names.size(); i++) {
            Button button = new Button();
            button.setText(names.get(i));
            button.setPrefWidth(970);
            button.setPrefHeight(40);
            button.setBorder(Border.EMPTY);
            button.setBackground(Background.EMPTY);
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        String s = button.getText();
                        System.out.println(button.getText());
                        currentId = as.recupurerId(s);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    Parent root = null;
                    try {
                        root = FXMLLoader.load(getClass().getResource("../GUI/viewUserProfile.fxml"));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    Scene scene = new Scene(root);
                    stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                }
            });
            sugList.getChildren().add(button);
        }
    }

    private List<String> names(String string) {
        ArtisteService as = new ArtisteService();
        List<String> ln = null;
        try {
            ln = as.search(string);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ln;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }
}
