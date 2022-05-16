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
    private Long invoiceId;

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

    public Invoice(Long invoiceId, String name, String street, String city, String state, String zipcode, String item_type, Long item_id, BigDecimal unit_price, int quantity, BigDecimal subtotal, BigDecimal tax, BigDecimal processing_fee, BigDecimal total) {
        this.invoiceId = invoiceId;
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.item_type = item_type;
        this.item_id = item_id;
        this.unit_price = unit_price;
        this.quantity = quantity;
        this.subtotal = subtotal;
        this.tax = tax;
        this.processing_fee = processing_fee;
        this.total = total;
    }

    public Invoice() {
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    public Long getItem_id() {
        return item_id;
    }

    public void setItem_id(Long item_id) {
        this.item_id = item_id;
    }

    public BigDecimal getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(BigDecimal unit_price) {
        this.unit_price = unit_price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getProcessing_fee() {
        return processing_fee;
    }

    public void setProcessing_fee(BigDecimal processing_fee) {
        this.processing_fee = processing_fee;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return quantity == invoice.quantity && Objects.equals(invoiceId, invoice.invoiceId) && Objects.equals(name, invoice.name) && Objects.equals(street, invoice.street) && Objects.equals(city, invoice.city) && Objects.equals(state, invoice.state) && Objects.equals(zipcode, invoice.zipcode) && Objects.equals(item_type, invoice.item_type) && Objects.equals(item_id, invoice.item_id) && Objects.equals(unit_price, invoice.unit_price) && Objects.equals(subtotal, invoice.subtotal) && Objects.equals(tax, invoice.tax) && Objects.equals(processing_fee, invoice.processing_fee) && Objects.equals(total, invoice.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceId, name, street, city, state, zipcode, item_type, item_id, unit_price, quantity, subtotal, tax, processing_fee, total);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId=" + invoiceId +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", item_type='" + item_type + '\'' +
                ", item_id=" + item_id +
                ", unit_price=" + unit_price +
                ", quantity=" + quantity +
                ", subtotal=" + subtotal +
                ", tax=" + tax +
                ", processing_fee=" + processing_fee +
                ", total=" + total +
                '}';
    }
}
