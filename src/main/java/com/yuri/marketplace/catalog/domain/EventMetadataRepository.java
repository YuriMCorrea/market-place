package com.yuri.marketplace.catalog.domain;

import java.util.Optional;

public interface EventMetadataRepository {
    Optional<EventMetadata> findByEventId(EventId id);
}
