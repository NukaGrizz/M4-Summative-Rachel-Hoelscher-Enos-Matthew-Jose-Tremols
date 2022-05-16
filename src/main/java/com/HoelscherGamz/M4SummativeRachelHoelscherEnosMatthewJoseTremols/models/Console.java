package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

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

        public Console(Long id, String model, String manufacturer, String memoryAmount, String processor, BigDecimal price, int quantity) {
            this.id = id;
            this.model = model;
            this.manufacturer = manufacturer;
            this.memoryAmount = memoryAmount;
            this.processor = processor;
            this.price = price;
            this.quantity = quantity;
        }

        public Console() {
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getManufacturer() {
            return manufacturer;
        }

        public void setManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
        }

        public String getMemoryAmount() {
            return memoryAmount;
        }

        public void setMemoryAmount(String memoryAmount) {
            this.memoryAmount = memoryAmount;
        }

        public String getProcessor() {
            return processor;
        }

        public void setProcessor(String processor) {
            this.processor = processor;
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
        Console console = (Console) o;
        return quantity == console.quantity && Objects.equals(id, console.id) && Objects.equals(model, console.model) && Objects.equals(manufacturer, console.manufacturer) && Objects.equals(memoryAmount, console.memoryAmount) && Objects.equals(processor, console.processor) && Objects.equals(price, console.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, manufacturer, memoryAmount, processor, price, quantity);
    }

    @Override
    public String toString() {
        return "Console{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", memoryAmount='" + memoryAmount + '\'' +
                ", processor='" + processor + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
