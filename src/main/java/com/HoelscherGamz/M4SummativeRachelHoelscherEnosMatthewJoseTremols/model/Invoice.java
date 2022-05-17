package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long invoice_Id;

    @NotNull
    @Column(length = 80)
    private String name;

    @NotNull
    @Column(length = 30)
    private String street;

    @NotNull
    @Column(length = 30)
    private String city;

    @NotNull
    @Column(columnDefinition = "CHAR(2)")
    private String state;

    @NotNull
    @Column(length = 5)
    private String zipcode;

    @NotNull
    @Column(length = 20)
    private String item_type;

    @NotNull
    private Long item_id;

    @NotNull
    @Digits(integer = 5, fraction = 2)
    private BigDecimal unit_price;

    @NotNull
    private int quantity;

    @NotNull
    @Digits(integer = 5, fraction = 2)
    private BigDecimal subtotal;

    @NotNull
    @Digits(integer = 5, fraction = 2)
    private BigDecimal tax;

    @NotNull
    @Digits(integer = 5, fraction = 2)
    private BigDecimal processing_fee;

    @NotNull
    @Digits(integer = 5, fraction = 2)
    private BigDecimal total;

}
