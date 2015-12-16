package server;

import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class allUsers {
    private final SimpleStringProperty name;
    private final SimpleStringProperty voterId;

    allUsers(String fName, String lName) {
        this.name = new SimpleStringProperty(fName);
        this.voterId = new SimpleStringProperty(lName);
    }

    public String getName() {
        return name.get();
    }
    public void setName(String fName) {
        name.set(fName);
    }

    public String getVoterId() {
        return voterId.get();
    }
    public void setVoterId(String fName) {
        voterId.set(fName);
    }

    public String toString() {
        return name + ", " + voterId ;
    }

}

