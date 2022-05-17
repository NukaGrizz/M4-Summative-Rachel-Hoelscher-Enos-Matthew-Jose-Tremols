package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.controller;

import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model.Game;
import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/game")
public class GameController {
    @Autowired
    GameRepository gameRepository;

    //Get all game
    @GetMapping(value = "/{id}")
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    //Get game by id
    @GetMapping(value = "/{id}")
    public Game getGameById(@PathVariable long id) {
        Optional<Game> game = gameRepository.findById(id);

        if (!game.isPresent()) {
            return null;
        }

        return game.get();
    }

    //Create game
    @PostMapping
    public Game createGame(@RequestBody Game game) {
        gameRepository.save(game);
        return game;
    }

    //Update game
    @PutMapping(value = "/{id}")
    public void updateGame(@RequestBody Game game, @PathVariable long id) {
        if(game.getGameId() == null) {
            game.setGameId(id);
        }

        if(game.getGameId() != id) {
            throw new IllegalArgumentException("Game ID must match parameter given");
        }
        gameRepository.save(game);
    }

    //Delete game by id
    @DeleteMapping(value = "/{id}")
    public void deleteGame(@PathVariable long id) {
        gameRepository.deleteById(id);
    }
}
