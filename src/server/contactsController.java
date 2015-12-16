package server;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
public class contactsController {
    Main main;
    void setMain(Main main){
        this.main=main;
        Image img = new Image(server.Main.class.getResourceAsStream("DMP logo.png"));
        dmpImage.setImage(img);
    }

    @FXML
    private Text notice;

    @FXML
    private TextArea postText;

    @FXML
    private Button developers;

    @FXML
    private ImageView dmpImage;

    @FXML
    private Button allPosts;

    @FXML
    private Button home;

    @FXML
    private TableView<?> newsFeed;

    @FXML
    private Button postButton;

    @FXML
    private Button users;

    @FXML
    private Button contacts;

    @FXML
    private Button noticeButton;

    @FXML
    void sendPost(ActionEvent event) {

    }

    @FXML
    void showUsers(ActionEvent event) {
        try {
            main.showUsers();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void showDevelopers(ActionEvent event) {
        try {
            main.showDevelopers();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void updateNotice(ActionEvent event) {
        try {
            main.showNotice();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void showHome(ActionEvent event) {
        try {
            main.showPoliceHome();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void showAllPosts(ActionEvent event) {
        try {
            main.showAllPosts();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
