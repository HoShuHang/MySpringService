package com.selab.model.Entity;

import java.util.List;

public class Link {
    private String url;
    private List<String> clicktrackers;

    public Link() {}

    public Link(String url) {
        this.setUrl(url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setClickTrackers(List<String> clickTrackers) {
        this.clicktrackers = clickTrackers;
    }

    public List<String> getClicktrackers() {
        return this.clicktrackers;
    }
}
