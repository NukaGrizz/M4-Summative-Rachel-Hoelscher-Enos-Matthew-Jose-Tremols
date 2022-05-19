package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.service;

import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model.*;
import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.repository.*;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class ServiceLayerTest {

    ServiceLayer service;
    ConsoleRepository consoleRepository;
    GameRepository gameRepository;
    TShirtRepository tShirtRepository;
    InvoiceRepository invoiceRepository;
    SalesTaxRepository salesTaxRepository;
    ProcessingFeeRepository processingFeeRepository;

    @Before
    public void setUp() throws Exception {
        setUpConsoleRepositoryMock();
        setUpGameRepositoryMock();
        setUpTShirtRepositoryMock();
        setUpInvoiceRepositoryMock();
        setUpSalesTaxRepositoryMock();
        setUpProcessingFeeRepository();

        service = new ServiceLayer(consoleRepository, gameRepository, tShirtRepository, invoiceRepository, salesTaxRepository, processingFeeRepository);
    }

    // Helper methods
    private void setUpConsoleRepositoryMock() {
        consoleRepository = mock(ConsoleRepository.class);
        Console console1 = new Console();
        console1.setConsole_id(1L);
        console1.setModel("PS5");
        console1.setManufacturer("Sony");
        console1.setMemory_amount("825 GB");
        console1.setProcessor("AMD Zen 2 CPU");
        console1.setPrice(BigDecimal.valueOf(499.99));
        console1.setQuantity(100);

        Console console2 = new Console();
        console2.setConsole_id(2L);
        console2.setModel("XBox Series X");
        console2.setManufacturer("Microsoft");
        console2.setMemory_amount("1TB");
        console2.setProcessor("AMD Zen 2 CPU");
        console2.setPrice(BigDecimal.valueOf(550.99));
        console2.setQuantity(200);

        List<Console> cList = new ArrayList<>();
        cList.add(console1);

        doReturn(console1).when(consoleRepository).save(console2);
        doReturn(Optional.of(console1)).when(consoleRepository).findById(1L);
        doReturn(cList).when(consoleRepository).findAll();
    }

    private void setUpGameRepositoryMock() {
        gameRepository = mock(GameRepository.class);
        Game game1 = new Game();
        game1.setGame_id(1L);
        game1.setTitle("Breath of the Wild");
        game1.setEsrbRating("E10+");
        game1.setDescription("The player controls an amnesiac Link, who awakens from a hundred-year slumber, and attempts to regain his memories and prevent the destruction of Hyrule by Calamity Ganon.");
        game1.setStudio("Nintendo");
        game1.setPrice(BigDecimal.valueOf(40.99));
        game1.setQuantity(150);

        Game game2 = new Game();
        game2.setGame_id(1L);
        game2.setTitle("Resident Evil Village");
        game2.setEsrbRating("M17+");
        game2.setDescription("Players control Ethan Winters, who searches for his kidnapped daughter in a village filled with mutant creatures. ");
        game2.setStudio("Capcom");
        game2.setPrice(BigDecimal.valueOf(35.99));
        game2.setQuantity(150);

        List gList = new ArrayList();
        gList.add(game1);

        doReturn(game1).when(gameRepository).save(game2);
        doReturn(Optional.of(game1)).when(gameRepository).findById(1L);
        doReturn(gList).when(gameRepository).findAll();
    }

    private void setUpTShirtRepositoryMock() {
        tShirtRepository = mock(TShirtRepository.class);
        TShirt tShirt1 = new TShirt();
        tShirt1.setT_shirt_id(1L);
        tShirt1.setSize("Large");
        tShirt1.setColor("Blue");
        tShirt1.setDescription("Men's 100% Smash Bros Shirt");
        tShirt1.setPrice(BigDecimal.valueOf(29.99));
        tShirt1.setQuantity(1000);

        TShirt tShirt2 = new TShirt();
        tShirt2.setT_shirt_id(2L);
        tShirt2.setSize("Medium");
        tShirt2.setColor("Green");
        tShirt2.setDescription("Women's Horizon Zero Dawn t-shirt");
        tShirt2.setPrice(BigDecimal.valueOf(35.99));
        tShirt2.setQuantity(1500);

        List tList = new ArrayList<>();
        tList.add(tShirt1);

        doReturn(tShirt1).when(tShirtRepository).save(tShirt2);
        doReturn(Optional.of(tShirt1)).when(tShirtRepository).findById(1L);
        doReturn(tList).when(tShirtRepository).findAll();
    }

    private void setUpInvoiceRepositoryMock() {
        invoiceRepository = mock(InvoiceRepository.class);
        Invoice invoice1 = new Invoice();
        invoice1.setInvoice_id((1L));
        invoice1.setName("Mary");
        invoice1.setStreet("123 Oak Avenue");
        invoice1.setCity("San Diego");
        invoice1.setState("CA");
        invoice1.setZipcode("92129");
        invoice1.setItemType("game");
        invoice1.setItemId(1L);
        invoice1.setUnit_price(BigDecimal.valueOf(35.99));
        invoice1.setQuantity(1);
        invoice1.setSubtotal(BigDecimal.valueOf(35.99));
        invoice1.setTax(BigDecimal.valueOf(1.06));
        invoice1.setProcessing_fee(BigDecimal.valueOf(1.98));
        invoice1.setTotal(BigDecimal.valueOf(40.12));

        Invoice invoice2 = new Invoice();
        invoice2.setInvoice_id((2L));
        invoice2.setName("John");
        invoice2.setStreet("321 Main Street");
        invoice2.setCity("Honolulu");
        invoice2.setState("Hawaii");
        invoice2.setZipcode("96795");
        invoice2.setItemType("console");
        invoice2.setItemId(2L);
        invoice2.setUnit_price(BigDecimal.valueOf(550.99));
        invoice2.setQuantity(1);
        invoice2.setSubtotal(BigDecimal.valueOf(550.99));
        invoice2.setTax(BigDecimal.valueOf(1.05));
        invoice2.setProcessing_fee(BigDecimal.valueOf(14.99));
        invoice2.setTotal(BigDecimal.valueOf(593.52));

        List iList = new ArrayList<>();
        iList.add(invoice1);

        doReturn(invoice1).when(invoiceRepository).save(invoice2);
        doReturn(Optional.of(invoice1)).when(invoiceRepository).findById(1L);
        doReturn(iList).when(invoiceRepository).findAll();
    }

    private void setUpSalesTaxRepositoryMock() {
        salesTaxRepository = mock(SalesTaxRepository.class);
        SalesTax salesTax1 = new SalesTax();
        salesTax1.setState("CA");
        salesTax1.setRate(BigDecimal.valueOf(.06));

        SalesTax salesTax2 = new SalesTax();
        salesTax2.setState("HI");
        salesTax2.setRate(BigDecimal.valueOf(.05));

        List stList = new ArrayList<>();
        stList.add(salesTax1);

        doReturn(salesTax1).when(salesTaxRepository).save(salesTax2);
        doReturn(Optional.of(salesTax1)).when(salesTaxRepository).findById("CA");
        doReturn(stList).when(salesTaxRepository).findAll();
    }

    private void setUpProcessingFeeRepository() {
        processingFeeRepository = mock(ProcessingFeeRepository.class);
        ProcessingFee processingFee1 = new ProcessingFee();
        processingFee1.setProduct_type("game");
        processingFee1.setFee(BigDecimal.valueOf(1.49));
        processingFeeRepository.save(processingFee1);

        ProcessingFee processingFee2 = new ProcessingFee();
        processingFee2.setProduct_type("console");
        processingFee2.setFee(BigDecimal.valueOf(14.99));
        processingFeeRepository.save(processingFee2);

        List pfList = new ArrayList<>();
        pfList.add(processingFee1);

        doReturn(processingFee1).when(processingFeeRepository).save(processingFee2);
        doReturn(Optional.of(processingFee1)).when(processingFeeRepository).findById("console");
        doReturn(pfList).when(salesTaxRepository).findAll();
    }

    //

    @Test
    public void shouldSaveConsole() {
        Console consoleToSave = new Console();
        consoleToSave.setModel("PS5");
        consoleToSave.setManufacturer("Sony");
        consoleToSave.setMemory_amount("825 GB");
        consoleToSave.setProcessor("AMD Zen 2 CPU");
        consoleToSave.setPrice(BigDecimal.valueOf(499.99));
        consoleToSave.setQuantity(100);

        Console expectedConsole = new Console();
        expectedConsole.setModel("PS5");
        expectedConsole.setManufacturer("Sony");
        expectedConsole.setMemory_amount("825 GB");
        expectedConsole.setProcessor("AMD Zen 2 CPU");
        expectedConsole.setPrice(BigDecimal.valueOf(499.99));
        expectedConsole.setQuantity(100);
        expectedConsole.setConsole_id(1L);

        Console actualResult = service.saveConsole(consoleToSave);

        assertEquals(expectedConsole, actualResult);
    }

    @Test
    public void findConsole() {
        Console console1 = new Console();
        console1.setConsole_id(1L);
        console1.setModel("PS5");
        console1.setManufacturer("Sony");
        console1.setMemory_amount("825 GB");
        console1.setProcessor("AMD Zen 2 CPU");
        console1.setPrice(BigDecimal.valueOf(499.99));
        console1.setQuantity(100);

        Console console = service.findConsole(1L);
        assertEquals(console1, console);
    }

    @Test
    public void findAllConsole() {

        Console console1 = new Console();
        console1.setConsole_id(1L);
        console1.setModel("PS5");
        console1.setManufacturer("Sony");
        console1.setMemory_amount("825 GB");
        console1.setProcessor("AMD Zen 2 CPU");
        console1.setPrice(BigDecimal.valueOf(499.99));
        console1.setQuantity(100);

        Console console2 = new Console();
        console2.setConsole_id(2L);
        console2.setModel("XBox Series X");
        console2.setManufacturer("Microsoft");
        console2.setMemory_amount("1TB");
        console2.setProcessor("AMD Zen 2 CPU");
        console2.setPrice(BigDecimal.valueOf(550.99));
        console2.setQuantity(200);

        List<Console> fromService = service.findAllConsole();

        assertEquals(2, fromService.size());
    }

    @Test
    public void findByManufacturer() {
        List<Console> fromService = service.findAllConsole("manufacturerExample");

        assertEquals(1, fromService.size());
    }

    @Test
    public void updateConsole() {
        Console console1 = new Console();
        console1.setConsole_id(1L);
        console1.setModel("PS5");
        console1.setManufacturer("Sony");
        console1.setMemory_amount("825 GB");
        console1.setProcessor("AMD Zen 2 CPU");
        console1.setPrice(BigDecimal.valueOf(499.99));
        console1.setQuantity(100);

        Console console2 = new Console();
        console2.setConsole_id(2L);
        console2.setModel("XBox Series X");
        console2.setManufacturer("Microsoft");
        console2.setMemory_amount("1TB");
        console2.setProcessor("AMD Zen 2 CPU");
        console2.setPrice(BigDecimal.valueOf(550.99));
        console2.setQuantity(200);

    }

    @Test
    public void removeConsole() {
    }

    @Test
    public void shouldSaveGame() {
        Game gameToSave = new Game();
        gameToSave.setTitle("Breath of the Wild");
        gameToSave.setEsrbRating("E10+");
        gameToSave.setDescription("The player controls an amnesiac Link, who awakens from a hundred-year slumber, and attempts to regain his memories and prevent the destruction of Hyrule by Calamity Ganon.");
        gameToSave.setStudio("Nintendo");
        gameToSave.setPrice(BigDecimal.valueOf(40.99));
        gameToSave.setQuantity(150);

        Game expectedGame = new Game();
        expectedGame.setTitle("Breath of the Wild");
        expectedGame.setEsrbRating("E10+");
        expectedGame.setDescription("The player controls an amnesiac Link, who awakens from a hundred-year slumber, and attempts to regain his memories and prevent the destruction of Hyrule by Calamity Ganon.");
        expectedGame.setStudio("Nintendo");
        expectedGame.setPrice(BigDecimal.valueOf(40.99));
        expectedGame.setQuantity(150);
        expectedGame.setGame_id(1L);

        Game actualResult = service.saveGame(gameToSave);

        assertEquals(expectedGame, actualResult);
    }

    @Test
    public void findGame() {
    }

    @Test
    public void findAllGame() {
        List<Game> fromService = service.findAllGame();

        assertEquals(1, fromService.size());
    }

    @Test
    public void updateGame() {
    }

    @Test
    public void removeGame() {
    }

    @Test
    public void findByStudio() {
    }

    @Test
    public void findByRating() {
    }

    @Test
    public void findByTitle() {
    }

    @Test
    public void shouldSaveTShirt() {
        TShirt tShirtToSave = new TShirt();
        tShirtToSave.setSize("Large");
        tShirtToSave.setColor("Blue");
        tShirtToSave.setDescription("Men's 100% Smash Bros Shirt");
        tShirtToSave.setPrice(BigDecimal.valueOf(29.99));
        tShirtToSave.setQuantity(1000);

        TShirt expectedTShirt = new TShirt();
        expectedTShirt.setSize("Large");
        expectedTShirt.setColor("Blue");
        expectedTShirt.setDescription("Men's 100% Smash Bros Shirt");
        expectedTShirt.setPrice(BigDecimal.valueOf(29.99));
        expectedTShirt.setQuantity(1000);
        expectedTShirt.setT_shirt_id(1L);

        TShirt actualResult = service.saveTShirt(tShirtToSave);

        assertEquals(expectedTShirt, actualResult);
    }

    @Test
    public void findTShirt() {
    }

    @Test
    public void findAllTShirt() {
        List<TShirt> fromService = service.findAllTShirt();

        assertEquals(1, fromService.size());
    }

    @Test
    public void updateTShirt() {
    }

    @Test
    public void removeTShirt() {
    }

    @Test
    public void findByColor() {
    }

    @Test
    public void findBySize() {
    }

    @Test
    public void shouldSaveInvoice() {
        Invoice invoiceToSave = new Invoice();
        invoiceToSave.setInvoice_id((155L));
        invoiceToSave.setName("Mary");
        invoiceToSave.setStreet("123 Oak Avenue");
        invoiceToSave.setCity("San Diego");
        invoiceToSave.setState("CA");
        invoiceToSave.setZipcode("92129");
        invoiceToSave.setItemType("game");
        invoiceToSave.setItemId(1L);
        invoiceToSave.setQuantity(1);

        Invoice expectedInvoice = new Invoice();
        expectedInvoice.setName("Mary");
        expectedInvoice.setStreet("123 Oak Avenue");
        expectedInvoice.setCity("San Diego");
        expectedInvoice.setState("CA");
        expectedInvoice.setZipcode("92129");
        expectedInvoice.setItemType("game");
        expectedInvoice.setItemId(1L);
        expectedInvoice.setUnit_price(BigDecimal.valueOf(35.99));
        expectedInvoice.setQuantity(1);
        expectedInvoice.setSubtotal(BigDecimal.valueOf(35.99));
        expectedInvoice.setTax(BigDecimal.valueOf(1.06));
        expectedInvoice.setProcessing_fee(BigDecimal.valueOf(1.98));
        expectedInvoice.setTotal(BigDecimal.valueOf(40.12));
        expectedInvoice.setInvoice_id((1L));

        Invoice actualResult = service.saveInvoice(Invoice, invoiceToSave);

        assertEquals(expectedInvoice, actualResult);
    }

    @Test
    public void findInvoice() {
    }

    @Test
    public void findAllInvoice() {
    }

    @Test
    public void updateInvoice() {
    }

    @Test
    public void removeInvoice() {
    }

    @Test
    public void shouldSaveProcessingFee() {
        ProcessingFee processingFeeToSave = new ProcessingFee();
        processingFeeToSave.setProduct_type("game");
        processingFeeToSave.setFee(BigDecimal.valueOf(1.49));

        ProcessingFee expectedProcessingFee = new ProcessingFee();
        expectedProcessingFee.setProduct_type("game");
        expectedProcessingFee.setFee(BigDecimal.valueOf(1.49));

        ProcessingFee actualResult = service.saveProcessingFee(processingFeeToSave);

        assertEquals(expectedProcessingFee, actualResult);
    }

    @Test
    public void findProcessingFee() {
        processingFee fromService = service.findProcessingFee();

        assertEquals(1, fromService.size());
    }

    @Test
    public void findAllProcessingFee() {
        List<ProcessingFee> fromService = service.findAllProcessingFee();

        assertEquals(1, fromService.size());
    }

    @Test
    public void updateProcessingFee() {
    }

    @Test
    public void removeProcessingFee() {
    }

    @Test
    public void shouldSaveSalesTax() {
        SalesTax salesTaxToSave = new SalesTax();
        salesTaxToSave.setState("HI");
        salesTaxToSave.setRate(BigDecimal.valueOf(.05));

        SalesTax expectedSalesTax = new SalesTax();
        expectedSalesTax.setState("HI");
        expectedSalesTax.setRate(BigDecimal.valueOf(.05));

        SalesTax actualResult = service.saveSalesTax(salesTaxToSave);

        assertEquals(expectedSalesTax, actualResult);
    }

    @Test
    public void findSalesTax() {
        salesTax fromService = service.findSalesTax();

        assertEquals(1, fromService.size());
    }

    @Test
    public void findAllSalesTax() {
        List<SalesTax> fromService = service.findAllSalesTax();

        assertEquals(1, fromService.size());
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

        Optional<SalesTax> salesTax1 = salesTaxRepository.findById("HI");
        assertEquals(salesTax1.get(), salesTax);
    }

    @Test
    public void removeSalesTax() {
    }
}