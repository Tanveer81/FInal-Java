package client;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import util.NetworkUtil;
import util.Person;

/**
 * Created by emon on 11/28/2015.
 */

public class ReadThread implements Runnable {
    private Thread thr;
    private NetworkUtil nc;
    Main main;

    public ReadThread(NetworkUtil nc,Main main) {
        this.nc = nc;
        this.thr = new Thread(this);
        this.main=main;
        thr.start();
    }

    public void run() {
        try {
            while(true) {
                Object o=nc.read();
                if(o!= null) {
                    if(o instanceof Person) {
                        Person obj=(Person)o;
                        main.p=obj;
                        main.mainnotice=obj.getNotice();
                       //main.homeControl.notice.setText(obj.getNotice());
                        /*Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                main.updateprofile();
                            }});*/
                        System.out.println(obj.isValidlogin());
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                if(obj.getMood().equals("login")){
                                    if(obj.isValidlogin()){
                                        try {
                                            main.showHome();
                                        } catch (Exception e) {
                                        e.printStackTrace();
                                        }
                                    }
                                    else{
                                        Alert alert = new Alert(Alert.AlertType.ERROR);
                                        alert.setTitle("Invalid");
                                        alert.setHeaderText("Cannot Sign Up");
                                        alert.setContentText("Password did not match");
                                        alert.showAndWait();
                                    }
                                }
                                else if(obj.getMood().equals("signup")){
                                    //main.homeControl.notice.setText(obj.getNotice());
                                    Alert alert = new Alert(Alert.AlertType.ERROR);
                                    alert.setTitle("Successful");
                                    alert.setHeaderText("Congtratulation");
                                    alert.setContentText("You have been signed up successfully");
                                    alert.showAndWait();
                                }
                                else if(obj.getMood().equals("posted")){
                                    Alert alert = new Alert(Alert.AlertType.ERROR);
                                    alert.setTitle("Successful");
                                    alert.setHeaderText("Congtratulation");
                                    alert.setContentText("You have posted successfully");
                                    alert.showAndWait();
                                }
                                else if(obj.getMood().equals("policenotice")){
                                    main.homeControl.notice.setText(obj.getNotice());
                                    System.out.println(obj.getNotice());
                                }

                            }});
                    }
                    }
                }
            }
        catch(Exception e) {
            System.out.println (e+"readThread");
        }
        //nc.closeConnection();
}
}

