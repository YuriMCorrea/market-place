package com.yuri.marketplace.catalog.application;

import com.yuri.marketplace.catalog.application.dto.EventOutput;
import com.yuri.marketplace.catalog.domain.Event;
import com.yuri.marketplace.catalog.domain.EventMetadataRepository;
import com.yuri.marketplace.catalog.domain.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class BrowserShowcaseUseCase {
    private static final Logger logger = LoggerFactory.getLogger(BrowserShowcaseUseCase.class);


    private final EventRepository eventRepository;
    private final EventEnricher eventEnricher;

    public BrowserShowcaseUseCase(EventRepository eventRepository, EventEnricher eventEnricher) {
        this.eventRepository = eventRepository;
        this.eventEnricher = eventEnricher;

    }

    public List<EventOutput> execute () {
        var futures = eventRepository.findAll().stream().map(eventEnricher::enrich).toList();

        var events = futures.stream()
                .map(CompletableFuture::join)
                .map(EventOutput::from)
                .toList();
        logger.info("{} Enriched events", events.size());
        return events;
    }
}
