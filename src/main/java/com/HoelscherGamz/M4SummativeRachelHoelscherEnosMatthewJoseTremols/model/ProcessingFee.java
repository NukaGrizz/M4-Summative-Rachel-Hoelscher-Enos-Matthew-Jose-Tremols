package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "processing_fee")
public class ProcessingFee {
    @Id
    @NotNull
    @Column(length = 20)
    private String product_type;

    @NotNull
    @Digits(integer = 4,fraction = 2)
    private BigDecimal fee;

}
