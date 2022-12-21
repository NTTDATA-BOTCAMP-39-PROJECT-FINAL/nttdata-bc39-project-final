package com.nttdata.bc39.grupo04.api.exchange;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ExchangeService {

	Flux<ExchangeDTO> getAllExchanges();

	Mono<ExchangeDTO> createExchange(ExchangeDTO dto);

	Mono<ExchangeDTO> updateExchange(ExchangeDTO dto);

}
