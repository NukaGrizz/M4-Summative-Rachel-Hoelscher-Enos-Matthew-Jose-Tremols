package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.*;

public class InvoiceTest {

    Invoice invoiceTester = new Invoice(11L,"joe","downunder st","too-hot","FL","99999","Game",11L,new BigDecimal("60.99"),2,new BigDecimal("121.98"),new BigDecimal("7.31"),new BigDecimal("3.23"),new BigDecimal("132.52"));

    @Test
    public void getInvoiceId() {
        assertEquals(Optional.of(11L),Optional.of(invoiceTester.getInvoiceId()));
    }

    @Test
    public void setInvoiceId() {
        invoiceTester.setInvoiceId(12L);
        assertEquals(Optional.of(12L),Optional.of(invoiceTester.getInvoiceId()));
    }

    @Test
    public void getName() {
        assertEquals(Optional.of("joe"),Optional.of(invoiceTester.getName()));
    }

    @Test
    public void setName() {
        invoiceTester.setName("matt");
        assertEquals(Optional.of("matt"),Optional.of(invoiceTester.getName()));
    }

    @Test
    public void getStreet() {
        assertEquals(Optional.of("downunder st"),Optional.of(invoiceTester.getStreet()));
    }

    @Test
    public void setStreet() {
        invoiceTester.setStreet("uptown dr");
        assertEquals(Optional.of("uptown dr"),Optional.of(invoiceTester.getStreet()));
    }

    @Test
    public void getCity() {
        assertEquals(Optional.of("too-hot"),Optional.of(invoiceTester.getCity()));
    }

    @Test
    public void setCity() {
        invoiceTester.setCity("too-cold");
        assertEquals(Optional.of("too-cold"),Optional.of(invoiceTester.getCity()));
    }

    @Test
    public void getState() {
        assertEquals(Optional.of("FL"),Optional.of(invoiceTester.getState()));
    }

    @Test
    public void setState() {
        invoiceTester.setState("WY");
        assertEquals(Optional.of("WY"),Optional.of(invoiceTester.getState()));
    }

    @Test
    public void getZipcode() {
        assertEquals(Optional.of("99999"),Optional.of(invoiceTester.getZipcode()));
    }

    @Test
    public void setZipcode() {
        invoiceTester.setZipcode("82072");
        assertEquals(Optional.of("82072"),Optional.of(invoiceTester.getZipcode()));
    }

    @Test
    public void getItem_type() {
        assertEquals(Optional.of("Game"),Optional.of(invoiceTester.getItem_type()));
    }

    @Test
    public void setItem_type() {
        invoiceTester.setItem_type("Console");
        assertEquals(Optional.of("Console"),Optional.of(invoiceTester.getItem_type()));
    }

    @Test
    public void getItem_id() {
        assertEquals(Optional.of(11L),Optional.of(invoiceTester.getItem_id()));
    }

    @Test
    public void setItem_id() {
        invoiceTester.setItem_id(13L);
        assertEquals(Optional.of(13L),Optional.of(invoiceTester.getItem_id()));
    }

    @Test
    public void getUnit_price() {
        assertEquals(Optional.of(new BigDecimal("60.99")),Optional.of(invoiceTester.getUnit_price()));
    }

    @Test
    public void setUnit_price() {
        invoiceTester.setUnit_price(new BigDecimal("30.99"));
        assertEquals(Optional.of(new BigDecimal("30.99")),Optional.of(invoiceTester.getUnit_price()));
    }

    @Test
    public void getQuantity() {
        assertEquals(Optional.of(2),Optional.of(invoiceTester.getQuantity()));
    }

    @Test
    public void setQuantity() {
        invoiceTester.setQuantity(3);
        assertEquals(Optional.of(3),Optional.of(invoiceTester.getQuantity()));
    }

    @Test
    public void getSubtotal() {
        assertEquals(Optional.of(new BigDecimal("121.98")),Optional.of(invoiceTester.getSubtotal()));
    }


    @Test
    public void setSubtotal() {
        invoiceTester.setSubtotal(new BigDecimal("92.97"));
        assertEquals(Optional.of(new BigDecimal("92.97")),Optional.of(invoiceTester.getSubtotal()));
    }

    @Test
    public void getTax() {
        assertEquals(Optional.of(new BigDecimal("7.31")),Optional.of(invoiceTester.getTax()));
    }

    @Test
    public void setTax() {
        invoiceTester.setTax(new BigDecimal("0.00"));
        assertEquals(Optional.of(new BigDecimal("0.00")),Optional.of(invoiceTester.getTax()));
    }

    @Test
    public void getProcessing_fee() {

        assertEquals(Optional.of(new BigDecimal("3.23")),Optional.of(invoiceTester.getProcessing_fee()));
    }

    @Test
    public void setProcessing_fee() {
        invoiceTester.setProcessing_fee(new BigDecimal("5.00"));
        assertEquals(Optional.of(new BigDecimal("5.00")),Optional.of(invoiceTester.getProcessing_fee()));
    }

    @Test
    public void getTotal() {
        assertEquals(Optional.of(new BigDecimal("132.52")),Optional.of(invoiceTester.getTotal()));
    }

    @Test
    public void setTotal() {
        invoiceTester.setTotal(new BigDecimal("97.97"));
        assertEquals(Optional.of(new BigDecimal("97.97")),Optional.of(invoiceTester.getTotal()));
    }
}