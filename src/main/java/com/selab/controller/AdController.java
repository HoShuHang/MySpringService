package com.selab.controller;

import com.selab.model.Entity.Ad;
import com.selab.model.User;
import com.selab.model.repository.AdRepository;
import com.selab.model.repository.AdRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class AdController implements AdRepositoryCustom {
    @Autowired
    private AdRepository repository;

    @RequestMapping(value = "/ads/id/{id}")
    public ResponseEntity<List<Ad>> getAdById(@PathVariable("id") Long id) {
        List<Ad> ads = this.repository.findById(id);
        return new ResponseEntity(ads, HttpStatus.OK);
    }

    @RequestMapping("/ads")
    public ResponseEntity<List<Ad>> getAdByStr(@RequestParam("title") String title) {
        List<Ad> ads = this.findByString(title);
        return new ResponseEntity(ads, HttpStatus.OK);
    }

    @Override
    public List<Ad> findByString(String str) {
        List<Ad> ads = (List<Ad>) repository.findAll();
        List<Ad> findAds = new ArrayList<>();
        for (Ad ad : ads) {
            if (ad.getTitle().contains(str))
                findAds.add(ad);
        }
        return findAds;
    }
}
