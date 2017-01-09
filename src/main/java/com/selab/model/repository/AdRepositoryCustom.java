package com.selab.model.repository;

import com.selab.model.Entity.Ad;

import java.util.List;

public interface AdRepositoryCustom {
    List<Ad> findByString(String str);
}
