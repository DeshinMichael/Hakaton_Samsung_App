package com.example.hackathon_httpclienterror_400.domain;

public class User {

    private long id;
    private String name;
    private String email;
    private String photoUrl;
    private String phone;
    private int progress;
    private String password;

    public User(long id, String name, String email, String photoUrl, String phone, int progress, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.photoUrl = photoUrl;
        this.phone = phone;
        this.progress = progress;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public String getPhone() {
        return phone;
    }

    public String getProgress() {return Integer.toString(progress);}

    public String getPassword() {return Integer.toString(password.hashCode());}

}
