package com.selab.model.Entity;

public class Data {
    private String value;

    public Data() {}

    public Data(String value) {
        this.setValue(value);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
