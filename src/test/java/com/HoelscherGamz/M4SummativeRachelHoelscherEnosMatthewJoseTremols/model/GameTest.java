package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.*;

public class GameTest {

    Game gameTester = new Game(5L,"The Sims","Everyone 10+","A life simulation game",new BigDecimal("30.99"),"EA Games",1);

    @Test
    public void getGameId() {
        assertEquals(Optional.of(5L),Optional.of(gameTester.getGame_id(1L)));
    }

    @Test
    public void setGameId() {
        gameTester.setGame_id(1L);
        assertEquals(Optional.of(1L),Optional.of(gameTester.getGame_id(1L)));
    }

    @Test
    public void getTitle() {
        assertEquals(Optional.of("The Sims"),Optional.of(gameTester.getTitle()));
    }

    @Test
    public void setTitle() {
        gameTester.setTitle("Gears");
        assertEquals(Optional.of("Gears"),Optional.of(gameTester.getTitle()));
    }

    @Test
    public void getEsrb_rating() {
        assertEquals(Optional.of("Everyone 10+"),Optional.of(gameTester.getEsrb_rating()));
    }

    @Test
    public void setEsrb_rating() {
        gameTester.setEsrb_rating("Teen");
        assertEquals(Optional.of("Teen"),Optional.of(gameTester.getEsrb_rating()));
    }

    @Test
    public void getDescription() {
        assertEquals(Optional.of("A life simulation game"),Optional.of(gameTester.getDescription()));
    }

    @Test
    public void setDescription() {
        gameTester.setDescription("A first person shooter end of the world game");
        assertEquals(Optional.of("A first person shooter end of the world game"),Optional.of(gameTester.getDescription()));
    }

    @Test
    public void getPrice() {
        assertEquals(Optional.of(new BigDecimal("30.99")),Optional.of(gameTester.getPrice()));
    }

    @Test
    public void setPrice() {
        gameTester.setPrice(new BigDecimal("60.99"));
        assertEquals(Optional.of(new BigDecimal("60.99")),Optional.of(gameTester.getPrice()));
    }

    @Test
    public void getStudio() {
        assertEquals(Optional.of("EA Games"),Optional.of(gameTester.getStudio()));
    }

    @Test
    public void setStudio() {
        gameTester.setStudio("Xbox");
        assertEquals(Optional.of("Xbox"),Optional.of(gameTester.getStudio()));
    }

    @Test
    public void getQuantity() {
        assertEquals(Optional.of(1),Optional.of(gameTester.getQuantity()));
    }

    @Test
    public void setQuantity() {
        gameTester.setQuantity(2);
        assertEquals(Optional.of(2),Optional.of(gameTester.getQuantity()));
    }
}