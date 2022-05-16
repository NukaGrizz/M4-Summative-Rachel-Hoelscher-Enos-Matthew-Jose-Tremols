package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "sales_tax_rate")
public class SalesTax {

    @Id
    @NotNull
    @Column(columnDefinition = "CHAR(2)")
    private String state;

    @NotNull
    @Digits(integer = 3,fraction = 2)
    private BigDecimal rate;

}
