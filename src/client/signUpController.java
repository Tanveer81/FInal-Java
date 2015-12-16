package client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by emon on 11/27/2015.
 */
public class signUpController {
    private Main main;
    @FXML
    private TextField vid;

    @FXML
    private TextField fname;

    @FXML
    private PasswordField repword;

    @FXML
    private TextField name;

    @FXML
    private PasswordField pword;

    @FXML
    private TextField mname;
    @FXML
    private Button signUp;
    @FXML
    private TextField address;
    @FXML
    private TextField peraddress;
    @FXML
    private TextField mno;

    public void setMain(Main main) {
        this.main = main;
    }

    public void setSignUp(ActionEvent event) throws Exception {
        try {
            if(name.getText().isEmpty()||fname.getText().isEmpty()||mname.getText().isEmpty()||pword.getText().isEmpty()||vid.getText().isEmpty()||address.getText().isEmpty()||peraddress.getText().isEmpty()||mno.getText().isEmpty()) {
                /*Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid");
                alert.setHeaderText("Cannot Sign Up");
                alert.setContentText("You must provide all informations");
                alert.showAndWait();*/
                main.popup("Cannot signup...You must provide all information");
            }
            else if(!main.picSet){
                main.popup("PLease select your photo...");
            }
             else{
                if(pword.getText().equals(repword.getText())) {
                    main.p.setName(name.getText());
                    main.p.setPassword(pword.getText());
                    main.p.setfName(fname.getText());
                    main.p.setmName(mname.getText());
                    main.p.setVoterId(vid.getText());
                    main.p.setPresentAddress(address.getText());
                    main.p.setPerAddress(peraddress.getText());
                    main.p.setMobileNo(mno.getText());
                    main.p.setMood("signup");
                    main.nc.write(main.p);
                    main.picSet=false;
                    //image loading
                    //byte[] data = Files.readAllBytes(path);
                    //main.p.aray=data;
                    main.showHome();
                }
               else{
                    /*Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Invalid");
                    alert.setHeaderText("Cannot Sign Up");
                    alert.setContentText("Password did not match");
                    alert.showAndWait();*/
                    main.popup("Can't sign up....Password didn't match");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @FXML
    void showHome(ActionEvent event) {
        try {
            main.showLogIn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    void uploadPic() throws IOException {
        String s=main.showFileChooser();
        if(main.picSet) {

            Path path = Paths.get(s);
            byte[] data = Files.readAllBytes(path);
            main.p.aray = data;
            //main.picSet = false;
        }
    }
    }

