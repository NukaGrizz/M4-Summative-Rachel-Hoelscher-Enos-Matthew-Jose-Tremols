package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public SalesTax(String state, BigDecimal rate) {
        this.state = state;
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesTax salesTax = (SalesTax) o;
        return Objects.equals(state, salesTax.state) && Objects.equals(rate, salesTax.rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(state, rate);
    }

    @Override
    public String toString() {
        return "SalesTax{" +
                "state='" + state + '\'' +
                ", rate=" + rate +
                '}';
    }
}
