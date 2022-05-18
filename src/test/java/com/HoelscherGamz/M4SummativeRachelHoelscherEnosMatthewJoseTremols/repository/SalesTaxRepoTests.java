package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.repository;

import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model.SalesTax;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SalesTaxRepoTests {

    @Autowired
    SalesTaxRepository repo;

    @Before
    public void setUp() throws Exception {
        repo.deleteAll();
    }

    @Test
    public void shouldAddGetDeleteSalesTax() {
        SalesTax newSalesTax = repo.save(new SalesTax("CA", new BigDecimal(".06")));
        assertEquals(true, repo.existsById(newSalesTax.getState()));
        repo.deleteById(newSalesTax.getState());
        assertEquals(false, repo.existsById(newSalesTax.getState()));
    }

    @Test
    public void shouldGetAllSalesTaxes() {
        repo.save(new SalesTax("CA", new BigDecimal(".06")));
        repo.save(new SalesTax("HI", new BigDecimal(".05")));;


        List<SalesTax> salesTaxes = repo.findAll();
        assertEquals(2, salesTaxes.size());
    }

    @Test
    public void shouldUpdateSalesTax() {
        final BigDecimal newRate = new BigDecimal(".07");

        SalesTax newSalesTax = repo.save(new SalesTax("CA", new BigDecimal(".06")));
        newSalesTax.setRate(newRate);
        SalesTax updatedSalesTax = repo.save(newSalesTax);
        assertEquals(newRate, updatedSalesTax.getRate());
    }
}
