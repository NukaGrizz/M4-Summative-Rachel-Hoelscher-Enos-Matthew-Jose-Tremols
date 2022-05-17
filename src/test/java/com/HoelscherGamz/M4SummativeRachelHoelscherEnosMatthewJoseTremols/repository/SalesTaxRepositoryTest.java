package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.repository;

import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model.SalesTax;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SalesTaxRepositoryTest {

    @Autowired
    SalesTaxRepository salesTaxRepository;

    @org.junit.Before
    public void setUp() throws Exception {
        salesTaxRepository.deleteAll();
    }

    @Test
    public void shouldAddGetDeleteSalesTax() {
        SalesTax salesTax = new SalesTax();
        salesTax.setState("CA");
        salesTax.setRate(BigDecimal.valueOf(.06));

        salesTax = salesTaxRepository.save(salesTax);

        Optional<SalesTax> salesTax1 = salesTaxRepository.findOne(salesTax.getState("CA"));

        assertEquals(salesTax1.get(), salesTax);

        // how to delete by something other than ID?
        salesTaxRepository.deleteById(salesTax.getState("CA"));

        salesTax1 = salesTaxRepository.findById(salesTax.getState("CA"));

        assertFalse(salesTax1.isPresent());

    }

    @Test
    public void shouldUpdateSalesTax() {
        SalesTax salesTax = new SalesTax();
        salesTax.setState("CA");
        salesTax.setRate(BigDecimal.valueOf(.06));
        salesTaxRepository.save(salesTax);

        salesTax.setState("HI");
        salesTax.setRate(BigDecimal.valueOf(.05));
        salesTaxRepository.save(salesTax);

        Optional<SalesTax> salesTax1 = salesTaxRepository.findById(salesTax.getState("HI"));
        assertEquals(salesTax1.get(), salesTax);

    }

    @Test
    public void shouldGetAllSalesTax() {

        SalesTax salesTax = new SalesTax();
        salesTax.setState("CA");
        salesTax.setRate(BigDecimal.valueOf(.06));
        salesTaxRepository.save(salesTax);

        salesTax = salesTaxRepository.save(salesTax);

        salesTax.setState("HI");
        salesTax.setRate(BigDecimal.valueOf(.05));
        salesTaxRepository.save(salesTax);

        salesTax = salesTaxRepository.save(salesTax);

        List<SalesTax> aList = salesTaxRepository.findAll();
        assertEquals(aList.size(), 2);

    }
}