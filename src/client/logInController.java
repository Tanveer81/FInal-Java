package client;

/**
 * Created by emon on 11/27/2015.
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class logInController {
    private Main main;
    public void setMain(Main main) {
        this.main = main;
    }
    @FXML
    private TextField Uname;

    @FXML
    private PasswordField Pword;

    public void logInAction(ActionEvent event){
        try {
            main.p.setName(Uname.getText());
            main.p.setPassword(Pword.getText());
            main.p.setMood("login");
            main.nc.write(main.p);
        } catch (Exception e) {
            System.out.println(e+"logController");
        }
    }

    public void signUpAction(ActionEvent event) {
        try {
            main.showSignUp();
        }catch (Exception e)
        {
        }
    }
}
