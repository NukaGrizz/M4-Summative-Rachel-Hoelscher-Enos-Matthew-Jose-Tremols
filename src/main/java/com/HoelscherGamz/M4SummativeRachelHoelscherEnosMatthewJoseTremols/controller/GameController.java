package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.controller;

import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model.Game;
import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.repository.GameRepository;
import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    ServiceLayer serviceLayer;

    //Get all game
    @GetMapping
    public List<Game> getAllGames(@RequestParam(required = false) String studio,@RequestParam(required = false) String esrbRating, @RequestParam(required = false) String title){
        return serviceLayer.findAllGame(studio, esrbRating, title);
    }

    //Get game by id
    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Game getGameById(@PathVariable long id)throws Exception {
        Game game = serviceLayer.findGame(id);
        return game;
    }

    //Create game
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Game createGame(@RequestBody @Valid Game game){
        Game returnGame = serviceLayer.saveGame(game);
        return returnGame;
    }

    //Update game
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGame(@RequestBody Game game, @PathVariable long id) {
        if (game.getGame_id() == null) {
            game.setGame_id(id);
        }

        if (game.getGame_id() != id) {
            throw new IllegalArgumentException("Game ID must match parameter given");
        }
        serviceLayer.updateGame(game);
    }

    //Delete game by id
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable long id) {
        serviceLayer.removeGame(id);
    }
}
