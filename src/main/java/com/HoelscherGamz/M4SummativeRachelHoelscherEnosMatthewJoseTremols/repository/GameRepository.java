package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.repository;


import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    List<Game> findAllGamesByTitle(String title);
    List<Game> findAllGamesByEsrbRating(String esrbRating);
    List<Game> findAllGamesByDescription(String description);
    List<Game> findAllGamesByPrice(BigDecimal price);
    List<Game> findAllGamesByStudio(String studio);
}
