package com.selab.model.Entity;

import com.selab.model.repository.ImpressiveEventRepository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class ImpressionEvent {
    @Id
    private Long id;
    @Column(length = 1000)
    private String url;
    private Long adId;

    public ImpressionEvent() {}

    public ImpressionEvent(String url, Long adId, ImpressiveEventRepository repository) {
        this.setUrl(url);
        this.setAdId(adId);
        List<ImpressionEvent> impressionEvents = (List) repository.findAll();
        Long id = impressionEvents.isEmpty() ? 1 : this.getNextUnexistId(impressionEvents.get(impressionEvents.size() - 1).getId(), repository);
        this.setId(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getAdId() {
        return adId;
    }

    public void setAdId(Long adId) {
        this.adId = adId;
    }

    private Long getNextUnexistId(Long id, ImpressiveEventRepository repository) {
        if (this.isIdExist(id, repository))
            return this.getNextUnexistId(id + 1, repository);
        else
            return id;
    }

    private boolean isIdExist(Long id, ImpressiveEventRepository repository) {
        return !(repository.findOne(id) == null);
    }
}
