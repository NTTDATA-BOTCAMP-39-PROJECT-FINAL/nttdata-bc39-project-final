package com.nttdata.bc39.grupo04.api.bootcoin;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BootcoinDTO implements Serializable {

	private static final long serialVersionUID = -1609075861617897735L;
	private String numberBootcoin;
	private String typeDocument;
	private String documentNumber;
	private String phoneNumber;
	private String email;
	private LocalDate createDate;
	private LocalDate modifyDate;
}
