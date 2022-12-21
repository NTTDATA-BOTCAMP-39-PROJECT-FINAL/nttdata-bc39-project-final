package com.nttdata.bc39.grupo04.bootcoin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.bc39.grupo04.api.account.AccountDTO;
import com.nttdata.bc39.grupo04.api.bootcoin.BootcoinDTO;
import com.nttdata.bc39.grupo04.api.bootcoin.BootcoinService;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/bootcoin")
public class BootcoinRestController {

	@Autowired
	private BootcoinService service;

	@GetMapping(value = "/findAll")
	public Flux<BootcoinDTO> getAllBootcoins() {
		return service.getAllBootcoins();
	}

	@GetMapping(value = "/findByPhoneNumber/{phoneNumber}")
	public Mono<BootcoinDTO> getBootcoinByPhoneNumber(@PathVariable(value = "phoneNumber") String phoneNumber) {
		return service.getBootcoinByPhoneNumber(phoneNumber);
	}
	

	@PostMapping(value = "/save")
	public Mono<BootcoinDTO> createBootcoin(@RequestBody BootcoinDTO body) {
		return service.createBootcoin(body);
	}

	@PutMapping(value = "/update")
	public Mono<BootcoinDTO> updateBootcoin(@RequestBody BootcoinDTO body) {
		return service.updateBootcoin(body);
	}

	@DeleteMapping(value = "/delete/{phoneNumber}")
	public Mono<Void> deleteBootcoinByPhoneNumber(@PathVariable(value = "phoneNumber") String phoneNumber) {
		return service.deleteBootcoinByPhoneNumber(phoneNumber);
	}

	@GetMapping("/deposit/{numberPhone}")
	Mono<BootcoinDTO> makeDeposit(@PathVariable(value = "numberPhone") String numberPhone,
			@RequestParam(value = "amount") double amount) {
		return service.makeDepositBootcoin(amount, numberPhone);
	}
	
    @GetMapping("/withdrawal/{numberPhone}")
    Mono<BootcoinDTO> makeWithdrawal(@PathVariable(value = "numberPhone") String numberPhone, @RequestParam(value = "amount") double amount) {
        return service.makeWithdrawalBootcoin(amount, numberPhone);
    }

}
