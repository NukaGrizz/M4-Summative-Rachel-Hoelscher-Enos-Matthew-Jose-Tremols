package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.repository;


import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model.Game;
import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface GameRespository extends JpaRepository<Game, Long> {

    List<Invoice> findAllGamesByTitle(String title);
    List<Invoice> findAllGamesByRating(String esrb_rating);
    List<Invoice> findAllGamesByDescription(String description);
    List<Invoice> findAllGamesByPrice(BigDecimal price);
    List<Invoice> findAllGamesByStudio(String studio);
}
