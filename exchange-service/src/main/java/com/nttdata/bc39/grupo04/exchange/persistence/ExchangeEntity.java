package com.nttdata.bc39.grupo04.exchange.persistence;

import java.time.LocalDate;
import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "exchange")
public class ExchangeEntity {

	private ObjectId id;
    private LocalDate exchangeDate;
	private double buy;
	private double sell;
    private LocalDate createDate;
    private LocalDate modifyDate;

}
