package com.yuri.marketplace.catalog.infrastructure.event;

import com.yuri.marketplace.catalog.infrastructure.persistence.entity.EventMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterDeleteEvent;
import org.springframework.data.mongodb.core.mapping.event.AfterSaveEvent;
import org.springframework.stereotype.Component;

@Component
public class EventMetadataListener extends AbstractMongoEventListener<EventMetadata> {
    private static final Logger logger = LoggerFactory.getLogger(EventMetadataListener.class);

    @Override
    public void onAfterSave(AfterSaveEvent event){
        logger.info("Event metadata save via onAfterSave {}", event.getDocument());
    }

    @Override
    public void onAfterDelete(AfterDeleteEvent event){
        logger.info("Event metadata save via onAfterDelete {}", event.getDocument());
    }
}
