package com.nttdata.bc39.grupo04.exchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.bc39.grupo04.api.exchange.ExchangeDTO;
import com.nttdata.bc39.grupo04.api.exchange.ExchangeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/exchange")
public class ExchangeRestController {

	@Autowired
	private ExchangeService service;

	@GetMapping(value = "/findAll")
	public Flux<ExchangeDTO> getAllExchanges() {
		return service.getAllExchanges();
	}

	/*
	 * @GetMapping(value = "/findByDate/{date}") public Mono<ExchangeDTO>
	 * getExchangeByDate(@PathVariable(value = "date") String date) { return
	 * service.getExchangeByDate(date); }
	 */

	@PostMapping(value = "/save")
	public Mono<ExchangeDTO> createExchange(@RequestBody ExchangeDTO body) {
		return service.createExchange(body);
	}

	@PutMapping(value = "/update")
	public Mono<ExchangeDTO> updateExchange(@RequestBody ExchangeDTO body) {
		return service.updateExchange(body);
	}

	/*
	 * @DeleteMapping(value = "/delete/{date}") public Mono<Void>
	 * deleteExchangeByDate(@PathVariable(value = "date") String date) { return
	 * service.deleteExchangeByDate(date); }
	 */

}
