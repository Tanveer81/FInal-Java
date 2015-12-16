package client;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import util.NetworkUtil;
import util.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.Button;
import java.io.File;
import java.util.ArrayList;

public class Main extends Application {

    Stage stage;
    HomeController homeControl;
    myPostsController PostControl;
    developerController developerControl;
    noticeController noticeControl;
    contactsController contactsControl;
    signUpController signUpControl;
    logInController logInControl;
    profileController profileControl;
    public ArrayList<String> message=new ArrayList<String>();
    public Client client;
    public Person p=new Person();
    public NetworkUtil nc;
    public boolean hasgot=false;
    public boolean a=false;
    public String s="login";
    public String mainnotice;
    public boolean picSet=false;

    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
            String serverAddress="127.0.0.1";
            int serverPort=33333;
            NetworkUtil n1 = new NetworkUtil(serverAddress,serverPort);
            new ReadThread(n1,this);
            nc=n1;
            stage = primaryStage;
            showLogIn();
        } catch(Exception e) {
            System.out.println (e+"main");
        }
    }

    public void showLogIn() throws Exception {
        //nc.write("ami");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("logIn.fxml"));
        Parent root = loader.load();
        logInController controller = loader.getController();
        //scontroller=controller;
        stage.setTitle("Client");
        stage.setScene(new Scene(root, 1000, 600));
        stage.setResizable(false);
        controller.setMain(this);
        //stage.initStyle(StageStyle.UNDECORATED);
        stage.show();


    }

    public void showSignUp() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Signup.fxml"));
        Parent root = loader.load();
        signUpController controller = loader.getController();
        //mcontroller=controller;
        stage.setTitle("Client");
        stage.setScene(new Scene(root, 1000, 600));
        stage.setResizable(false);
        controller.setMain(this);
        //stage.initStyle(StageStyle.UNDECORATED);
        stage.show();

    }
    public void showHome() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Home.fxml"));
        Parent root = loader.load();
        HomeController controller = loader.getController();
        controller.notice.setText(mainnotice);
        homeControl=controller;
        stage.setTitle("Client");
        stage.setScene(new Scene(root, 1000, 600));
        stage.setResizable(false);
        controller.setMain(this);
        //stage.initStyle(StageStyle.UNDECORATED);
        stage.show();

    }
    public void showMyPosts() throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("myPosts.fxml"));
        Parent root = loader.load();

        // Loading the controller
        myPostsController controller = loader.getController();
        controller.setMain(this);
        PostControl=controller;

        // Set the primary stage
        stage.setTitle("Police Control Box");
        stage.setScene(new Scene(root, 1000, 600));
        stage.show();
        stage.setResizable(false);
    }

    public void showContacts() throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("contacts.fxml"));
        Parent root = loader.load();

        // Loading the controller
        contactsController controller = loader.getController();
        controller.setMain(this);
        contactsControl=controller;

        // Set the primary stage
        stage.setTitle("Police Control Box");
        stage.setScene(new Scene(root, 1000, 600));
        stage.show();
        stage.setResizable(false);
    }

    public void showDevelopers() throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("developer.fxml"));
        Parent root = loader.load();

        // Loading the controller
        developerController controller = loader.getController();
        controller.setMain(this);
        developerControl=controller;

        // Set the primary stage
        stage.setTitle("Police Control Box");
        stage.setScene(new Scene(root, 1000, 600));
        stage.show();
        stage.setResizable(false);
    }

    public void showNotice() throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("notice.fxml"));
        Parent root = loader.load();

        // Loading the controller
        noticeController controller = loader.getController();
        controller.setMain(this);
        noticeControl=controller;

        // Set the primary stage
        stage.setTitle("Police Control Box");
        stage.setScene(new Scene(root, 1000, 600));
        stage.show();
        stage.setResizable(false);
    }

    public void showProfile() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("profile.fxml"));
        Parent root = loader.load();
        profileController controller = loader.getController();
        controller.setMain(this);
        profileControl=controller;
        stage.setTitle("Client");
        stage.setScene(new Scene(root, 1000, 600));
        stage.show();
        stage.setResizable(false);
        profileControl.name.setText(p.getName());
        profileControl.fName.setText(p.getfName());
        profileControl.mName.setText(p.getmName());
        profileControl.mobileNo.setText(p.getMobileNo());
        profileControl.permanentAddress.setText(p.getPerAddress());
        profileControl.presentAddress.setText(p.getPresentAddress());
        profileControl.voterID.setText(p.getVoterId());
        Integer i=p.allposts.size();
        String s=Integer.toString(i);
        profileControl.totalPosts.setText(s);
    }

    public void popup(String s){
        String message = s;

        String header = "Notification message";

        JFrame frame = new JFrame();

        frame.setSize(300, 125);

        frame.setUndecorated(true);

        frame.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 0;

        constraints.gridy = 0;

        constraints.weightx = 1.0f;

        constraints.weighty = 1.0f;

        constraints.insets = new Insets(5, 5, 5, 5);

        constraints.fill = GridBagConstraints.BOTH;

        JLabel headingLabel = new JLabel(header);

        //headingLabel .setIcon(headingIcon); // --- use image icon you want to be as heading image.

        headingLabel.setOpaque(false);

        frame.add(headingLabel, constraints);

        constraints.gridx++;

        constraints.weightx = 0f;

        constraints.weighty = 0f;

        constraints.fill = GridBagConstraints.NONE;

        constraints.anchor = GridBagConstraints.NORTH;

        //JButton cloesButton = new JButton("X");
        JButton cloesButton = new JButton(new AbstractAction("x") {

            @java.lang.Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                frame.dispose();
            }

        });

        cloesButton.setMargin(new Insets(1, 4, 1, 4));

        cloesButton.setFocusable(false);

        frame.add(cloesButton, constraints);

        constraints.gridx = 0;

        constraints.gridy++;

        constraints.weightx = 1.0f;

        constraints.weighty = 1.0f;

        constraints.insets = new Insets(5, 5, 5, 5);

        constraints.fill = GridBagConstraints.BOTH;

        JLabel messageLabel = new JLabel("<HtMl>" + message);

        frame.add(messageLabel, constraints);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setVisible(true);

        Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();// size of the screen

        Insets toolHeight = Toolkit.getDefaultToolkit().getScreenInsets(frame.getGraphicsConfiguration());// height of the task bar

        frame.setLocation(scrSize.width - frame.getWidth(), scrSize.height - toolHeight.bottom - frame.getHeight());

        frame.setAlwaysOnTop(true);

        new Thread(){

            @java.lang.Override


            public void run() {

                try {

                    Thread.sleep(5000); // time after which pop up will be disappeared.

                    frame.dispose();

                } catch (InterruptedException e) {

                    e.printStackTrace();

                }

            };

        }.start();
    }

    public String showFileChooser() {
        String s="not choosen";
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select your Picture");
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            picSet=true;
            s=file.getAbsolutePath();
        }

        return s;
    }


    public static void main(String[] args) {
        launch(args);
    }
}