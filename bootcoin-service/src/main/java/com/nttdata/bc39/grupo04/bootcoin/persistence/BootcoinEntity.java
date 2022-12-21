package com.nttdata.bc39.grupo04.bootcoin.persistence;

import java.time.LocalDate;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "bootcoin")
public class BootcoinEntity {

	private ObjectId id;
	private String numberBootcoin;
	private String typeDocument;
	private String documentNumber;
	private String phoneNumber;
	private String email;
	private LocalDate createDate;
	private LocalDate modifyDate;

}
