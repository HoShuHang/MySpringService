package com.selab.model.repository;

import com.selab.model.Entity.ImpressionEvent;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ImpressiveEventRepository extends CrudRepository<ImpressionEvent, Long> {
    List<ImpressionEvent> findByAdId(Long adId);
}
