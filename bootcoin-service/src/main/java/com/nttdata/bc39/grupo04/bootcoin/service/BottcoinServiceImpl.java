package com.nttdata.bc39.grupo04.bootcoin.service;

import java.time.LocalDate;
import java.util.Calendar;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.nttdata.bc39.grupo04.api.bootcoin.BootcoinDTO;
import com.nttdata.bc39.grupo04.api.bootcoin.BootcoinService;
import com.nttdata.bc39.grupo04.api.exceptions.InvaliteInputException;
import com.nttdata.bc39.grupo04.api.kafka.Event;
import com.nttdata.bc39.grupo04.api.utils.Constants;
import com.nttdata.bc39.grupo04.bootcoin.persistence.BootcoinEntity;
import com.nttdata.bc39.grupo04.bootcoin.persistence.BootcoinRepository;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BottcoinServiceImpl implements BootcoinService {

	private BootcoinRepository repository;
	private BootcoinMapper mapper;
	private static final Logger LOG = Logger.getLogger(BottcoinServiceImpl.class);

	@Autowired
	public BottcoinServiceImpl(BootcoinRepository repository, BootcoinMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Autowired
	private KafkaTemplate<String, Event<?>> producer;

	@Override
	public Flux<BootcoinDTO> getAllBootcoins() {
		return repository.findAll().map(mapper::entityToDto);
	}

	@Override
	public Mono<BootcoinDTO> getBootcoinByPhoneNumber(String phoneNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<BootcoinDTO> createBootcoin(BootcoinDTO dto) {
		Mono<BootcoinEntity> entity = repository
				.findByTypeDocumentAndDocumentNumber(dto.getTypeDocument(), dto.getDocumentNumber());
		BootcoinEntity entityNew = entity.block();
		if (!ObjectUtils.isEmpty(entityNew)) {
			throw new InvaliteInputException("Error, Este usuario tiene un monedero registrado");
		}
		dto.setCreateDate(LocalDate.now());
		dto.setNumberBootcoin(dto.getTypeDocument()+dto.getDocumentNumber());
		entityNew = mapper.dtoToEntity(dto);
		return repository.save(entityNew).map(mapper::entityToDto);
	}

	@Override
	public Mono<BootcoinDTO> updateBootcoin(BootcoinDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Void> deleteBootcoinByPhoneNumber(String phoneNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<BootcoinDTO> makeDepositBootcoin(double amount, String numberPhone) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<BootcoinDTO> makeWithdrawalBootcoin(double amount, String numberPhone) {
		// TODO Auto-generated method stub
		return null;
	}

}
