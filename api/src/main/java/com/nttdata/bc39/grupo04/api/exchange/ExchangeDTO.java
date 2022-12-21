package com.nttdata.bc39.grupo04.api.exchange;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeDTO implements Serializable {

	private static final long serialVersionUID = 1856421716726875480L;
    private LocalDate exchangeDate;
	private double buy;
	private double sell;
    private LocalDate createDate;
    private LocalDate modifyDate;
}
