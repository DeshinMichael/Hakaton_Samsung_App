package com.example.hackathon_httpclienterror_400.domain;

public class Lesson {

    private String title;
    private String text;

    public Lesson(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
