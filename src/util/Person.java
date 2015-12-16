package util;

import javafx.beans.property.SimpleStringProperty;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by emon on 11/28/2015.
 */

public class Person implements Serializable {
    private boolean validlogin;
    private String mood;
    private String name;
    private String password;
    private String post;
    private String voterId;
    private String mobileNo;
    private String fName;
    private String mName;
    private String presentAddress;
    private  String perAddress;
    private String clientpost;
    private String notice;
    private String policepost;
    private String dob;
    public byte aray[];
    

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getPolicepost() {
        return policepost;
    }

    public void setPolicepost(String policepost) {
        this.policepost = policepost;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;
    public List<String> allposts = new ArrayList<String>();
    public boolean isValidlogin() {
        return validlogin;
    }

    public void setValidlogin(boolean validlogin) {
        this.validlogin = validlogin;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }
    public String getClientpost() {
        return mobileNo;
    }

    public void setClientpost(String clientpost) {
        this.clientpost = clientpost;
    }
    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public void setVoterId(String voterId) {
        this.voterId = voterId;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

    public void setPerAddress(String perAddress) {
        this.perAddress = perAddress;
    }

    public String getName() {
        return name;
    }

    public String getPost() {
        return post;
    }

    public String getVoterId() {
        return voterId;
    }

    public String getfName() {
        return fName;
    }

    public String getmName() {
        return mName;
    }

    public String getPresentAddress() {
        return presentAddress;
    }

    public String getPerAddress() {
        return perAddress;
    }

}
