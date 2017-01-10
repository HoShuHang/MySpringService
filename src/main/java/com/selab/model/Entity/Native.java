package com.selab.model.Entity;

import java.util.ArrayList;
import java.util.List;

public class Native {
    private List<String> viewEvent;
    private Link link;
    private List<Asset> assets;
    private List<String> impressionEvent;

    public Native() {}

    public Native(Ad ad, List<String> impressionEvent) {
        this.setLink(new Link(ad.getLink()));
        this.setAssets(this.createAssets(ad));
        this.setImpressionEvent(impressionEvent);
    }

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

    private List<Asset> createAssets(Ad ad) {
        List<Asset> assets = new ArrayList<>();
        Asset titleAsset = new Asset(1);
        titleAsset.setTitle(new Title(ad.getTitle()));
        Asset iconAsset = new Asset(2);
        iconAsset.setImg(new Img(ad.getIconUrl()));
        Asset imgMAsset = new Asset(3);
        imgMAsset.setImg(new Img(ad.getImgMUrl()));
        Asset descriptionAsset = new Asset(4);
        descriptionAsset.setData(new Data(ad.getDescription()));
        Asset linkAsset = new Asset(5);
        linkAsset.setLink(new Link(ad.getLink()));
        Asset imgAsset = new Asset(6);
        imgAsset.setImg(new Img(ad.getImgUrl()));
        Asset imgSAsset = new Asset(7);
        imgSAsset.setImg(new Img(ad.getImgSUrl()));
        Asset iconLAsset = new Asset(8);
        iconLAsset.setImg(new Img(ad.getIconLUrl()));
        Asset iconSAsset = new Asset(9);
        iconSAsset.setImg(new Img(ad.getIconSUrl()));
        assets.add(titleAsset);
        assets.add(iconAsset);
        assets.add(imgMAsset);
        assets.add(descriptionAsset);
        assets.add(linkAsset);
        assets.add(imgAsset);
        assets.add(imgSAsset);
        assets.add(iconLAsset);
        assets.add(iconSAsset);
        return assets;
    }
}
