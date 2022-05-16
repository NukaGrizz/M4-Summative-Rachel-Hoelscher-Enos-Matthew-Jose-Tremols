package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "processing_fee")
public class ProcessingFee {
    @NotNull
    @Column(length = 20)
    private String product_type;

    @NotNull
    @Digits(integer = 4,fraction = 2)
    private BigDecimal fee;

    @Index(name = "ix_state_rate", columnList = "product_type", unique = true)

    /*

    create table if not exists processing_fee (
    product_type varchar(20) not null,
    fee decimal (4,2)
);

    create unique index ix_product_type_fee on processing_fee (product_type);

    Consoles: 14.99

    T-shirts: 1.98

    Games: 1.49

     */
}
