package com.selab.model;

import com.selab.model.Entity.Ad;
import com.selab.model.Entity.Asset;
import com.selab.model.Entity.Native;
import com.selab.model.Entity.NativeAd;
import com.selab.model.exception.AssetErrorException;
import com.selab.model.repository.AdRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Model {
    private final int DELAY_IN_SEC = 0;
    private final int PERIOD_IN_SEC = 60;
    private final int MILLISECOND = 1000;
    private AdRepository repository;

    public Model(AdRepository repository) {
        this.repository = repository;
    }

    public void execute() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                NativeAd nativeAd = Model.this.getNativeAd();
                try {
                    Model.this.saveAd(nativeAd);
                } catch (AssetErrorException e) {
                    e.printStackTrace();
                }
            }
        }, DELAY_IN_SEC, PERIOD_IN_SEC * MILLISECOND);
    }

    private NativeAd getNativeAd() {
        final String URI = "https://beta-ssp.tenmax.io/supply/mobile/native/rmax-ad?rmaxSpaceId=55ba76bca772421f&dpid=bd4b9b7903cf40ce&v=1";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(URI, NativeAd.class);
    }

    private void saveAd(NativeAd nativeAd) throws AssetErrorException {
        Ad ad = new Ad(nativeAd.getNative().getAssets());
        List<Ad> ads = (List<Ad>) this.repository.findAll();
        Long id = ads.isEmpty() ? 1 : this.getNextUnexistId(ads.get(ads.size() - 1).getId() + 1);
        ad.setId(id);
        if (this.repository.findByTitle(ad.getTitle()).isEmpty())
            this.repository.save(ad);
    }

    private Long getNextUnexistId(Long id) {
        if (this.isIdExist(id))
            return this.getNextUnexistId(id + 1);
        else
            return id;
    }

    private boolean isIdExist(Long id) {
        return !(this.repository.findOne(id) == null);
    }
}
