package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.repository;

import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model.*;
import org.junit.Before;
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

public class InvoiceRepositoryTest {

    @Autowired
    ConsoleRepository consoleRepository;
    @Autowired
    GameRepository gameRepository;
    @Autowired
    TShirtRepository tShirtRepository;
    @Autowired
    SalesTaxRepository salesTaxRepository;
    @Autowired
    ProcessingFeeRepository processingFeeRepository;
    @Autowired
    InvoiceRepository invoiceRepository;

    @Before
    public void setUp() throws Exception {
        consoleRepository.deleteAll();
        gameRepository.deleteAll();
        tShirtRepository.deleteAll();
        salesTaxRepository.deleteAll();
        processingFeeRepository.deleteAll();
        invoiceRepository.deleteAll();
    }

    @Test
    public void shouldCalculateBusinessRules() {
        Invoice invoice = new Invoice();
//        invoice.setInvoice_id((1L));
//        invoice.setName("Mary");
//        invoice.setStreet("123 Oak Avenue");
//        invoice.setCity("San Diego");
//        invoice.setState("CA");
//        invoice.setZipcode("92129");
//        invoice.setItem_type("game");
//        invoice.setItem_id(1L);
//        invoice.setUnit_price(BigDecimal.valueOf(40.99));
//        invoice.setQuantity(2);

        // How to set this up?
        // maybe need to set up methods in processingFee & salesTax model or repo?

        // aka getSubtotal() { unit_price * quantity = subtotal }
        // aka calculateTax() { tax_rate * subtotal = newSubtotalWithTax }
        // aka calculateFee() { newSubtotalWithTax + fee = total }

        // assertEquals(81.98, getSubtotal.multiply(40.99,2));
        // assertEquals(86.89, calculateTax.multiply(81.98,1.06));
        // assertEquals(88.38, calculateFee.add(86.89,1.49));


//        invoice.getSubtotal()

//        invoice.setSubtotal(invoice.getQuantity(2) * invoice.getUnit_price(40.99));
//        invoice.setTax(BigDecimal.valueOf(1.06));
//        invoice.setProcessing_fee(BigDecimal.valueOf(1.49));
//        invoice.setTotal((invoice.getSubtotal(81.98) * invoice.getTax(1.06)) + invoice.getProcessing_fee(1.49);

        invoice = invoiceRepository.save(invoice);

        Optional<Invoice> invoice1 = invoiceRepository.findById(invoice.getInvoice_id());

        assertEquals(invoice1.get(), invoice);

        invoiceRepository.deleteById(invoice.getInvoice_id());

        invoice1 = invoiceRepository.findById(invoice.getInvoice_id());

        assertFalse(invoice1.isPresent());

    }

    @Test
    public void shouldAddGetDeleteInvoiceWhenPurchasingGame() {
        // Need to create a Game and select a state's Sales Tax first
        Game game = new Game();
        game.setGame_id(1L);
        game.setTitle("Breath of the Wild");
        game.setEsrb_rating("E10+");
        game.setDescription("The player controls an amnesiac Link, who awakens from a hundred-year slumber, and attempts to regain his memories and prevent the destruction of Hyrule by Calamity Ganon.");
        game.setStudio("Nintendo");
        game.setPrice(BigDecimal.valueOf(40.99));
        game.setQuantity(150);
        gameRepository.save(game);

        game = gameRepository.save(game);

        SalesTax salesTax = new SalesTax();
        salesTax.setState("CA");
        salesTax.setRate(BigDecimal.valueOf(1.06));
        salesTaxRepository.save(salesTax);

        salesTax = salesTaxRepository.save(salesTax);

        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setProduct_type("game");
        processingFee.setFee(BigDecimal.valueOf(1.49));
        processingFeeRepository.save(processingFee);

        processingFee = processingFeeRepository.save(processingFee);

        Invoice invoice = new Invoice();
        invoice.setInvoice_id((1L));
        invoice.setName("Mary");
        invoice.setStreet("123 Oak Avenue");
        invoice.setCity("San Diego");
        invoice.setState("CA");
        invoice.setZipcode("92129");
        invoice.setItem_type("game");
        invoice.setItem_id(1L);
        invoice.setUnit_price(BigDecimal.valueOf(40.99));
        invoice.setQuantity(2);
        invoice.setSubtotal(BigDecimal.valueOf(81.98));
        invoice.setTax(BigDecimal.valueOf(1.06));
        invoice.setProcessing_fee(BigDecimal.valueOf(1.49));
        invoice.setTotal(BigDecimal.valueOf(88.38));   //88.39? rounding?

        invoice = invoiceRepository.save(invoice);

        Optional<Invoice> invoice1 = invoiceRepository.findById(invoice.getInvoice_id());

        assertEquals(invoice1.get(), invoice);

        invoiceRepository.deleteById(invoice.getInvoice_id());

        invoice1 = invoiceRepository.findById(invoice.getInvoice_id());

        assertFalse(invoice1.isPresent());
    }

    @Test
    public void shouldAddGetDeleteInvoiceWhenPurchasingConsole() {
        // Need to create a Console and select a state's Sales Tax first
        Console console = new Console();
        console = new Console();
        console.setConsole_id(2L);
        console.setModel("XBox Series X");
        console.setManufacturer("Microsoft");
        console.setMemory_amount("1TB");
        console.setProcessor("AMD Zen 2 CPU");
        console.setPrice(BigDecimal.valueOf(550.99));
        console.setQuantity(200);
        consoleRepository.save(console);

        console = gameRepository.save(console);

        SalesTax salesTax = new SalesTax();
        salesTax.setState("CA");
        salesTax.setRate(BigDecimal.valueOf(1.06));
        salesTaxRepository.save(salesTax);

        salesTax = salesTaxRepository.save(salesTax);

        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setProduct_type("console");
        processingFee.setFee(BigDecimal.valueOf(14.99));
        processingFeeRepository.save(processingFee);

        processingFee = processingFeeRepository.save(processingFee);

        Invoice invoice = new Invoice();
        invoice.setInvoice_id((5L));
        invoice.setName("Mary");
        invoice.setStreet("123 Oak Avenue");
        invoice.setCity("San Diego");
        invoice.setState("CA");
        invoice.setZipcode("92129");
        invoice.setItem_type("console");
        invoice.setItem_id(11L);
        invoice.setUnit_price(BigDecimal.valueOf(550.99));
        invoice.setQuantity(4);
        invoice.setSubtotal(BigDecimal.valueOf(2203.96));
        invoice.setTax(BigDecimal.valueOf(1.06));
        invoice.setProcessing_fee(BigDecimal.valueOf(14.99));
        invoice.setTotal(BigDecimal.valueOf(2351.18));   //2351.19? rounding?

        invoice = invoiceRepository.save(invoice);

        Optional<Invoice> invoice1 = invoiceRepository.findById(invoice.getInvoice_id());

        assertEquals(invoice1.get(), invoice);

        invoiceRepository.deleteById(invoice.getInvoice_id());

        invoice1 = invoiceRepository.findById(invoice.getInvoice_id());

        assertFalse(invoice1.isPresent());
    }

    @Test
    public void shouldAddGetDeleteInvoiceWhenPurchasingTShirt() {
        // Need to create a Game and select a state's Sales Tax first
        TShirt tShirt = new TShirt();
        tShirt = new TShirt();
        tShirt.setT_shirt_id(2L);
        tShirt.setSize("Medium");
        tShirt.setColor("Green");
        tShirt.setDescription("Women's Horizon Zero Dawn t-shirt");
        tShirt.setPrice(BigDecimal.valueOf(35.99));
        tShirt.setQuantity(1500);
        tShirtRepository.save(tShirt);

        tShirt = tShirtRepository.save(tShirt);

        SalesTax salesTax = new SalesTax();
        salesTax.setState("CA");
        salesTax.setRate(BigDecimal.valueOf(1.06));
        salesTaxRepository.save(salesTax);

        salesTax = salesTaxRepository.save(salesTax);

        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setProduct_type("tShirt");
        processingFee.setFee(BigDecimal.valueOf(1.98));
        processingFeeRepository.save(processingFee);

        processingFee = processingFeeRepository.save(processingFee);

        Invoice invoice = new Invoice();
        invoice.setInvoice_id((155L));
        invoice.setName("Mary");
        invoice.setStreet("123 Oak Avenue");
        invoice.setCity("San Diego");
        invoice.setState("CA");
        invoice.setZipcode("92129");
        invoice.setItem_type("game");
        invoice.setItem_id(1L);
        invoice.setUnit_price(BigDecimal.valueOf(35.99));
        invoice.setQuantity(1);
        invoice.setSubtotal(BigDecimal.valueOf(35.99));
        invoice.setTax(BigDecimal.valueOf(1.06));
        invoice.setProcessing_fee(BigDecimal.valueOf(1.98));
        invoice.setTotal(BigDecimal.valueOf(40.12));   //40.13? rounding?

        invoice = invoiceRepository.save(invoice);

        Optional<Invoice> invoice1 = invoiceRepository.findById(invoice.getInvoice_id());

        assertEquals(invoice1.get(), invoice);

        invoiceRepository.deleteById(invoice.getInvoice_id());

        invoice1 = invoiceRepository.findById(invoice.getInvoice_id());

        assertFalse(invoice1.isPresent());
    }

    // HALP ? Do we need this?
//    @Test(expected  = DataIntegrityViolationException.class)
//    public void shouldAddWithRefIntegrityException() {
//
//        Invoice invoice = new Invoice();
//        invoice.setInvoice_id((1L));
//        invoice.setName("Mary");
//        invoice.setStreet("123 Oak Avenue");
//        invoice.setCity("San Diego");
//        invoice.setState("CA");
//        invoice.setZipcode("92129");
//        invoice.setItem_type("game");
//        invoice.setItem_id(1L);
//        invoice.setUnit_price(new BigDecimal(40.99);
//        invoice.setQuantity(2);
//        invoice.setSubtotal(invoice.getQuantity(2) * invoice.getUnit_price(40.99));
//        invoice.setTax(1.06);
//        invoice.setProcessing_fee(1.49);
//        invoice.setTotal((invoice.getSubtotal(81.98) * invoice.getTax(1.06)) + invoice.getProcessing_fee(1.49);
//    }

    // HALP ? Do we need this?
//    @Test(expected  = DataIntegrityViolationException.class)
//    public void shouldAddWithRefIntegrityException() {
//
//        Invoice invoice = new Invoice();
//        invoice.setInvoice_id((1L));
//        invoice.setName("Mary");
//        invoice.setStreet("123 Oak Avenue");
//        invoice.setCity("San Diego");
//        invoice.setState("CA");
//        invoice.setZipcode("92129");
//        invoice.setItem_type("game");
//        invoice.setItem_id(1L);
//        invoice.setUnit_price(new BigDecimal(40.99);
//        invoice.setQuantity(2);
//        invoice.setSubtotal(invoice.getQuantity(2) * invoice.getUnit_price(40.99));
//        invoice.setTax(1.06);
//        invoice.setProcessing_fee(1.49);
//        invoice.setTotal((invoice.getSubtotal(81.98) * invoice.getTax(1.06)) + invoice.getProcessing_fee(1.49);
//
//        invoice = invoiceRepository.save(invoice);
//
//    }

    @Test
    public void shouldGetAllInvoices() {

//        Game game = new Game();
//        game.setGame_id(1L);
//        game.setTitle("Breath of the Wild");
//        game.setEsrb_rating("E10+");
//        game.setDescription("The player controls an amnesiac Link, who awakens from a hundred-year slumber, and attempts to regain his memories and prevent the destruction of Hyrule by Calamity Ganon.");
//        game.setStudio("Nintendo");
//        game.setPrice(BigDecimal.valueOf(40.99));
//        game.setQuantity(150);
//        gameRepository.save(game);
//
//        game = gameRepository.save(game);
//
//        Console console = new Console();
//        console = new Console();
//        console.setConsole_id(2L);
//        console.setModel("XBox Series X");
//        console.setManufacturer("Microsoft");
//        console.setMemory_amount("1TB");
//        console.setProcessor("AMD Zen 2 CPU");
//        console.setPrice(BigDecimal.valueOf(550.99));
//        console.setQuantity(200);
//
//        console = consoleRepository.save(console);
//
//        SalesTax salesTax = new SalesTax();
//        salesTax.setState("CA");
//        salesTax.setRate(BigDecimal.valueOf(1.06));
//        salesTaxRepository.save(salesTax);
//
//        salesTax = salesTaxRepository.save(salesTax);
//
//        ProcessingFee processingFee = new ProcessingFee();
//        processingFee.setProduct_type("game");
//        processingFee.setFee(BigDecimal.valueOf(1.49));
//        processingFeeRepository.save(processingFee);
//
//        processingFee = processingFeeRepository.save(processingFee);

        Invoice invoice = new Invoice();
        invoice.setInvoice_id((1L));
        invoice.setName("Mary");
        invoice.setStreet("123 Oak Avenue");
        invoice.setCity("San Diego");
        invoice.setState("CA");
        invoice.setZipcode("92129");
        invoice.setItem_type("game");
        invoice.setItem_id(1L);
        invoice.setUnit_price(BigDecimal.valueOf(40.99));
        invoice.setQuantity(2);
        invoice.setSubtotal(BigDecimal.valueOf(81.98));
        invoice.setTax(BigDecimal.valueOf(1.06));
        invoice.setProcessing_fee(BigDecimal.valueOf(1.49));
        invoice.setTotal(BigDecimal.valueOf(88.38));   //88.39? rounding?

        invoice = invoiceRepository.save(invoice);

        invoice = new Invoice();
        invoice.setInvoice_id((2L));
        invoice.setName("John");
        invoice.setStreet("321 Main Street");
        invoice.setCity("Honolulu");
        invoice.setState("Hawaii");
        invoice.setZipcode("96795");
        invoice.setItem_type("console");
        invoice.setItem_id(2L);
        invoice.setUnit_price(BigDecimal.valueOf(550.99));
        invoice.setQuantity(1);
        invoice.setSubtotal(BigDecimal.valueOf(550.99));
        invoice.setTax(BigDecimal.valueOf(1.05));
        invoice.setProcessing_fee(BigDecimal.valueOf(14.99));
        invoice.setTotal(BigDecimal.valueOf(593.52));   //593.53? rounding?

        invoice = invoiceRepository.save(invoice);

        List<Invoice> aList = invoiceRepository.findAll();

        assertEquals(aList.size(), 2);

    }

    @Test
    public void shouldUpdateInvoice() {

        Game game = new Game();
        game.setGame_id(1L);
        game.setTitle("Breath of the Wild");
        game.setEsrb_rating("E10+");
        game.setDescription("The player controls an amnesiac Link, who awakens from a hundred-year slumber, and attempts to regain his memories and prevent the destruction of Hyrule by Calamity Ganon.");
        game.setStudio("Nintendo");
        game.setPrice(BigDecimal.valueOf(40.99));
        game.setQuantity(150);
        gameRepository.save(game);

        game = gameRepository.save(game);

        SalesTax salesTax = new SalesTax();
        salesTax.setState("CA");
        salesTax.setRate(BigDecimal.valueOf(1.06));
        salesTaxRepository.save(salesTax);

        salesTax = salesTaxRepository.save(salesTax);

        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setProduct_type("game");
        processingFee.setFee(BigDecimal.valueOf(1.49));
        processingFeeRepository.save(processingFee);

        processingFee = processingFeeRepository.save(processingFee);

        Invoice invoice = new Invoice();
        invoice.setInvoice_id((1L));
        invoice.setName("Mary");
        invoice.setStreet("123 Oak Avenue");
        invoice.setCity("San Diego");
        invoice.setState("CA");
        invoice.setZipcode("92129");
        invoice.setItem_type("game");
        invoice.setItem_id(1L);
        invoice.setUnit_price(BigDecimal.valueOf(40.99));
        invoice.setQuantity(2);
        invoice.setSubtotal(BigDecimal.valueOf(81.98));
        invoice.setTax(BigDecimal.valueOf(1.06));
        invoice.setProcessing_fee(BigDecimal.valueOf(1.49));
        invoice.setTotal(BigDecimal.valueOf(88.38));   //88.39? rounding?

        invoice = invoiceRepository.save(invoice);

        TShirt tShirt = new TShirt();
        tShirt = new TShirt();
        tShirt.setT_shirt_id(2L);
        tShirt.setSize("Medium");
        tShirt.setColor("Green");
        tShirt.setDescription("Women's Horizon Zero Dawn t-shirt");
        tShirt.setPrice(BigDecimal.valueOf(35.99));
        tShirt.setQuantity(1500);

        tShirt = tShirtRepository.save(tShirt);

        SalesTax salesTax = new SalesTax();
        salesTax.setState("OR");
        salesTax.setRate(BigDecimal.valueOf(1.07));
        salesTaxRepository.save(salesTax);

        salesTax = salesTaxRepository.save(salesTax);

        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setProduct_type("tShirt");
        processingFee.setFee(BigDecimal.valueOf(1.98));
        processingFeeRepository.save(processingFee);

        processingFee = processingFeeRepository.save(processingFee);

        Invoice invoice = new Invoice();
        invoice.setInvoice_id((1L));
        invoice.setName("Mary Ann");
        invoice.setStreet("555 Park Place");
        invoice.setCity("Portland");
        invoice.setState("OR");
        invoice.setZipcode("97035");
        invoice.setItem_type("shirt");
        invoice.setItem_id(3L);
        invoice.setUnit_price(BigDecimal.valueOf(35.99));
        invoice.setQuantity(3);
        invoice.setSubtotal(BigDecimal.valueOf(107.97));
        invoice.setTax(BigDecimal.valueOf(1.07));
        invoice.setProcessing_fee(BigDecimal.valueOf(1.98));
        invoice.setTotal(BigDecimal.valueOf(117.50));   //117.51? rounding?

        invoice = invoiceRepository.save(invoice);

        invoiceRepository.save(invoice);

        Optional<Invoice> invoice1 = invoiceRepository.findById(invoice.getInvoice_id());
        assertEquals(invoice1.get(), invoice);

    }

}