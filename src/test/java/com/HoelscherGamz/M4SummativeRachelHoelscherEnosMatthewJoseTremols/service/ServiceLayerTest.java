package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.service;

import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model.*;
import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.repository.*;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

        service = new ServiceLayer(consoleRepository, gameRepository, invoiceRepository, processingFeeRepository, salesTaxRepository, tShirtRepository);
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

        Console console3 = new Console();
        console3.setModel("PS5");
        console3.setManufacturer("Sony");
        console3.setMemory_amount("825 GB");
        console3.setProcessor("AMD Zen 2 CPU");
        console3.setPrice(BigDecimal.valueOf(499.99));
        console3.setQuantity(100);

        List cList2 = new ArrayList<>();
        cList2.add(console1);
        cList2.add(console2);

        doReturn(console1).when(consoleRepository).save(console3);
        doReturn(Optional.of(console1)).when(consoleRepository).findById(1L);
        doReturn(cList2).when(consoleRepository).findAll();
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
        game2.setGame_id(2L);
        game2.setTitle("Resident Evil Village");
        game2.setEsrbRating("M17+");
        game2.setDescription("Players control Ethan Winters, who searches for his kidnapped daughter in a village filled with mutant creatures. ");
        game2.setStudio("Capcom");
        game2.setPrice(BigDecimal.valueOf(35.99));
        game2.setQuantity(150);

        Game game3 = new Game();
        game3.setTitle("Breath of the Wild");
        game3.setEsrbRating("E10+");
        game3.setDescription("The player controls an amnesiac Link, who awakens from a hundred-year slumber, and attempts to regain his memories and prevent the destruction of Hyrule by Calamity Ganon.");
        game3.setStudio("Nintendo");
        game3.setPrice(BigDecimal.valueOf(40.99));
        game3.setQuantity(150);

        List gList2 = new ArrayList<>();
        gList2.add(game1);
        gList2.add(game2);

        doReturn(game1).when(gameRepository).save(game3);
        doReturn(Optional.of(game1)).when(gameRepository).findById(1L);
        doReturn(gList2).when(gameRepository).findAll();

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

        TShirt tShirt3 = new TShirt();
        tShirt3.setSize("Large");
        tShirt3.setColor("Blue");
        tShirt3.setDescription("Men's 100% Smash Bros Shirt");
        tShirt3.setPrice(BigDecimal.valueOf(29.99));
        tShirt3.setQuantity(1000);

        TShirt tShirt4 = new TShirt();
        tShirt4.setSize("Medium");
        tShirt4.setColor("Green");
        tShirt4.setDescription("Women's Horizon Zero Dawn t-shirt");
        tShirt4.setPrice(BigDecimal.valueOf(35.99));
        tShirt4.setQuantity(1500);

//        List tList = new ArrayList<>();
//        tList.add(tShirt1);

        List tList2 = new ArrayList<>();
        tList2.add(tShirt1);
        tList2.add(tShirt2);

        doReturn(tShirt1).when(tShirtRepository).save(tShirt3);
        doReturn(Optional.of(tShirt1)).when(tShirtRepository).findById(1L);
        doReturn(tList2).when(tShirtRepository).findAll();
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

        Invoice invoice3 = new Invoice();
        invoice3.setName("Mary");
        invoice3.setStreet("123 Oak Avenue");
        invoice3.setCity("San Diego");
        invoice3.setState("CA");
        invoice3.setZipcode("92129");
        invoice3.setItemType("game");
        invoice3.setItemId(1L);
        invoice3.setUnit_price(BigDecimal.valueOf(40.99));
        invoice3.setQuantity(1);
        invoice3.setSubtotal(BigDecimal.valueOf(40.99));
        invoice3.setTax(BigDecimal.valueOf(2.46));
        invoice3.setProcessing_fee(BigDecimal.valueOf(1.49));
        invoice3.setTotal(BigDecimal.valueOf(44.94));

        Invoice invoice4 = new Invoice();
        invoice4.setInvoice_id((1L));
        invoice4.setName("Mary");
        invoice4.setStreet("123 Oak Avenue");
        invoice4.setCity("San Diego");
        invoice4.setState("CA");
        invoice4.setZipcode("92129");
        invoice4.setItemType("game");
        invoice4.setItemId(1L);
        invoice4.setUnit_price(BigDecimal.valueOf(40.99));
        invoice4.setQuantity(1);
        invoice4.setSubtotal(BigDecimal.valueOf(40.99));
        invoice4.setTax(BigDecimal.valueOf(2.46));
        invoice4.setProcessing_fee(BigDecimal.valueOf(1.49));
        invoice4.setTotal(BigDecimal.valueOf(44.94));

        List iList2 = new ArrayList<>();
        iList2.add(invoice1);
        iList2.add(invoice2);

        doReturn(invoice4).when(invoiceRepository).save(invoice3);
        doReturn(Optional.of(invoice1)).when(invoiceRepository).findById(1L);
        doReturn(iList2).when(invoiceRepository).findAll();
    }

    private void setUpSalesTaxRepositoryMock() {
        salesTaxRepository = mock(SalesTaxRepository.class);
        SalesTax salesTax1 = new SalesTax();
        salesTax1.setState("CA");
        salesTax1.setRate(BigDecimal.valueOf(.06));

        SalesTax salesTax2 = new SalesTax();
        salesTax2.setState("HI");
        salesTax2.setRate(BigDecimal.valueOf(.05));

        List stList2 = new ArrayList<>();
        stList2.add(salesTax1);
        stList2.add(salesTax2);

        doReturn(salesTax1).when(salesTaxRepository).save(salesTax1);
        doReturn(salesTax2).when(salesTaxRepository).save(salesTax2);
        doReturn(Optional.of(salesTax1)).when(salesTaxRepository).findById("CA");
        doReturn(Optional.of(salesTax2)).when(salesTaxRepository).findById("HI");
        doReturn(stList2).when(salesTaxRepository).findAll();
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

        List pfList2 = new ArrayList<>();
        pfList2.add(processingFee1);
        pfList2.add(processingFee2);

        doReturn(processingFee1).when(processingFeeRepository).save(processingFee1);
        doReturn(processingFee2).when(processingFeeRepository).save(processingFee2);
        doReturn(Optional.of(processingFee1)).when(processingFeeRepository).findById("game");
        doReturn(pfList2).when(processingFeeRepository).findAll();
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
    public void shouldFindConsole() {
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
    public void shouldFindAllConsoles() {

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

        List expectedList = new ArrayList<>();
        expectedList.add(console1);
        expectedList.add(console2);

        String manufacturer = null;
        List<Console> fromService = service.findAllConsole((manufacturer));

        assertEquals(expectedList, fromService);
    }

    @Test
    public void shouldFindByManufacturer() {
        List<Console> fromService = service.findAllConsole("Sony");

        assertEquals(1, fromService.size());
    }

//    @Test
//    public void shouldUpdateConsole() {
//        Console console = new Console();
//        console.setConsole_id(1L);
//        console.setModel("PS5");
//        console.setManufacturer("Sony");
//        console.setMemory_amount("825 GB");
//        console.setProcessor("AMD Zen 2 CPU");
//        console.setPrice(BigDecimal.valueOf(499.99));
//        console.setQuantity(100);
//
//        console.setModel("XBox Series X");
//        console.setManufacturer("Microsoft");
//        console.setMemory_amount("1TB");
//        console.setProcessor("AMD Zen 2 CPU");
//        console.setPrice(BigDecimal.valueOf(550.99));
//        console.setQuantity(200);
//
//        Console expectedConsole = new Console();
//        expectedConsole.setConsole_id(1L);
//        expectedConsole.setModel("XBox Series X");
//        expectedConsole.setManufacturer("Microsoft");
//        expectedConsole.setMemory_amount("1TB");
//        expectedConsole.setProcessor("AMD Zen 2 CPU");
//        expectedConsole.setPrice(BigDecimal.valueOf(550.99));
//        expectedConsole.setQuantity(200);
//
//        service.updateConsole(console);
//    }


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
    public void shouldFindGame() {
        Game game1 = new Game();
        game1.setGame_id(1L);
        game1.setTitle("Breath of the Wild");
        game1.setEsrbRating("E10+");
        game1.setDescription("The player controls an amnesiac Link, who awakens from a hundred-year slumber, and attempts to regain his memories and prevent the destruction of Hyrule by Calamity Ganon.");
        game1.setStudio("Nintendo");
        game1.setPrice(BigDecimal.valueOf(40.99));
        game1.setQuantity(150);

        Game game = service.findGame(1L);
        assertEquals(game1, game);
    }

    @Test
    public void shouldFindAllGames() {
        Game game1 = new Game();
        game1.setGame_id(1L);
        game1.setTitle("Breath of the Wild");
        game1.setEsrbRating("E10+");
        game1.setDescription("The player controls an amnesiac Link, who awakens from a hundred-year slumber, and attempts to regain his memories and prevent the destruction of Hyrule by Calamity Ganon.");
        game1.setStudio("Nintendo");
        game1.setPrice(BigDecimal.valueOf(40.99));
        game1.setQuantity(150);

        Game game2 = new Game();
        game2.setGame_id(2L);
        game2.setTitle("Resident Evil Village");
        game2.setEsrbRating("M17+");
        game2.setDescription("Players control Ethan Winters, who searches for his kidnapped daughter in a village filled with mutant creatures. ");
        game2.setStudio("Capcom");
        game2.setPrice(BigDecimal.valueOf(35.99));
        game2.setQuantity(150);

        List expectedList = new ArrayList<>();
        expectedList.add(game1);
        expectedList.add(game2);

        String studio = null;
        String esrb = null;
        String title = null;
        List<Game> fromService = service.findAllGame(studio, esrb, title);

        assertEquals(expectedList, fromService);
    }

//    @Test
//    public void shouldUpdateGame() {
//        Game game = new Game();
//        game.setGame_id(1L);
//        game.setTitle("Breath of the Wild");
//        game.setEsrbRating("E10+");
//        game.setDescription("The player controls an amnesiac Link, who awakens from a hundred-year slumber, and attempts to regain his memories and prevent the destruction of Hyrule by Calamity Ganon.");
//        game.setStudio("Nintendo");
//        game.setPrice(BigDecimal.valueOf(40.99));
//        game.setQuantity(150);
//        gameRepository.save(game);
//
//        game.setTitle("Resident Evil Village");
//        game.setEsrbRating("M17+");
//        game.setDescription("Players control Ethan Winters, who searches for his kidnapped daughter in a village filled with mutant creatures. ");
//        game.setStudio("Capcom");
//        game.setPrice(BigDecimal.valueOf(35.99));
//        game.setQuantity(150);
//        gameRepository.save(game);
//
//        Game expectedGame = new Game();
//        expectedGame.setGame_id(1L);
//        expectedGame.setTitle("Resident Evil Village");
//        expectedGame.setEsrbRating("M17+");
//        expectedGame.setDescription("Players control Ethan Winters, who searches for his kidnapped daughter in a village filled with mutant creatures. ");
//        expectedGame.setStudio("Capcom");
//        expectedGame.setPrice(BigDecimal.valueOf(35.99));
//        expectedGame.setQuantity(150);
//
//        Game actualResult = service.saveGame(game);
//
//        assertEquals(expectedGame, actualResult);
//    }

    @Test
    public void shouldFindByStudio() {
        Game game = new Game();
        game.setGame_id(1L);
        game.setTitle("Breath of the Wild");
        game.setEsrbRating("E10+");
        game.setDescription("The player controls an amnesiac Link, who awakens from a hundred-year slumber, and attempts to regain his memories and prevent the destruction of Hyrule by Calamity Ganon.");
        game.setStudio("Nintendo");
        game.setPrice(BigDecimal.valueOf(40.99));
        game.setQuantity(150);

        String esrbRating = null;
        String title = null;
        List<Game> fromService = service.findAllGame("Nintendo", esrbRating,title);
        List<Game> expectedList = new ArrayList<>();
        expectedList.add(game);

        assertEquals(expectedList, fromService);

//        List<Game> fromService = service.findByStudio("Capcom");
//
//        assertEquals(1, fromService.size());

    }

    @Test
    public void shouldFindByRating() {
        Game game = new Game();
        game.setGame_id(1L);
        game.setTitle("Breath of the Wild");
        game.setEsrbRating("E10+");
        game.setDescription("The player controls an amnesiac Link, who awakens from a hundred-year slumber, and attempts to regain his memories and prevent the destruction of Hyrule by Calamity Ganon.");
        game.setStudio("Nintendo");
        game.setPrice(BigDecimal.valueOf(40.99));
        game.setQuantity(150);

        String studio = null;
        String title = null;
        List<Game> fromService = service.findAllGame(studio, "E10+",title);
        List<Game> expectedList = new ArrayList<>();
        expectedList.add(game);

        assertEquals(expectedList, fromService);
    }

    @Test
    public void shouldFindByTitle() {
        Game game = new Game();
        game.setGame_id(1L);
        game.setTitle("Breath of the Wild");
        game.setEsrbRating("E10+");
        game.setDescription("The player controls an amnesiac Link, who awakens from a hundred-year slumber, and attempts to regain his memories and prevent the destruction of Hyrule by Calamity Ganon.");
        game.setStudio("Nintendo");
        game.setPrice(BigDecimal.valueOf(40.99));
        game.setQuantity(150);

        String studio = null;
        String esrb = null;
        List<Game> fromService = service.findAllGame(studio, esrb,"Breath of the Wild");
        List<Game> expectedList = new ArrayList<>();
        expectedList.add(game);

        assertEquals(expectedList, fromService);
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
    public void shouldFindTShirt() {
        TShirt tShirt1 = new TShirt();
        tShirt1.setT_shirt_id(1L);
        tShirt1.setSize("Large");
        tShirt1.setColor("Blue");
        tShirt1.setDescription("Men's 100% Smash Bros Shirt");
        tShirt1.setPrice(BigDecimal.valueOf(29.99));
        tShirt1.setQuantity(1000);

        TShirt tShirt = service.findTShirt(1L);
        assertEquals(tShirt1, tShirt);
    }

    @Test
    public void shouldFindAllTShirt() {
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

        List expectedList = new ArrayList<>();
        expectedList.add(tShirt1);
        expectedList.add(tShirt2);

        String color = null;
        String size = null;

        List<TShirt> fromService = service.findAllTShirt(color, size);

        assertEquals(expectedList, fromService);
    }

//    @Test
//    public void shouldUpdateTShirt() {
//        TShirt tShirt = new TShirt();
//        tShirt.setT_shirt_id(1L);
//        tShirt.setSize("Large");
//        tShirt.setColor("Blue");
//        tShirt.setDescription("Men's 100% Smash Bros Shirt");
//        tShirt.setPrice(BigDecimal.valueOf(29.99));
//        tShirt.setQuantity(1000);
//        tShirtRepository.save(tShirt);
//
//        tShirt.setSize("Medium");
//        tShirt.setColor("Green");
//        tShirt.setDescription("Women's Horizon Zero Dawn t-shirt");
//        tShirt.setPrice(BigDecimal.valueOf(35.99));
//        tShirt.setQuantity(1500);
//        tShirtRepository.save(tShirt);
//
//        TShirt expectedTShirt = new TShirt();
//        expectedTShirt.setT_shirt_id(1L);
//        expectedTShirt.setSize("Medium");
//        expectedTShirt.setColor("Green");
//        expectedTShirt.setDescription("Women's Horizon Zero Dawn t-shirt");
//        expectedTShirt.setPrice(BigDecimal.valueOf(35.99));
//        expectedTShirt.setQuantity(1500);
//
//        TShirt actualResult = service.saveTShirt(tShirt);
//
//        assertEquals(expectedTShirt, actualResult);
//    }

    @Test
    public void shouldFindByColor() {
        TShirt tShirt = new TShirt();
        tShirt.setT_shirt_id(1L);
        tShirt.setSize("Large");
        tShirt.setColor("Blue");
        tShirt.setDescription("Men's 100% Smash Bros Shirt");
        tShirt.setPrice(BigDecimal.valueOf(29.99));
        tShirt.setQuantity(1000);

        String size = null;
        List<TShirt> fromService = service.findAllTShirt("Blue", size);
        List<TShirt> expectedList = new ArrayList<>();
        expectedList.add(tShirt);

        assertEquals(expectedList, fromService);
    }

    @Test
    public void shouldFindBySize() {
        TShirt tShirt = new TShirt();
        tShirt.setT_shirt_id(1L);
        tShirt.setSize("Large");
        tShirt.setColor("Blue");
        tShirt.setDescription("Men's 100% Smash Bros Shirt");
        tShirt.setPrice(BigDecimal.valueOf(29.99));
        tShirt.setQuantity(1000);

        String color = null;
        List<TShirt> fromService = service.findAllTShirt(color, "Large");
        List<TShirt> expectedList = new ArrayList<>();
        expectedList.add(tShirt);

        assertEquals(expectedList, fromService);
    }

    @Test
    public void shouldSaveInvoice() throws Exception {
        Invoice invoiceToSave = new Invoice();
        invoiceToSave.setName("Mary");
        invoiceToSave.setStreet("123 Oak Avenue");
        invoiceToSave.setCity("San Diego");
        invoiceToSave.setState("CA");
        invoiceToSave.setZipcode("92129");
        invoiceToSave.setItemType("game");
        invoiceToSave.setItemId(1L);
        invoiceToSave.setQuantity(1);

        Invoice expectedInvoice = new Invoice();
        expectedInvoice.setInvoice_id((1L));
        expectedInvoice.setName("Mary");
        expectedInvoice.setStreet("123 Oak Avenue");
        expectedInvoice.setCity("San Diego");
        expectedInvoice.setState("CA");
        expectedInvoice.setZipcode("92129");
        expectedInvoice.setItemType("game");
        expectedInvoice.setItemId(1L);
        expectedInvoice.setUnit_price(BigDecimal.valueOf(40.99));
        expectedInvoice.setQuantity(1);
        expectedInvoice.setSubtotal(BigDecimal.valueOf(40.99));
        expectedInvoice.setTax(BigDecimal.valueOf(2.46));
        expectedInvoice.setProcessing_fee(BigDecimal.valueOf(1.49));
        expectedInvoice.setTotal(BigDecimal.valueOf(44.94));

        Invoice actualResult = service.saveInvoice(invoiceToSave);

        assertEquals(expectedInvoice, actualResult);
    }

    @Test
    public void shouldFindInvoice() {
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

        Invoice invoice = service.findInvoice(1L);
        assertEquals(invoice1, invoice);
    }

    @Test
    public void shouldFindAllInvoices() {
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

        List expectedList = new ArrayList<>();
        expectedList.add(invoice1);
        expectedList.add(invoice2);

        List<Invoice> fromService = service.findAllInvoice();

        assertEquals(expectedList, fromService);

//        List<Invoice> fromService = service.findAllInvoice();
//
//        assertEquals(1, fromService.size());
    }

//    @Test
//    public void shouldUpdateInvoice() {
//        Invoice invoice = new Invoice();
//        invoice.setInvoice_id((1L));
//        invoice.setName("Mary");
//        invoice.setStreet("123 Oak Avenue");
//        invoice.setCity("San Diego");
//        invoice.setState("CA");
//        invoice.setZipcode("92129");
//        invoice.setItemType("game");
//        invoice.setItemId(1L);
//        invoice.setUnit_price(BigDecimal.valueOf(35.99));
//        invoice.setQuantity(1);
//        invoice.setSubtotal(BigDecimal.valueOf(35.99));
//        invoice.setTax(BigDecimal.valueOf(1.06));
//        invoice.setProcessing_fee(BigDecimal.valueOf(1.98));
//        invoice.setTotal(BigDecimal.valueOf(40.12));
//
//        invoice.setName("John");
//        invoice.setStreet("321 Main Street");
//        invoice.setCity("Honolulu");
//        invoice.setState("Hawaii");
//        invoice.setZipcode("96795");
//        invoice.setItemType("console");
//        invoice.setItemId(2L);
//        invoice.setUnit_price(BigDecimal.valueOf(550.99));
//        invoice.setQuantity(1);
//        invoice.setSubtotal(BigDecimal.valueOf(550.99));
//        invoice.setTax(BigDecimal.valueOf(1.05));
//        invoice.setProcessing_fee(BigDecimal.valueOf(14.99));
//        invoice.setTotal(BigDecimal.valueOf(593.52));
//
//        Invoice expectedInvoice = new Invoice();
//        expectedInvoice.setInvoice_id((1L));
//        expectedInvoice.setName("John");
//        expectedInvoice.setStreet("321 Main Street");
//        expectedInvoice.setCity("Honolulu");
//        expectedInvoice.setState("Hawaii");
//        expectedInvoice.setZipcode("96795");
//        expectedInvoice.setItemType("console");
//        expectedInvoice.setItemId(2L);
//        expectedInvoice.setUnit_price(BigDecimal.valueOf(550.99));
//        expectedInvoice.setQuantity(1);
//        expectedInvoice.setSubtotal(BigDecimal.valueOf(550.99));
//        expectedInvoice.setTax(BigDecimal.valueOf(1.05));
//        expectedInvoice.setProcessing_fee(BigDecimal.valueOf(14.99));
//        expectedInvoice.setTotal(BigDecimal.valueOf(593.52));
//
//        service.updateInvoice(invoice);
//
//        Invoice actualResult = service.findInvoice(1L);
//
//        assertEquals(expectedInvoice, actualResult);
//    }

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
    public void shouldFindProcessingFee() {
        ProcessingFee processingFee1 = new ProcessingFee();
        processingFee1.setProduct_type("game");
        processingFee1.setFee(BigDecimal.valueOf(1.49));

        ProcessingFee processingFee = service.findProcessingFee("game");
        assertEquals(processingFee1, processingFee);

//        processingFee fromService = service.findProcessingFee();
//
//        assertEquals(1, fromService.size());
    }

    @Test
    public void shouldFindAllProcessingFee() {
        ProcessingFee processingFee1 = new ProcessingFee();
        processingFee1.setProduct_type("game");
        processingFee1.setFee(BigDecimal.valueOf(1.49));

        ProcessingFee processingFee2 = new ProcessingFee();
        processingFee2.setProduct_type("console");
        processingFee2.setFee(BigDecimal.valueOf(14.99));

        List expectedList = new ArrayList<>();
        expectedList.add(processingFee1);
        expectedList.add(processingFee2);

        List<ProcessingFee> fromService = service.findAllProcessingFee();

        assertEquals(expectedList, fromService);

//        List<ProcessingFee> fromService = service.findAllProcessingFee();
//
//        assertEquals(1, fromService.size());
    }

//    @Test
//    public void shouldUpdateProcessingFee() {
//        ProcessingFee processingFee = new ProcessingFee();
//        processingFee.setProduct_type("game");
//        processingFee.setFee(BigDecimal.valueOf(1.49));
//        processingFeeRepository.save(processingFee);
//
//        processingFee.setProduct_type("console");
//        processingFee.setFee(BigDecimal.valueOf(14.99));
//        processingFeeRepository.save(processingFee);
//
//        ProcessingFee expectedProcessingFee = new ProcessingFee();
//        processingFee.setProduct_type("console");
//        processingFee.setFee(BigDecimal.valueOf(14.99));
//
//        ProcessingFee actualResult = service.saveProcessingFee(processingFee);
//
//        assertEquals(expectedProcessingFee, actualResult);
//
////        Optional<ProcessingFee> processingFee = processingFeeRepository.findById("HI");
////        assertEquals(processingFee1.get(), processingFee);
//    }

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
    public void shouldFindSalesTax() {
        SalesTax salesTax1 = new SalesTax();
        salesTax1.setState("HI");
        salesTax1.setRate(BigDecimal.valueOf(.05));

        SalesTax salesTax = service.findSalesTax("HI");
        assertEquals(salesTax1, salesTax);

//        salesTax fromService = service.findSalesTax();
//
//        assertEquals(1, fromService.size());
    }

    @Test
    public void shouldFindAllSalesTax() {

        SalesTax salesTax1 = new SalesTax();
        salesTax1.setState("CA");
        salesTax1.setRate(BigDecimal.valueOf(.06));

        SalesTax salesTax2 = new SalesTax();
        salesTax2.setState("HI");
        salesTax2.setRate(BigDecimal.valueOf(.05));

        List expectedList = new ArrayList<>();
        expectedList.add(salesTax1);
        expectedList.add(salesTax2);

        List<SalesTax> fromService = service.findAllSalesTax();

        assertEquals(expectedList, fromService);

//        List<SalesTax> fromService = service.findAllSalesTax();
//
//        assertEquals(1, fromService.size());
    }

//    @Test
//    public void shouldUpdateSalesTax() {
//        SalesTax salesTax = new SalesTax();
//        salesTax.setState("CA");
//        salesTax.setRate(BigDecimal.valueOf(.06));
//        salesTaxRepository.save(salesTax);
//
//        salesTax.setState("HI");
//        salesTax.setRate(BigDecimal.valueOf(.05));
//        salesTaxRepository.save(salesTax);
//
//        Optional<SalesTax> salesTax1 = salesTaxRepository.findById("HI");
//        assertEquals(salesTax1.get(), salesTax);
//    }

}