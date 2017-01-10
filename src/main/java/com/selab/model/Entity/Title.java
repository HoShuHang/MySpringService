package com.selab.model.Entity;

public class Title {
    private String text;

    public Title() {}

    public Title(String text) {
        this.setText(text);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
