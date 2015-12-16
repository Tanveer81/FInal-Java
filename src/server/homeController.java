package server;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.util.Callback;
import util.NetworkUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Enumeration;
import java.sql.Connection;
import java.sql.ResultSet;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Callback;

public class homeController {
    Main main;
    void setMain(Main main){
        this.main=main;
        Image img = new Image(server.Main.class.getResourceAsStream("DMP logo.png"));
        dmpImage.setImage(img);
    }

    @FXML
    public TextArea postText;

    @FXML
     Button developers;

    @FXML
    private ImageView dmpImage;

    @FXML
    public TableView<Data> allPosts;

    @FXML
    public TableView<Data> usersonline;

    @FXML
     Button postButton;

    @FXML
     Button users;

    @FXML
     Button contacts;

    @FXML
     public Text notice;

    @FXML
     Button home;

    @FXML
     Button noticeButton;

    @FXML
     Button allPostsButton;




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
            //System.out.println(postText.getText());
            main.P.setNotice(postText.getText());
            main.mainnotice=postText.getText();
            notice.setText(postText.getText());
            main.P.setMood("policenotice");
            Enumeration<String> keys = main.hashtable.keys();
            while(keys.hasMoreElements()){
                String key = keys.nextElement();
                NetworkUtil nc=main.hashtable.get(key);
                nc.write(main.P);
                //System.out.println("Value of "+key+" is: "+hm.get(key));
            }
            postText.setText(null);

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

    @FXML
    void showAllUsers(ActionEvent event) {
        try {
            main.showNotice();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void initializeColumns() {
        TableColumn<Data, String> name = new TableColumn<>("Name");
        name.setMinWidth(100);
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        name.setCellFactory(TextFieldTableCell.<Data>forTableColumn());

        TableColumn<Data, String> post = new TableColumn<>("Post");
        post.setMinWidth(806);
        post.setCellValueFactory(new PropertyValueFactory<>("post"));
        post.setCellFactory(TextFieldTableCell.<Data>forTableColumn());

        TableColumn<Data, String> actionCol = new TableColumn<>("Action");
        actionCol.setCellValueFactory(new PropertyValueFactory<>("action"));

        Callback<TableColumn<Data, String>, TableCell<Data, String>> cellFactory =
                new Callback<TableColumn<Data, String>, TableCell<Data, String>>() {
                    @Override
                    public TableCell call(final TableColumn<Data, String> param) {
                        final TableCell<Data, String> cell = new TableCell<Data, String>() {
                            final Button btn = new Button("Seen");

                            @Override
                            public void updateItem(String item, boolean empty) {
                                super.updateItem(item, empty);
                                if (empty) {
                                    setGraphic(null);
                                    setText(null);
                                } else {
                                    // action of 'Select' button click
                                    btn.setOnAction((ActionEvent event) -> {
                                                main.data.remove(getIndex());
                                            }
                                    );
                                    setGraphic(btn);
                                    setText(null);
                                }
                            }
                        };
                        return cell;
                    }
                };
        actionCol.setCellFactory(cellFactory);

        allPosts.getColumns().addAll(name, post, actionCol);
    }

    }
