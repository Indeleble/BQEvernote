package com.gcv.bqevernote.model;


import android.util.Log;

import java.util.Random;

public class BQNote {

    String title;
    String content;

    public BQNote() {
        populate();
    }

    public BQNote(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public BQNote(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private void populate() {

        String title = "";
        String content = "";

        for (int i = 0; i < 3; i++) {
            title = title + " " + getRandomString();
        }
        for (int i = 0; i < 8; i++) {
            content = content + " " + getRandomString();
        }

        while (title.startsWith(" ")) {
            title = title.substring(1);
        }

        this.title = title;
        this.content = content;

        Log.d("Note created", "Title: " + title + " Content: " + content);
    }

    public static String getRandomString() {

        Random generator = new Random();
        StringBuilder randomStringBuilder = new StringBuilder();
        int randomLength = generator.nextInt(5);
        char tempChar;
        for (int i = 0; i < randomLength; i++) {
            tempChar = (char) (Math.random() * 26 + 'a');
            randomStringBuilder.append(tempChar);
        }

        return randomStringBuilder.toString();
    }
}
