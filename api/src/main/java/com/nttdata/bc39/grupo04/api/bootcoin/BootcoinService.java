package com.nttdata.bc39.grupo04.api.bootcoin;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BootcoinService {
	
    Flux<BootcoinDTO> getAllBootcoins();

    Mono<BootcoinDTO> getBootcoinByPhoneNumber(String phoneNumber);

    Mono<BootcoinDTO> createBootcoin(BootcoinDTO dto);

    Mono<BootcoinDTO> updateBootcoin(BootcoinDTO dto);

    Mono<Void> deleteBootcoinByPhoneNumber(String phoneNumber);
    
    Mono<BootcoinDTO> makeDepositBootcoin(double amount, String numberPhone);
    
    Mono<BootcoinDTO> makeWithdrawalBootcoin(double amount, String numberPhone);

}


