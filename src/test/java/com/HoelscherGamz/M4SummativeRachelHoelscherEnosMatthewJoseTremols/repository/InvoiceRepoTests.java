package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.repository;

import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model.Invoice;
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
public class InvoiceRepoTests {
    @Autowired
    InvoiceRepository repo;

    @Before
    public void setUp() throws Exception {
        repo.deleteAll();
    }

    @Test
    public void shouldAddGetDeleteInvoice() {
        Invoice invoice1 = repo.save(new Invoice(1L, "Mary", "123 Oak Avenue", "San Diego", "CA", "92129", "game", 1L, new BigDecimal("40.99"), 2, new BigDecimal("81.98"), new BigDecimal("4.91"), new BigDecimal("1.49"), new BigDecimal("88.38")));
        assertEquals(true, repo.existsById(invoice1.getInvoice_id()));
        repo.deleteById(invoice1.getInvoice_id());
        assertEquals(false, repo.existsById(invoice1.getInvoice_id()));
    }

    @Test
    public void shouldGetAllInvoices() {
        Invoice invoice1 = repo.save(new Invoice(1L, "Mary", "123 Oak Avenue", "San Diego", "CA", "92129", "game", 1L, new BigDecimal("40.99"), 2, new BigDecimal("81.98"), new BigDecimal("4.91"), new BigDecimal("1.49"), new BigDecimal("88.38")));
        Invoice invoice2 = repo.save(new Invoice(2L, "John", "321 Main Street", "Honolulu", "HI", "96795", "console", 1L, new BigDecimal("550.99"), 1, new BigDecimal("550.99"), new BigDecimal("27.54"), new BigDecimal("14.99"), new BigDecimal("593.52")));


        List<Invoice> games = repo.findAll();
        assertEquals(2, games.size());
    }

    @Test
    public void shouldUpdateInvoice() {
        String newAddress = "555 Park Place";

        Invoice newInvoice = repo.save(new Invoice(1L, "Mary", "123 Oak Avenue", "San Diego", "CA", "92129", "game", 1L, new BigDecimal("40.99"), 2, new BigDecimal("81.98"), new BigDecimal("4.91"), new BigDecimal("1.49"), new BigDecimal("88.38")));
        newInvoice.setStreet(newAddress);
        Invoice updatedInvoice = repo.save(newInvoice);
        assertEquals(newAddress, updatedInvoice.getStreet());
    }

}