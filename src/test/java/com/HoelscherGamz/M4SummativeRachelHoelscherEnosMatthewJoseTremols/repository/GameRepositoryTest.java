package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.repository;

import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model.Console;
import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model.Game;
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
public class GameRepositoryTest {

    @Autowired
    GameRepository gameRepository;
    ConsoleRepository consoleRepository;

    @org.junit.Before
    public void setUp() throws Exception {
        gameRepository.deleteAll();
    }

    @Test
    public void addGetDeleteGame() {
        Game game = new Game();
        game.setGame_id(1L);
        game.setTitle("Breath of the Wild");
        game.setEsrb_rating("E10+");
        game.setDescription("The player controls an amnesiac Link, who awakens from a hundred-year slumber, and attempts to regain his memories and prevent the destruction of Hyrule by Calamity Ganon.");
        game.setStudio("Nintendo");
        game.setPrice(BigDecimal.valueOf(40.99));
        game.setQuantity(150);

        game = gameRepository.save(game);

        Optional<Game> game1 = gameRepository.findById(game.getGame_id(1L));

        assertEquals(game1.get(), game);

        gameRepository.deleteById(game.getGame_id(1L));

        game1 = gameRepository.findById(game.getGame_id(1L));

        assertFalse(game1.isPresent());

    }

    @Test
    public void updateGame() {
        Game game = new Game();
        game.getGame_id(1L);
        game.setTitle("Breath of the Wild");
        game.setEsrb_rating("E10+");
        game.setDescription("The player controls an amnesiac Link, who awakens from a hundred-year slumber, and attempts to regain his memories and prevent the destruction of Hyrule by Calamity Ganon.");
        game.setStudio("Nintendo");
        game.setPrice(BigDecimal.valueOf(40.99));
        game.setQuantity(150);
        gameRepository.save(game);

        game.setTitle("Resident Evil Village");
        game.setEsrb_rating("M17+");
        game.setDescription("Players control Ethan Winters, who searches for his kidnapped daughter in a village filled with mutant creatures. ");
        game.setStudio("Capcom");
        game.setPrice(BigDecimal.valueOf(35.99));
        game.setQuantity(150);
        gameRepository.save(game);

        Optional<Game> game1 = gameRepository.findById(game.getGame_id(1L));
        assertEquals(game1.get(), game);

    }

    @Test
    public void getAllConsoles() {

        Console console = new Console();
        console.setConsole_id(1L);
        console.setModel("PS5");
        console.setManufacturer("Sony");
        console.setMemory_amount("825 GB");
        console.setProcessor("AMD Zen 2 CPU");
        console.setPrice(BigDecimal.valueOf(499.99));
        console.setQuantity(100);

        console = consoleRepository.save(console);

        console = new Console();
        console.setModel("XBox Series X");
        console.setManufacturer("Microsoft");
        console.setMemory_amount("1TB");
        console.setProcessor("AMD Zen 2 CPU");
        console.setPrice(BigDecimal.valueOf(550.99));
        console.setQuantity(200);

        console = consoleRepository.save(console);

        List<Console> aList = consoleRepository.findAll();
        assertEquals(aList.size(), 2);

    }
}