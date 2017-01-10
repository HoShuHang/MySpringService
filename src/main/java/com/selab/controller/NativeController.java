package com.selab.controller;

import com.selab.model.Entity.Ad;
import com.selab.model.Entity.ImpressionEvent;
import com.selab.model.Entity.Link;
import com.selab.model.Entity.Native;
import com.selab.model.repository.AdRepository;
import com.selab.model.repository.AdRepositoryCustom;
import com.selab.model.repository.ImpressiveEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NativeController implements AdRepositoryCustom {
    @Autowired
    private AdRepository adRepository;
    @Autowired
    private ImpressiveEventRepository impressiveEventRepository;

    @RequestMapping("/native")
    public ResponseEntity<List<Native>> getAdByStr(@RequestParam("title") String title) {
        List<Native> natives = new ArrayList<>();
        List<Ad> ads = this.findByString(title);
        for(Ad ad : ads) {
            List<ImpressionEvent> impressionEvents = this.impressiveEventRepository.findByAdId(ad.getId());
            List<String> iEvents = new ArrayList<>();
            for(ImpressionEvent iEvent : impressionEvents) {
                iEvents.add(iEvent.getUrl());
            }
            natives.add(new Native(ad, iEvents));
        }
        return new ResponseEntity(natives, HttpStatus.OK);
    }

    @Override
    public List<Ad> findByString(String str) {
        List<Ad> ads = (List<Ad>) this.adRepository.findAll();
        List<Ad> findAds = new ArrayList<>();
        for (Ad ad : ads) {
            if (ad.getTitle().contains(str))
                findAds.add(ad);
        }
        return findAds;
    }
}
