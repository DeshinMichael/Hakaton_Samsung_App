package com.example.hackathon_httpclienterror_400.domain;

public class User {

    private long id;
    private String name;
    private String email;
    private String photoUrl;
    private String phone;
    private int progress;

    public User(long id, String name, String email, String photoUrl, String phone, int progress) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.photoUrl = photoUrl;
        this.phone = phone;
        this.progress = progress;
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

    public int getProgress() {
        return progress;
    }
}
