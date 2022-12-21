package com.nttdata.bc39.grupo04.exchange.service;

import java.time.LocalDate;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.nttdata.bc39.grupo04.api.exceptions.InvaliteInputException;
import com.nttdata.bc39.grupo04.api.exchange.ExchangeDTO;
import com.nttdata.bc39.grupo04.api.exchange.ExchangeService;
import com.nttdata.bc39.grupo04.api.kafka.Event;
import com.nttdata.bc39.grupo04.exchange.persistence.ExchangeEntity;
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
		Mono<ExchangeEntity> entity = repository.findByCreateDate(dto.getCreateDate());
		ExchangeEntity entityNew = entity.block();
		if (!ObjectUtils.isEmpty(entityNew)) {
			throw new InvaliteInputException("Error, Este tipo de cambio ya esta registrado en la fecha solicitada");
		}
		dto.setCreateDate(LocalDate.now());
		entityNew = mapper.dtoToEntity(dto);
		return repository.save(entityNew).map(mapper::entityToDto);
	}

	@Override
	public Mono<ExchangeDTO> updateExchange(ExchangeDTO dto) {
		return null;
	}

}
