package com.nttdata.bc39.grupo04.exchange.persistence;

import org.bson.types.ObjectId;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Mono;

@Repository
public interface ExchangeRepository extends ReactiveCrudRepository<ExchangeEntity, ObjectId> {

}
