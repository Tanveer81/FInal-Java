package server;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.util.Callback;
import util.Person;

import java.sql.ResultSet;

public class noticeController {
    Main main;
    void setMain(Main main){
        this.main=main;
        Image img = new Image(server.Main.class.getResourceAsStream("DMP logo.png"));
        dmpImage.setImage(img);
    }

    @FXML
    private TextArea postText;

    @FXML
    private Button developers;

    @FXML
    private ImageView dmpImage;

    @FXML
    private Button allPosts;

    @FXML
    private TableView<allUsers> newsFeed;

    @FXML
    private Button postButton;

    @FXML
    private Button users;

    @FXML
    private Button contacts;

    @FXML
    private Text notice;

    @FXML
    private Button home;

    @FXML
    private Button updateNotice;

    @FXML
    public TableView<allUsers> Allusers;

    @FXML
    void updateNotice(ActionEvent event) {

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
    void showContacts(ActionEvent event) {
        try {
            main.showContacts();
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

    void initializeColumns() {
        TableColumn<allUsers, String> firstNameCol = new TableColumn<>("Name");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        firstNameCol.setCellFactory(TextFieldTableCell.<allUsers>forTableColumn());

       /* firstNameCol.setOnEditCommit(
                (TableColumn.CellEditEvent<allUsers, String> t) -> {
                    ((allUsers) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setName(t.getNewValue());
                }
        );*/

        TableColumn<allUsers, String> lastNameCol = new TableColumn<>("VoterID");
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("voterId"));
        lastNameCol.setCellFactory(TextFieldTableCell.<allUsers>forTableColumn());

        /*lastNameCol.setOnEditCommit(
                (TableColumn.CellEditEvent<allUsers, String> t) -> {
                    ((allUsers) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setVoterId(t.getNewValue());
                }
        );*/


        TableColumn<allUsers, String> actionCol = new TableColumn<>("Action");
        actionCol.setCellValueFactory(new PropertyValueFactory<>("action"));

        Callback<TableColumn<allUsers, String>, TableCell<allUsers, String>> cellFactory =
                new Callback<TableColumn<allUsers, String>, TableCell<allUsers, String>>() {
                    @Override
                    public TableCell call( final TableColumn<allUsers, String> param ) {
                        final TableCell<allUsers, String> cell = new TableCell<allUsers, String>() {

                            final Button btn = new Button("Profile");

                            @Override
                            public void updateItem(String item, boolean empty) {
                                super.updateItem( item, empty );
                                if (empty) {
                                    setGraphic(null);
                                    setText(null);
                                }
                                else {
                                    // action of 'Select' button click
                                    btn.setOnAction((ActionEvent event) -> {

                                        //System.out.println(getTableView().getItems().get(getIndex()).getVoterId());
                                        //System.out.println(getTableView().getItems().get(getIndex()).getName());
                                        //main.getProfile(getTableView().getItems().get(getIndex()).getVoterId());
                                        //System.out.println(main.q.getName());
                                       // System.out.println(main.q.getfName());
                                       // System.out.println(main.q.getEmail());
                                        try {
                                            main.showProfile(getTableView().getItems().get(getIndex()).getVoterId());
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }

                                    });
                                    setGraphic(btn);
                                    setText(null);
                                }
                            }
                        };
                        return cell;
                    }
                };
        actionCol.setCellFactory(cellFactory);

        Allusers.getColumns().addAll(firstNameCol, lastNameCol, actionCol);
    }


}
