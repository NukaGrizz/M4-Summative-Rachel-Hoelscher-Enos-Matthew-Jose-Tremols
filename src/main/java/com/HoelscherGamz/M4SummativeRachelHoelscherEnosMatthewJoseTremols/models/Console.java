package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

    @Entity
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @Table(name = "console")
    public class Console {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @NotNull
        private Long id;

        @NotNull
        @Column(length = 50)
        private String model;

        @NotNull
        @Column(length = 50)
        private String manufacturer;

        @NotNull
        @Column(length = 20)
        private String memoryAmount;

        @NotNull
        @Column(length = 20)
        private String processor;

        @NotNull
        @Digits(integer = 5, fraction = 2)
        private BigDecimal price;

        @NotNull
        private int quantity;
    }
