package com.selab.model.repository;

import com.selab.model.Entity.Ad;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdRepository extends CrudRepository<Ad, Long> {
    List<Ad> findByTitle(String title);
    List<Ad> findById(Long id);
}
