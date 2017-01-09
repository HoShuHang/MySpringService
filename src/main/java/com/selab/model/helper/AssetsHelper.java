package com.selab.model.helper;

import com.selab.model.Entity.Asset;
import com.selab.model.Entity.Img;
import com.selab.model.exception.AssetErrorException;

import java.util.List;

public class AssetsHelper {
    private final String ICON_CHARACTER = "icon";
    private List<Asset> assets;

    public AssetsHelper(List<Asset> assets) {
        this.assets = assets;
    }

    public String getTitle() throws AssetErrorException {
        for (Asset asset : this.assets) {
            if (asset.getTitle() != null)
                return asset.getTitle().getText();
        }
        throw new AssetErrorException();
    }

    public String getDescription() throws AssetErrorException {
        for (Asset asset : this.assets) {
            if (asset.getData() != null)
                return asset.getData().getValue();
        }
        throw new AssetErrorException();
    }

    public String getImgUrl() throws AssetErrorException {
        final String CHARACTER_M = "_m";
        final String CHARACTER_S = "_s";
        for (Asset asset : this.assets) {
            Img img = asset.getImg();
            if (img != null && !img.getUrl().contains(ICON_CHARACTER) && !img.getUrl().contains(CHARACTER_M) && !img.getUrl().contains(CHARACTER_S))
                return img.getUrl();
        }
        throw new AssetErrorException();
    }

    public String getImgMUrl() throws AssetErrorException {
        final String CHARACTER = "_m";
        for (Asset asset : this.assets) {
            Img img = asset.getImg();
            if (img != null && img.getUrl().contains(CHARACTER) && !img.getUrl().contains(ICON_CHARACTER))
                return img.getUrl();
        }
        throw new AssetErrorException();
    }

    public String getImgSUrl() throws AssetErrorException {
        final String CHARACTER = "_s";
        for (Asset asset : this.assets) {
            Img img = asset.getImg();
            if (img != null && img.getUrl().contains(CHARACTER) && !img.getUrl().contains(ICON_CHARACTER))
                return img.getUrl();
        }
        throw new AssetErrorException();
    }

    public String getIconUrl() throws AssetErrorException {
        final String CHARACTER_L = "_l";
        final String CHARACTER_S = "_s";
        for (Asset asset : this.assets) {
            Img img = asset.getImg();
            if (img != null && !img.getUrl().contains(CHARACTER_L) && !img.getUrl().contains(CHARACTER_S) && img.getUrl().contains(ICON_CHARACTER))
                return img.getUrl();
        }
        throw new AssetErrorException();
    }

    public String getIconLUrl() throws AssetErrorException {
        final String CHARACTER = "_l";
        for (Asset asset : this.assets) {
            Img img = asset.getImg();
            if (img != null && img.getUrl().contains(CHARACTER) && img.getUrl().contains(ICON_CHARACTER))
                return img.getUrl();
        }
        throw new AssetErrorException();
    }

    public String getIconSUrl() throws AssetErrorException {
        final String CHARACTER = "_s";
        for (Asset asset : this.assets) {
            Img img = asset.getImg();
            if (img != null && img.getUrl().contains(CHARACTER) && img.getUrl().contains(ICON_CHARACTER))
                return img.getUrl();
        }
        throw new AssetErrorException();
    }
}
