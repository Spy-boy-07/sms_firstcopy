package com.spydison.sms;


public class User {

    private boolean isCheked = false;
    public String username;
    public String name;
    public String email;
    public String userid;
//    public String pass;

    public User(){
    }

    public User(String username, String name, String email) {
        this.username = username;
        this.name = name;
        this.email = email;
//        this.pass = pass;
    }

    public boolean isCheked() {
        return isCheked;
    }

    public void setCheked(boolean cheked) {
        isCheked = cheked;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
