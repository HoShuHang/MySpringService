package com.selab.model;

import javax.persistence.Entity;
import javax.persistence.Id;

public class NativeAd {
    private Native nat;

    public void setNative(Native nat) {
        this.nat = nat;
    }

    public Native getNative() {
        return this.nat;
    }
}
