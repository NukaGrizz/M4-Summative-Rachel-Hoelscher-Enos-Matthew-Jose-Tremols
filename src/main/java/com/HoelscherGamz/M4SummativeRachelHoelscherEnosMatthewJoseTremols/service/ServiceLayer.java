package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.service;

import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model.*;

import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.NoTransactionException;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component
public class ServiceLayer {

    private ConsoleRepository consoleRepository;

    private GameRepository gameRepository;
    private InvoiceRepository invoiceRepository;
    private ProcessingFeeRepository processingFeeRepository;
    private SalesTaxRepository salesTaxRepository;
    private TShirtRepository tShirtRepository;

    @Autowired
    public ServiceLayer(ConsoleRepository consoleRepository, GameRepository gameRepository, InvoiceRepository invoiceRepository, ProcessingFeeRepository processingFeeRepository, SalesTaxRepository salesTaxRepository, TShirtRepository tShirtRepository){
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
    public Console saveConsole(Console console) {

        // Persist console
        Console c = new Console();
        c.setModel(console.getModel());
        c.setManufacturer(console.getManufacturer());
        c.setMemory_amount(console.getMemory_amount());
        c.setProcessor(console.getProcessor());
        c.setPrice(console.getPrice());
        c.setQuantity(console.getQuantity());
        consoleRepository.save(c);
        console.setConsole_id(c.getConsole_id());
        return  console;
    }

    //Find Console By Id
    public Console findConsole(Long id) {

        // Get the console object first
        Optional<Console> console = consoleRepository.findById(id);

        return console.isPresent() ? console.get() : null;
    }

    // find All consoles
    public List<Console> findAllConsole() {

        List<Console> consoleList = consoleRepository.findAll();

        return consoleList;
    }

    //Find Console By Manufacturer
    public List<Console> findByManufacturer(String manufacturer){
        return consoleRepository.findByManufacturer(manufacturer);
    }

    //Update console
    @Transactional
    public void updateConsole(Console console) {

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

    //Detele the Console
    @Transactional
    public void removeConsole(Long id) {
        // Remove Console
        consoleRepository.deleteById(id);
    }


    //
    //CRUD OPERATIONS FOR GAME
    //

    //Create new game
    @Transactional
    public Game saveGame(Game game) {

        // Persist console
        Game g = new Game();
        g.setTitle(game.getTitle());
        g.setEsrbRating(game.getEsrbRating());
        g.setDescription(game.getDescription());
        g.setPrice(game.getPrice());
        g.setStudio(game.getStudio());
        g.setQuantity(game.getQuantity());
        gameRepository.save(g);
        game.setGame_id(g.getGame_id(1L));
        return game;
    }

    //Get game by id
    public Game findGame(Long id) {

        // Get the game object first
        Optional<Game> game = gameRepository.findById(id);

        return game.isPresent() ? game.get() : null;
    }

    //Get all games
    public List<Game> findAllGame() {

        List<Game> gameList = gameRepository.findAll();

        return gameList;
    }

    // Update game information
    @Transactional
    public void updateGame(Game game) {
        Game g = new Game();
        g.setGame_id(game.getGame_id(1L));
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
    public void removeGame(Long id) {
        gameRepository.deleteById(id);
    }

    //Search for games by studio
    public List<Game> findByStudio(String studio){
        return gameRepository.findAllGamesByStudio(studio);
    }

    //Search for games by ESBR_Rating
    public List<Game> findByRating(String rating){
        return gameRepository.findAllGamesByEsrbRating(rating);
    }

    //Search for games by Title
    public List<Game> findByTitle(String title){
        return gameRepository.findAllGamesByTitle(title);
    }



    //
    //CRUD OPERATIONS FOR TShirt
    //

    //Create new TShirt
    @Transactional
    public TShirt saveTShirt(TShirt tshirt) {

        // Persist console
        TShirt t = new TShirt();
        t.setColor(tshirt.getColor());
        t.setDescription(tshirt.getDescription());
        t.setPrice(tshirt.getPrice());
        t.setSize(tshirt.getSize());
        t.setQuantity(tshirt.getQuantity());
        tShirtRepository.save(t);
        tshirt.setT_shirt_id(t.getT_shirt_id());
        return tshirt;
    }

    //Get TShirt by id
    public TShirt findTShirt(Long id) {

        Optional<TShirt> tShirt = tShirtRepository.findById(id);

        return tShirt.isPresent() ? tShirt.get() : null;
    }

    //Get all TShirts
    public List<TShirt> findAllTShirt() {

        List<TShirt> tShirtList = tShirtRepository.findAll();

        return tShirtList;
    }

    // Update TShirt information
    @Transactional
    public void updateTShirt(TShirt tShirt) {
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
    public void removeTShirt(Long id) {
        tShirtRepository.deleteById(id);
    }

    //Search for T-shirts by color.
    public List<TShirt> findByColor(String color){
        return tShirtRepository.findByColor(color);
    }

    //Search for T-shirts by size.
    public List<TShirt> findBySize(String size){
        return tShirtRepository.findBySize(size);
    }


    //
    //CRUD OPERATIONS FOR INVOICE
    //

    //Create New Invoice
    @Transactional
    public Invoice saveInvoice(Invoice invoice) {

        // Persist invoice - the following 8 fields are required to create invoice!!
        Invoice i = new Invoice();
        i.setName(invoice.getName());
        i.setStreet(invoice.getStreet());
        i.setCity(invoice.getCity());
        i.setState(invoice.getState());
        i.setZipcode(invoice.getZipcode());
        i.setItemType(invoice.getItemType());
        i.setItemId(invoice.getItemId());
        i.setQuantity(invoice.getQuantity());

        //ensure enough left for order subtract from model quantity remaining and set price
        if (invoice.getItemType().equals("game")) {

            if(invoice.getQuantity() <= findGame(invoice.getItemId()).getQuantity()){
                Game game = findGame(invoice.getItemId());
                //reduce supply of game item in stock
                game.setQuantity(game.getQuantity() - invoice.getQuantity());
                //set price
                i.setUnit_price(game.getPrice());
            } else {
                //throw Error item supply not sufficient
                throw new NoTransactionException("There are not enough of the requested Games left in stock to fulfill your order. Currently there are " + findGame(invoice.getItemId()).getQuantity() + " remaining!" );
            }
        }  else if(invoice.getItemType().equals("console")) {
            if(invoice.getQuantity() <= findConsole(invoice.getItemId()).getQuantity()){
                Console console = findConsole(invoice.getItemId());
                //reduce supply of game item in stock
                console.setQuantity(console.getQuantity() - invoice.getQuantity());
                //set price
                i.setUnit_price(console.getPrice());
            } else {
                //throw Error item supply not sufficient
                throw new NoTransactionException("There are not enough of the requested Consoles left in stock to fulfill your order. Currently there are " + findConsole(invoice.getItemId()).getQuantity() + " remaining!" );
            }

        } else if(invoice.getItemType().equals("tshirt") || invoice.getItemType().equals("tShirt")) {
            if(invoice.getQuantity() <= findTShirt(invoice.getItemId()).getQuantity()){
                TShirt tShirt = findTShirt(invoice.getItemId());
                //reduce supply of game item in stock
                tShirt.setQuantity(tShirt.getQuantity() - invoice.getQuantity());
                //set price
                i.setUnit_price(tShirt.getPrice());
            } else {
                //throw Error item supply not sufficient
                throw new NoTransactionException("There are not enough of the requested TShirts left in stock to fulfill your order. Currently there are " + findTShirt(invoice.getItemId()).getQuantity() + " remaining!" );
            }
        } else {
            //throw errpr no product type found acceptable types include game console tshirt
            throw new IllegalArgumentException("no matching product type found acceptable types include 'game' 'console' 'tshirt' ");
        };

        //calculate subtotal
        i.setSubtotal(invoice.getUnit_price().multiply(BigDecimal.valueOf(invoice.getQuantity())));
        invoice.setSubtotal(i.getSubtotal());

        //calculate Tax
        i.setTax(findSalesTaxRate(invoice.getState()).getRate().multiply(invoice.getSubtotal()));
        invoice.setTax(i.getTax());

        //get processingfee from findProcessingFee(itemType)
        if (invoice.getQuantity()>10){
            i.setProcessing_fee(findProcessingFee(invoice.getItemType()).getFee().add(BigDecimal.valueOf(15.49)));
        } else {
            i.setProcessing_fee(findProcessingFee(invoice.getItemType()).getFee());
        }
        invoice.setProcessing_fee(i.getProcessing_fee());

        //calculate Total
        i.setTotal(invoice.getSubtotal().add(invoice.getTax()).add(invoice.getProcessing_fee()));
        invoice.setTotal(i.getTotal());

        invoiceRepository.save(i);
        invoice.setInvoice_id(i.getInvoice_id());
        return invoice;
    }

    //Get Invoice by id
    public Invoice findInovice(Long id) {

        // Get the game object first
        Optional<Invoice> invoice = invoiceRepository.findById(id);

        return invoice.isPresent() ? invoice.get() : null;
    }

    //Get all Invoices
    public List<Invoice> findAllInvoice() {

        List<Invoice> invoiceList = invoiceRepository.findAll();

        return invoiceList;
    }

    // Update Invoice information
    @Transactional
    public void updateInvoice(Invoice invoice) {
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
    public void removeInvoice(Long id) {
        invoiceRepository.deleteById(id);
    }


    //
    //CRUD OPERATIONS FOR PROCESSING FEE
    //

    //Create new processing fee
    @Transactional
    public ProcessingFee saveProcessingFee(ProcessingFee processingFee) {

        // Persist processingFee
        ProcessingFee p = new ProcessingFee();
        p.setProduct_type(processingFee.getProduct_type());
        p.setFee(processingFee.getFee());
        processingFeeRepository.save(p);
        return processingFee;
    }

    //Get ProcessingFee by id->"productType"
    public ProcessingFee findProcessingFee(String productType) {

        // Get the game object first
        Optional<ProcessingFee> processingFee = processingFeeRepository.findById(productType);

        return processingFee.isPresent() ? processingFee.get() : null;
    }

    //Get all processingFees
    public List<ProcessingFee> findAllProcessingFee() {

        List<ProcessingFee> processingFeeList = processingFeeRepository.findAll();

        return processingFeeList;
    }

    // Update ProcessingFee information
    @Transactional
    public void updateProcessingFee(ProcessingFee processingFee) {
        ProcessingFee p = new ProcessingFee();
        p.setProduct_type(processingFee.getProduct_type());
        p.setFee(processingFee.getFee());
        processingFeeRepository.save(p);
    }

    // Delete ProcessingFee
    @Transactional
    public void removeProcessingFee(String productType) {
        processingFeeRepository.deleteById(productType);
    }


    //
    //CRUD OPERATIONS FOR SALES TAX
    //

    //Create new sales tax
    @Transactional
    public SalesTax saveSalesTax(SalesTax salesTax) {

        // Persist sales tax
        SalesTax s = new SalesTax();
        s.setState(salesTax.getState());
        s.setRate(salesTax.getRate());
        salesTaxRepository.save(s);
        return salesTax;
    }

    //Get Sales Tax by id->"State"
    public SalesTax findSalesTaxRate(String state) {

        // Get the game object first
        Optional<SalesTax> salesTax = salesTaxRepository.findById(state);

        return salesTax.isPresent() ? salesTax.get() : null;
    }

    //Get all Sales Tax
    public List<SalesTax> findAllSalesTax() {

        List<SalesTax> salesTaxList = salesTaxRepository.findAll();

        return salesTaxList;
    }

    // Update Sales Tax information
    @Transactional
    public void updateSalesTaxRate(SalesTax salesTax) {
        SalesTax s = new SalesTax();
        s.setState(salesTax.getState());
        s.setRate(salesTax.getRate());
        salesTaxRepository.save(s);
    }

    // Delete ProcessingFee
    @Transactional
    public void removeSalesTax(String State) {
        salesTaxRepository.deleteById(State);
    }


}
