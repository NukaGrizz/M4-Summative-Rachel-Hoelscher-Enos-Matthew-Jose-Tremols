package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.service;

import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model.*;

import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.NoTransactionException;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ServiceLayer {

    private ConsoleRepository consoleRepository;

    private GameRepository gameRepository;
    private InvoiceRepository invoiceRepository;
    private ProcessingFeeRepository processingFeeRepository;
    private SalesTaxRepository salesTaxRepository;
    private TShirtRepository tShirtRepository;

    @Autowired
    public ServiceLayer(ConsoleRepository consoleRepository, GameRepository gameRepository, InvoiceRepository invoiceRepository, ProcessingFeeRepository processingFeeRepository, SalesTaxRepository salesTaxRepository, TShirtRepository tShirtRepository) {
        this.consoleRepository = consoleRepository;
        this.gameRepository = gameRepository;
        this.tShirtRepository = tShirtRepository;
        this.invoiceRepository = invoiceRepository;
        this.processingFeeRepository = processingFeeRepository;
        this.salesTaxRepository = salesTaxRepository;
    }

    //
    //CRUD OPERATIONS FOR CONSOLE
    //

    //Create new Console
    @Transactional
    public Console saveConsole(Console console) throws Exception{

        // Persist console
        Console c = new Console();
        c.setModel(console.getModel());
        c.setManufacturer(console.getManufacturer());
        c.setMemory_amount(console.getMemory_amount());
        c.setProcessor(console.getProcessor());
        c.setPrice(console.getPrice());
        c.setQuantity(console.getQuantity());
        c = consoleRepository.save(c);
        console.setConsole_id(c.getConsole_id());
        return console;
    }

    //Find Console By Id
    public Console findConsole(Long id) throws Exception{

        // Get the console object first
        Optional<Console> console = consoleRepository.findById(id);

        return console.isPresent() ? console.get() : null;
    }

    // find All consoles
    public List<Console> findAllConsole(String manufacturer) throws Exception{

        List<Console> consoleList = consoleRepository.findAll();

        if (manufacturer != null) {
            consoleList = consoleRepository.findAll().stream()
                    .filter(r -> r.getManufacturer().contains(manufacturer))
                    .collect(Collectors.toList());
        }

//        if (manufacturer != null) {
//            return consoleRepository.findByManufacturer(manufacturer);
//        } else {
        return consoleList;
    }
//    }

    //Find Console By Manufacturer (called above)
    //    public List<Console> findByManufacturer(String manufacturer) {
    //        return consoleRepository.findByManufacturer(manufacturer);
    //    }

    //Update console
    @Transactional
    public void updateConsole(Console console) throws Exception{

        // Update the console information
        Console c = new Console();
        c.setConsole_id(console.getConsole_id());
        c.setModel(console.getModel());
        c.setManufacturer(console.getManufacturer());
        c.setMemory_amount(console.getMemory_amount());
        c.setProcessor(console.getProcessor());
        c.setPrice(console.getPrice());
        c.setQuantity(console.getQuantity());
        consoleRepository.save(c);
    }

    //Delete the Console
    @Transactional
    public void removeConsole(Long id) throws Exception{
        // Remove Console
        consoleRepository.deleteById(id);
    }


    //
    //CRUD OPERATIONS FOR GAME
    //

    //Create new game
    @Transactional
    public Game saveGame(Game game) throws Exception{

        // Persist console
        Game g = new Game();
        g.setTitle(game.getTitle());
        g.setEsrbRating(game.getEsrbRating());
        g.setDescription(game.getDescription());
        g.setPrice(game.getPrice());
        g.setStudio(game.getStudio());
        g.setQuantity(game.getQuantity());
        g = gameRepository.save(g);
        game.setGame_id(g.getGame_id());
        return game;
    }

    //Get game by id
    public Game findGame(Long id) throws Exception{

        // Get the game object first
        Optional<Game> game = gameRepository.findById(id);

        return game.isPresent() ? game.get() : null;
    }

    //Get all games
    public List<Game> findAllGame(String studio, String esrbRating, String title) throws Exception{

        List<Game> gameList = gameRepository.findAll();

        if (studio != null) {
            gameList = gameList.stream()
                    .filter(r -> r.getStudio().contains(studio))
                    .collect(Collectors.toList());
        }

        if (esrbRating != null) {
            gameList = gameList.stream()
                    .filter(r -> r.getEsrbRating().contains(esrbRating))
                    .collect(Collectors.toList());
        }

        if (title != null) {
            gameList = gameList.stream()
                    .filter(r -> r.getTitle().contains(title))
                    .collect(Collectors.toList());
        }
            return gameList;
        }


        // Update game information
        @Transactional
        public void updateGame (Game game)throws Exception{
            Game g = new Game();
            g.setGame_id(game.getGame_id());
            g.setTitle(game.getTitle());
            g.setEsrbRating(game.getEsrbRating());
            g.setDescription(game.getDescription());
            g.setPrice(game.getPrice());
            g.setStudio(game.getStudio());
            g.setQuantity(game.getQuantity());
            gameRepository.save(g);
        }

        // Delete Game
        @Transactional
        public void removeGame (Long id) throws Exception{
            gameRepository.deleteById(id);
        }

        //Search for games by studio
        public List<Game> findByStudio (String studio) throws Exception{
            return gameRepository.findAllGamesByStudio(studio);
        }

        //Search for games by ESBR_Rating
        public List<Game> findByRating (String rating) throws Exception {
            return gameRepository.findAllGamesByEsrbRating(rating);
        }

        //Search for games by Title
        public List<Game> findByTitle (String title)throws Exception {
            return gameRepository.findAllGamesByTitle(title);
        }


        //
        //CRUD OPERATIONS FOR TShirt
        //

        //Create new TShirt
        @Transactional
        public TShirt saveTShirt (TShirt tshirt)throws Exception{

            // Persist console
            TShirt t = new TShirt();
            t.setColor(tshirt.getColor());
            t.setDescription(tshirt.getDescription());
            t.setPrice(tshirt.getPrice());
            t.setSize(tshirt.getSize());
            t.setQuantity(tshirt.getQuantity());
            t = tShirtRepository.save(t);
            tshirt.setT_shirt_id(t.getT_shirt_id());
            return tshirt;
        }

        //Get TShirt by id
        public TShirt findTShirt (Long id)throws Exception{

            Optional<TShirt> tShirt = tShirtRepository.findById(id);

            return tShirt.isPresent() ? tShirt.get() : null;
        }

        //Get all TShirts
        public List<TShirt> findAllTShirt (String color, String size)throws Exception {

            List<TShirt> tShirtList = tShirtRepository.findAll();

            if (color != null) {
                tShirtList = tShirtList.stream()
                        .filter(r -> r.getColor().contains(color))
                        .collect(Collectors.toList());
            }

            if (size != null) {
                tShirtList = tShirtList.stream()
                        .filter(r -> r.getSize().contains(size))
                        .collect(Collectors.toList());
            }



            return tShirtList;
        }

        // Update TShirt information
        @Transactional
        public void updateTShirt (TShirt tShirt)throws Exception{
            TShirt t = new TShirt();
            t.setT_shirt_id(tShirt.getT_shirt_id());
            t.setColor(tShirt.getColor());
            t.setDescription(tShirt.getDescription());
            t.setPrice(tShirt.getPrice());
            t.setSize(tShirt.getSize());
            t.setQuantity(tShirt.getQuantity());
            tShirtRepository.save(t);
        }

        // Delete TShirt
        @Transactional
        public void removeTShirt (Long id)throws Exception{
            tShirtRepository.deleteById(id);
        }

        //Search for T-shirts by color.
        public List<TShirt> findByColor (String color)throws Exception{
            return tShirtRepository.findByColor(color);
        }

        //Search for T-shirts by size.
        public List<TShirt> findBySize (String size)throws Exception{
            return tShirtRepository.findBySize(size);
        }


        //
        //CRUD OPERATIONS FOR INVOICE
        //

        //Create New Invoice
        @Transactional
        public Invoice saveInvoice (Invoice invoice) throws Exception {

             //Persist invoice - the following 8 fields are required to create invoice!!
            Invoice i = new Invoice();
            i.setName(invoice.getName());
            i.setStreet(invoice.getStreet());
            i.setCity(invoice.getCity());
            i.setState(invoice.getState());
            i.setZipcode(invoice.getZipcode());
            i.setItemType(invoice.getItemType());
            i.setItemId(invoice.getItemId());
            i.setQuantity(invoice.getQuantity());

            if (invoice.getQuantity() == 0) {
                throw new IllegalArgumentException("Invoice Quantity cannot equal 0");
            }

            if (!invoice.getState().equals(findSalesTax(invoice.getState()).getState())) {
                throw new IllegalArgumentException("Invoice State not valid - State value must equal value of a SalesTax state. To see SaleTax states query SaleTax Endpoint to get all entries");
            }

            //ensure enough left for order subtract from model quantity remaining and set price
            if (invoice.getItemType().equals("game")) {

                if (invoice.getQuantity() <= findGame(invoice.getItemId()).getQuantity()) {
                    Game game = findGame(invoice.getItemId());
                    //reduce supply of game item in stock
                    game.setQuantity(game.getQuantity() - invoice.getQuantity());
                    //set price
                    i.setUnit_price(game.getPrice());
                    invoice.setUnit_price(i.getUnit_price());
                } else {
                    //throw Error item supply not sufficient
                    throw new NoTransactionException("There are not enough of the requested Games left in stock to fulfill your order. Currently there are " + findGame(invoice.getItemId()).getQuantity() + " remaining!");
                }
            } else if (invoice.getItemType().equals("console")) {
                if (invoice.getQuantity() <= findConsole(invoice.getItemId()).getQuantity()) {
                    Console console = findConsole(invoice.getItemId());
                    //reduce supply of game item in stock
                    console.setQuantity(console.getQuantity() - invoice.getQuantity());
                    //set price
                    i.setUnit_price(console.getPrice());
                    invoice.setUnit_price(i.getUnit_price());
                } else {
                    //throw Error item supply not sufficient
                    throw new NoTransactionException("There are not enough of the requested Consoles left in stock to fulfill your order. Currently there are " + findConsole(invoice.getItemId()).getQuantity() + " remaining!");
                }

            } else if (invoice.getItemType().equals("tshirt") || invoice.getItemType().equals("tShirt")) {
                if (invoice.getQuantity() <= findTShirt(invoice.getItemId()).getQuantity()) {
                    TShirt tShirt = findTShirt(invoice.getItemId());
                    //reduce supply of game item in stock
                    tShirt.setQuantity(tShirt.getQuantity() - invoice.getQuantity());
                    //set price
                    i.setUnit_price(tShirt.getPrice());
                    invoice.setUnit_price(i.getUnit_price());
                } else {
                    //throw Error item supply not sufficient
                    throw new NoTransactionException("There are not enough of the requested TShirts left in stock to fulfill your order. Currently there are " + findTShirt(invoice.getItemId()).getQuantity() + " remaining!");
                }
            } else {
                //throw errpr no product type found acceptable types include game console tshirt
                throw new IllegalArgumentException("no matching product type found acceptable types include 'game' 'console' 'tshirt' ");
            }

            //calculate subtotal
            i.setSubtotal(invoice.getUnit_price().multiply(BigDecimal.valueOf(invoice.getQuantity())));
            invoice.setSubtotal(i.getSubtotal());

            //calculate Tax
            i.setTax(findSalesTax(invoice.getState()).getRate().multiply(invoice.getSubtotal()));
            i.setTax(i.getTax().setScale(2, RoundingMode.HALF_UP));
            invoice.setTax(i.getTax());

            //get processingfee from findProcessingFee(itemType)
            if (invoice.getQuantity() > 10) {
                i.setProcessing_fee(findProcessingFee(invoice.getItemType()).getFee().add(BigDecimal.valueOf(15.49)));
            } else {
                i.setProcessing_fee(findProcessingFee(invoice.getItemType()).getFee());
            }
            invoice.setProcessing_fee(i.getProcessing_fee());

            //calculate Total
            i.setTotal(invoice.getSubtotal().add(invoice.getTax()).add(invoice.getProcessing_fee()));
            invoice.setTotal(i.getTotal());

            i = invoiceRepository.save(i);
            invoice.setInvoice_id(i.getInvoice_id());
            return invoice;
        }

        //Get Invoice by id
        public Invoice findInvoice (Long id)throws Exception{

            // Get the game object first
            Optional<Invoice> invoice = invoiceRepository.findById(id);

            return invoice.isPresent() ? invoice.get() : null;
        }

        //Get all Invoices
        public List<Invoice> findAllInvoice () throws Exception{

            List<Invoice> invoiceList = invoiceRepository.findAll();

            return invoiceList;
        }

        // Update Invoice information
        @Transactional
        public void updateInvoice (Invoice invoice)throws Exception{
            Invoice i = new Invoice();
            i.setInvoice_id(invoice.getInvoice_id());
            i.setName(invoice.getName());
            i.setStreet(invoice.getStreet());
            i.setCity(invoice.getCity());
            i.setState(invoice.getState());
            i.setZipcode(invoice.getZipcode());
            i.setItemType(invoice.getItemType());
            i.setItemId(invoice.getItemId());
            i.setUnit_price(invoice.getUnit_price());
            i.setQuantity(invoice.getQuantity());
            i.setSubtotal(invoice.getSubtotal());
            i.setTax(invoice.getTax());
            i.setProcessing_fee(invoice.getProcessing_fee());
            i.setTotal(invoice.getTotal());
            invoiceRepository.save(i);
        }

        // Delete Invoice
        @Transactional
        public void removeInvoice (Long id)throws Exception{
            invoiceRepository.deleteById(id);
        }


        //
        //CRUD OPERATIONS FOR PROCESSING FEE
        //

        //Create new processing fee
        @Transactional
        public ProcessingFee saveProcessingFee (ProcessingFee processingFee)throws Exception{

            // Persist processingFee
            ProcessingFee p = new ProcessingFee();
            p.setProduct_type(processingFee.getProduct_type());
            p.setFee(processingFee.getFee());
            processingFeeRepository.save(p);
            return processingFee;
        }

        //Get ProcessingFee by id->"productType"
        public ProcessingFee findProcessingFee (String productType)throws Exception{

            // Get the game object first
            Optional<ProcessingFee> processingFee = processingFeeRepository.findById(productType);

            return processingFee.isPresent() ? processingFee.get() : null;
        }

        //Get all processingFees
        public List<ProcessingFee> findAllProcessingFee () {

            List<ProcessingFee> processingFeeList = processingFeeRepository.findAll();

            return processingFeeList;
        }

        // Update ProcessingFee information
        @Transactional
        public void updateProcessingFee (ProcessingFee processingFee)throws Exception{
            ProcessingFee p = new ProcessingFee();
            p.setProduct_type(processingFee.getProduct_type());
            p.setFee(processingFee.getFee());
            processingFeeRepository.save(p);
        }

        // Delete ProcessingFee
        @Transactional
        public void removeProcessingFee (String productType)throws Exception{
            processingFeeRepository.deleteById(productType);
        }


        //
        //CRUD OPERATIONS FOR SALES TAX
        //

        //Create new sales tax
        @Transactional
        public SalesTax saveSalesTax (SalesTax salesTax)throws Exception{

            // Persist sales tax
            SalesTax s = new SalesTax();
            s.setState(salesTax.getState());
            s.setRate(salesTax.getRate());
            salesTaxRepository.save(s);
            return salesTax;
        }

        //Get Sales Tax by id->"State"
        public SalesTax findSalesTax (String state)throws Exception{

            // Get the game object first
            Optional<SalesTax> salesTax = salesTaxRepository.findById(state);

            return salesTax.isPresent() ? salesTax.get() : null;
        }

        //Get all Sales Tax
        public List<SalesTax> findAllSalesTax ()throws Exception {

            List<SalesTax> salesTaxList = salesTaxRepository.findAll();

            return salesTaxList;
        }

        // Update Sales Tax information
        @Transactional
        public void updateSalesTax (SalesTax salesTax)throws Exception{
            SalesTax s = new SalesTax();
            s.setState(salesTax.getState());
            s.setRate(salesTax.getRate());
            salesTaxRepository.save(s);
        }

        // Delete ProcessingFee
        @Transactional
        public void removeSalesTax (String State)throws Exception{
            salesTaxRepository.deleteById(State);
        }


    }
