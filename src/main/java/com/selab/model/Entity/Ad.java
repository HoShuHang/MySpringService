package com.selab.model.Entity;

import com.selab.model.helper.AssetsHelper;
import com.selab.model.exception.AssetErrorException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Entity
public class Ad {
    @Id
    private Long id;
    @Column(unique=true, length = 1000)
    private String title;
    private String description;
    private String imgUrl, imgMUrl, imgSUrl;
    private String iconUrl, iconLUrl, iconSUrl;
    private String link;

    public Ad() {}

    public Ad(List<Asset> assets) throws AssetErrorException {
        AssetsHelper assetsHelper = new AssetsHelper(assets);
        this.title = assetsHelper.getTitle();
        this.description = assetsHelper.getDescription();
        this.imgUrl = assetsHelper.getImgUrl();
        this.imgMUrl = assetsHelper.getImgMUrl();
        this.imgSUrl = assetsHelper.getImgSUrl();
        this.iconUrl = assetsHelper.getIconUrl();
        this.iconLUrl = assetsHelper.getIconLUrl();
        this.iconSUrl = assetsHelper.getIconSUrl();
        this.link = assetsHelper.getLink();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getImgMUrl() {
        return imgMUrl;
    }

    public void setImgMUrl(String imgMUrl) {
        this.imgMUrl = imgMUrl;
    }

    public String getImgSUrl() {
        return imgSUrl;
    }

    public void setImgSUrl(String imgSUrl) {
        this.imgSUrl = imgSUrl;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getIconLUrl() {
        return iconLUrl;
    }

    public void setIconLUrl(String iconLUrl) {
        this.iconLUrl = iconLUrl;
    }

    public String getIconSUrl() {
        return iconSUrl;
    }

    public void setIconSUrl(String iconSUrl) {
        this.iconSUrl = iconSUrl;
    }

    private Object getValueInAssets(String key, List<Map> assets) {
        Iterator iterator = assets.iterator();
        while(iterator.hasNext()) {
            Map map = (Map) iterator.next();
            if(map.containsKey(key))
                return map.get(key);
        }
        return null;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
