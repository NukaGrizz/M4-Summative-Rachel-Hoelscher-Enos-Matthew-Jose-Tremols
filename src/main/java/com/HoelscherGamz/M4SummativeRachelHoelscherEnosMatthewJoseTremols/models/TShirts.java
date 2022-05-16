package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="tShirts")
public class TShirts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long id;

    @NotNull
    @Column(length = 20)
    private String size;

    @NotNull
    @Column(length = 20)
    private String color;

    @NotNull
    @Column(length = 255)
    private String description;

    @NotNull
    @Digits(integer = 5, fraction = 2)
    private BigDecimal price;

    @NotNull
    private int quantity;

    public TShirts(Long id, String size, String color, String description, BigDecimal price, int quantity) {
        this.id = id;
        this.size = size;
        this.color = color;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public TShirts() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TShirts tShirts = (TShirts) o;
        return quantity == tShirts.quantity && Objects.equals(id, tShirts.id) && Objects.equals(size, tShirts.size) && Objects.equals(color, tShirts.color) && Objects.equals(description, tShirts.description) && Objects.equals(price, tShirts.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, size, color, description, price, quantity);
    }

    @Override
    public String toString() {
        return "TShirts{" +
                "id=" + id +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
