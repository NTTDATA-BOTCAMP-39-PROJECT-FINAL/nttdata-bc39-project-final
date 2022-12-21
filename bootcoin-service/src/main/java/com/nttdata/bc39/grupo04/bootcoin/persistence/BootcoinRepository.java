package com.nttdata.bc39.grupo04.bootcoin.persistence;

import org.bson.types.ObjectId;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Mono;

@Repository
public interface BootcoinRepository extends ReactiveCrudRepository<BootcoinEntity, ObjectId> {

	Mono<BootcoinEntity> findByPhoneNumber(String phoneNumber);
	Mono<BootcoinEntity> findByTypeDocumentAndDocumentNumber(String typeDocument, String numberDocument);
}
