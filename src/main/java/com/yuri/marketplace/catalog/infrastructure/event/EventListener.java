package com.yuri.marketplace.catalog.infrastructure.event;

import com.yuri.marketplace.catalog.infrastructure.persistence.entity.Event;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventListener {
    private static final Logger logger = LoggerFactory.getLogger(EventListener.class);

    @PostPersist
    public void onEventCreated(Event event){
        logger.info("Eevnt created via @PostPersist {}", event);
    }
    @PostUpdate
    public void onEventUpdate(Event event){
        logger.info("Eevnt created via @PostUpdate {}", event);
    }
    @PostRemove
    public void onEventRemoved(Event event){
        logger.info("Eevnt created via @PostRemove {}", event);
    }
}
