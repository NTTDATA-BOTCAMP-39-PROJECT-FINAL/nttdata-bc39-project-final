package com.nttdata.bc39.grupo04.exchange.service;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.nttdata.bc39.grupo04.api.bootcoin.BootcoinDTO;
import com.nttdata.bc39.grupo04.api.exchange.ExchangeDTO;
import com.nttdata.bc39.grupo04.api.wallet.WalletDTO;
import com.nttdata.bc39.grupo04.exchange.persistence.ExchangeEntity;


@Mapper(componentModel = "spring")
public interface ExchangeMapper {

	ExchangeDTO entityToDto(ExchangeEntity entity);

    @Mappings({
            @Mapping(target = "id", ignore = true)
    })
    ExchangeEntity dtoToEntity(ExchangeDTO dto);
}

