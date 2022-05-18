package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.repository;

import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model.Game;
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
public class GameRepoTests {
    @Autowired
    GameRepository repo;

    @Before
    public void setUp() throws Exception {
        repo.deleteAll();
    }

    @Test
    public void shouldAddGetDeleteGame() {
        Game game1 = repo.save(new Game(1L, "Breath of the Wild", "E10+", "The player controls an amnesiac Link, who awakens from a hundred-year slumber, and attempts to regain his memories and prevent the destruction of Hyrule by Calamity Ganon.", new BigDecimal("40.99"), "Nintendo", 150));
        assertEquals(true, repo.existsById(game1.getGame_id()));
        repo.deleteById(game1.getGame_id());
        assertEquals(false, repo.existsById(game1.getGame_id()));
    }

    @Test
    public void shouldGetAllGames() {
        Game game1 = repo.save(new Game(1L, "Breath of the Wild", "E10+", "The player controls an amnesiac Link, who awakens from a hundred-year slumber, and attempts to regain his memories and prevent the destruction of Hyrule by Calamity Ganon.", new BigDecimal("40.99"), "Nintendo", 150));
        Game game2 = repo.save(new Game(1L, "Resident Evil Village", "M17+", " Players control Ethan Winters, who searches for his kidnapped daughter in a village filled with mutant creatures.", new BigDecimal("35.99"), "Capcom", 150));


        List<Game> games = repo.findAll();
        assertEquals(2, games.size());
    }

    @Test
    public void shouldUpdateGame() {
        String newTitle = "Horizon Zero Dawn I";

        Game newGame = repo.save(new Game(3L, "Horizon Zero Dawn", "T", "The plot follows Aloy, a young huntress in a world overrun by machines, who sets out to uncover her past. ", new BigDecimal("35.55"), "Guerrilla Games", 200));
        newGame.setTitle(newTitle);
        Game updatedGame = repo.save(newGame);
        assertEquals(newTitle, updatedGame.getTitle());
    }

    @Test
    public void shouldFindByTitle() {
        //
    }

    @Test
    public void shouldFindByRating() {
        //
    }

    @Test
    public void shouldFindByStudio() {
        //
    }

}