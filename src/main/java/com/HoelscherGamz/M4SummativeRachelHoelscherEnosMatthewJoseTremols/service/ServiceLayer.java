package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.service;

import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model.Console;
import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model.Game;
import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model.TShirts;
import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
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

    //CRUD OPERATIONS FOR CONSOLE
    @Transactional
    public Console saveConsole(Console console) {

        // Persist console
        Console c = new Console();
        c.setModel(console.getModel());
        c.setManufacturer(console.getManufacturer());
        c.setMemoryAmount(console.getMemoryAmount());
        c.setProcessor(console.getProcessor());
        c.setPrice(console.getPrice());
        c.setQuantity(console.getQuantity());
        consoleRepository.save(c);
        console.setId(c.getId());
        return  console;
    }

    public Console findConsole(Long id) {

        // Get the album object first
        Optional<Console> console = consoleRepository.findById(id);

        return console.isPresent() ? console.get() : null;
    }

    public List<Console> findAllConsole() {

        List<Console> consoleList = consoleRepository.findAll();

        return consoleList;
    }

    public List<Console> findByManufacturer(String manufacturer){
        return consoleRepository.findByManufacturer(manufacturer);
    }


    @Transactional
    public void updateConsole(Console console) {

        // Update the console information
        Console c = new Console();
        c.setModel(console.getModel());
        c.setManufacturer(console.getManufacturer());
        c.setMemoryAmount(console.getMemoryAmount());
        c.setProcessor(console.getProcessor());
        c.setPrice(console.getPrice());
        c.setQuantity(console.getQuantity());
        consoleRepository.save(c);
    }

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
        g.setEsrb_rating(game.getEsrb_rating());
        g.setDescription(game.getDescription());
        g.setPrice(game.getPrice());
        g.setStudio(game.getStudio());
        g.setQuantity(game.getQuantity());
        gameRepository.save(g);
        game.setGameId(g.getGameId());
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
        g.setTitle(game.getTitle());
        g.setEsrb_rating(game.getEsrb_rating());
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
        return gameRepository.findAllGamesByRating(rating);
    }

    //Search for games by Title
    public List<Game> findByTitle(String title){
        return gameRepository.findAllGamesByTitle(title);
    }



    //
    //CRUD OPERATIONS FOR TSHIRT
    //

    //Search for T-shirts by color.
    public List<TShirts> findByColor(String color){
        return tShirtRepository.findByColor(color);
    }

    //Search for T-shirts by size.
    public List<TShirts> findBySize(String size){
        return tShirtRepository.findBySize(size);
    }



    //
    //CRUD OPERATIONS FOR INVOICE
    //


    //
    //CRUD OPERATIONS FOR PROCESSING FEE
    //


    //
    //CRUD OPERATIONS FOR SALES TAX
    //


}
