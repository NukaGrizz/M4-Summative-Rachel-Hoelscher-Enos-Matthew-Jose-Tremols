package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="tShirt")
public class TShirt {


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


    public TShirt(Long id, String size, String color, String description, BigDecimal price, int quantity) {

        this.id = id;
        this.size = size;
        this.color = color;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }


    public TShirt() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TShirt tShirt = (TShirt) o;
        return quantity == tShirt.quantity && Objects.equals(id, tShirt.id) && Objects.equals(size, tShirt.size) && Objects.equals(color, tShirt.color) && Objects.equals(description, tShirt.description) && Objects.equals(price, tShirt.price);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, size, color, description, price, quantity);
    }

    @Override
    public String toString() {

        return "TShirt{" +

                "id=" + id +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
