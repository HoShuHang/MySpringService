package com.selab.model.Entity;

import java.util.List;

public class Native {
    private List<String> viewEvent;
    private Link link;
    private List<Asset> assets;
    private List<String> impressionEvent;

    public void setViewEvent(List<String> viewEvent) {
        this.viewEvent = viewEvent;
    }

    public List<String> getViewEvent() {
        return this.viewEvent;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public Link getLink() {
        return this.link;
    }

    public void setAssets(List<Asset> assets) {
        this.assets = assets;
    }

    public List<Asset> getAssets() {
        return this.assets;
    }

    public void setImpressionEvent(List<String> impressionEvent) {
        this.impressionEvent = impressionEvent;
    }

    public List<String> getImpressionEvent() {
        return this.impressionEvent;
    }
}
