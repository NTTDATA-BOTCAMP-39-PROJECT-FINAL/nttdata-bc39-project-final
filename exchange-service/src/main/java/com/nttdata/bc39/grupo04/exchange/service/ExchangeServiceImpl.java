package com.nttdata.bc39.grupo04.exchange.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.nttdata.bc39.grupo04.api.exchange.ExchangeDTO;
import com.nttdata.bc39.grupo04.api.exchange.ExchangeService;
import com.nttdata.bc39.grupo04.api.kafka.Event;
import com.nttdata.bc39.grupo04.exchange.persistence.ExchangeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ExchangeServiceImpl implements ExchangeService {

	private ExchangeRepository repository;
	private ExchangeMapper mapper;
	private static final Logger LOG = Logger.getLogger(ExchangeServiceImpl.class);

	@Autowired
	public ExchangeServiceImpl(ExchangeRepository repository, ExchangeMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Autowired
	private KafkaTemplate<String, Event<?>> producer;

	@Override
	public Flux<ExchangeDTO> getAllExchanges() {
		return repository.findAll().map(mapper::entityToDto);
	}

	@Override
	public Mono<ExchangeDTO> createExchange(ExchangeDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<ExchangeDTO> updateExchange(ExchangeDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
