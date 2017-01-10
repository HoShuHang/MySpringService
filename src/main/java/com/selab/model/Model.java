package com.selab.model;

import com.selab.model.Entity.Ad;
import com.selab.model.Entity.ImpressionEvent;
import com.selab.model.Entity.Native;
import com.selab.model.Entity.NativeAd;
import com.selab.model.exception.AssetErrorException;
import com.selab.model.repository.AdRepository;
import com.selab.model.repository.ImpressiveEventRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.Null;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Model {
    private final int DELAY_IN_SEC = 0;
    private final int PERIOD_IN_SEC = 60;
    private final int MILLISECOND = 1000;
    private AdRepository adRepository;
    private ImpressiveEventRepository impressiveEventRepository;

    public Model(AdRepository adRepository, ImpressiveEventRepository impressiveEventRepository) {
        this.adRepository = adRepository;
        this.impressiveEventRepository = impressiveEventRepository;
    }

    public void execute() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    NativeAd nativeAd = Model.this.getNativeAd();
                    if(nativeAd.getNative() != null) {
                        Long adId = Model.this.saveAd(nativeAd);
                        Model.this.saveUrl(nativeAd.getNative(), adId);
                    }
                } catch (AssetErrorException e) {
                    e.printStackTrace();
                } catch (HttpServerErrorException e) {
                    System.out.println(e.getStatusCode());
                }
            }
        }, DELAY_IN_SEC, PERIOD_IN_SEC * MILLISECOND);
    }

    private NativeAd getNativeAd() {
        final String URI = "https://beta-ssp.tenmax.io/supply/mobile/native/rmax-ad?rmaxSpaceId=55ba76bca772421f&dpid=bd4b9b7903cf40ce&v=1";
        RestTemplate restTemplate = new RestTemplate();
        try {
            return restTemplate.getForObject(URI, NativeAd.class);
        } catch (HttpServerErrorException e) {
            throw new HttpServerErrorException(e.getStatusCode());
        }
    }

    private Long saveAd(NativeAd nativeAd) throws AssetErrorException{
        Ad ad = new Ad(nativeAd.getNative().getAssets());
        List<Ad> ads = (List<Ad>) this.adRepository.findAll();
        Long id = ads.isEmpty() ? 1 : this.getNextUnexistId(ads.get(ads.size() - 1).getId() + 1);
        ad.setId(id);
        if (this.adRepository.findByTitle(ad.getTitle()).isEmpty())
            this.adRepository.save(ad);
        return id;
    }

    private void saveUrl(Native nat, Long adId) {
        if (this.impressiveEventRepository.findByAdId(adId).isEmpty()) {
            for (String str : nat.getImpressionEvent()) {
                this.impressiveEventRepository.save(new ImpressionEvent(str, adId, this.impressiveEventRepository));
            }
        }
    }

    private Long getNextUnexistId(Long id) {
        if (this.isIdExist(id))
            return this.getNextUnexistId(id + 1);
        else
            return id;
    }

    private boolean isIdExist(Long id) {
        return !(this.adRepository.findOne(id) == null);
    }
}
