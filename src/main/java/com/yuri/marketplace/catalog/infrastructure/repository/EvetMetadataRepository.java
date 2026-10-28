package com.yuri.marketplace.catalog.infrastructure.repository;

import com.yuri.marketplace.catalog.infrastructure.entity.EventMetadata;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EvetMetadataRepository extends MongoRepository<EventMetadata, String> {

}
