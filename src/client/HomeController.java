package client;

/**
 * Created by emon on 11/27/2015.
 */
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HomeController {
    private Main main;
    public void setMain(Main main) {
        this.main=main;
        Image img = new Image(server.Main.class.getResourceAsStream("DMP logo.png"));
        dmpImage.setImage(img);
    }
    @FXML
    private Button Home;
    public void sendpost(){
        try{
        main.p.setPost(postText.getText());
        main.p.allposts.add(postText.getText());
        main.p.setMood("post");
           // Path path = Paths.get("F:\\PROJECT FINAL\\Police Control Box\\src\\client\\1.mpg");
            //byte[] data = Files.readAllBytes(path);
            //main.p.aray=data;
        main.nc.write(main.p);
        }catch(Exception e){
            System.out.println(e);
        }
        postText.setText(null);
    }
    @FXML
    private Button postButton;

    @FXML
    private Button post2;

    @FXML
    private TextArea postText;

    @FXML
    private Button noticeButton;

    @FXML
    private MenuButton post;

    @FXML
    private Button developers;

    @FXML
    private Button profile;

    @FXML
    private ImageView dmpImage;

    @FXML
    private TableView<?> allPosts;

    @FXML
    private Button contacts;

    @FXML
    public Text notice;

    @FXML
    private Button allPostsButton;

    @FXML
    void showContacts(ActionEvent event) {
        try {
            main.showContacts();
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
    void showMyPosts(ActionEvent event) {
        try {
            main.showMyPosts();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void showHome(ActionEvent event) {
        try {
            main.showHome();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void showNotice(ActionEvent event) {
        try {
            main.showNotice();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void showProfile(ActionEvent event) {
        try {
            main.showProfile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

