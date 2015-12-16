package server;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class profileController {
    Main main;
    void setMain(Main main,String n){
        this.main=main;
        Image img = new Image(server.Main.class.getResourceAsStream("DMP logo.png"));
        dmpImage.setImage(img);
       //Image img2 = new Image(server.Main.class.getResourceAsStream("DMP logo.png"));
        String s="F:\\PROJECT FINAL\\Police Control Box\\src\\server\\clientPhotos\\"+n+".jpg";
        Image img2 = new Image(server.Main.class.getResourceAsStream(s));
        proPic.setImage(img2);
    }


    @FXML
    private Button noticeButton;

    @FXML
     Text occupation;

    @FXML
    private Button developers;

    @FXML
    private ImageView dmpImage;

    @FXML
    private ImageView proPic;

    @FXML
    private Button allPosts;

    @FXML
    private Button home;

    @FXML
     Text religion;

    @FXML
     Text fName;

    @FXML
    Text mobile;

    @FXML
     Text presentAddress;

    @FXML
     Text name;

    @FXML
     Text voterID;

    @FXML
     Text permanentAddress;

    @FXML
     Text mName;

    @FXML
    private Button contacts;

    @FXML
     Text notice;

    @FXML
    public TextField emni;

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
    void showContacts(ActionEvent event) {
        try {
            main.showContacts();
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
