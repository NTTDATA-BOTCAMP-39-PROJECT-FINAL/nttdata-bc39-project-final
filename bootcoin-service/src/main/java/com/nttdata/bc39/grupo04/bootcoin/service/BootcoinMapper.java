package com.nttdata.bc39.grupo04.bootcoin.service;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.nttdata.bc39.grupo04.api.bootcoin.BootcoinDTO;
import com.nttdata.bc39.grupo04.api.wallet.WalletDTO;
import com.nttdata.bc39.grupo04.bootcoin.persistence.BootcoinEntity;


@Mapper(componentModel = "spring")
public interface BootcoinMapper {

	BootcoinDTO entityToDto(BootcoinEntity entity);

    @Mappings({
            @Mapping(target = "id", ignore = true)
    })
    BootcoinEntity dtoToEntity(BootcoinDTO dto);
}

