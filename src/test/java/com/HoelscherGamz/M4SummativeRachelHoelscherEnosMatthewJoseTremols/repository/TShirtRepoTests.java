package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.repository;

import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model.Game;
import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model.TShirt;
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
public class TShirtRepoTests {
    @Autowired
    TShirtRepository repo;

    @Before
    public void setUp() throws Exception {
        repo.deleteAll();
    }

    @Test
    public void shouldAddGetDeleteTShirt() {
        TShirt tShirt1 = repo.save(new TShirt(1L, "Large", "Blue", "Men's 100% Smash Bros Shirt", new BigDecimal("29.99"), 1000));
        assertEquals(true, repo.existsById(tShirt1.getT_shirt_id()));
        repo.deleteById(tShirt1.getT_shirt_id());
        assertEquals(false, repo.existsById(tShirt1.getT_shirt_id()));
    }

    @Test
    public void shouldGetAllTShirts() {
        TShirt tShirt1 = repo.save(new TShirt(1L, "Large", "Blue", "Men's 100% Smash Bros Shirt", new BigDecimal("29.99"), 1000));
        TShirt tShirt2 = repo.save(new TShirt(2L, "Medium", "Green+", "Women's Kirby t-shirt", new BigDecimal("35.99"), 1500));

        List<TShirt> tShirts = repo.findAll();
        assertEquals(2, tShirts.size());
    }

    @Test
    public void shouldUpdateTShirt() {
        String newColor = "Red";

        TShirt newTShirt = repo.save(new TShirt(1L, "Large", "Blue", "Men's 100% Smash Bros Shirt", new BigDecimal("29.99"), 1000));
        newTShirt.setColor(newColor);
        TShirt updatedTShirt = repo.save(newTShirt);
        assertEquals(newColor, updatedTShirt.getColor());
    }

    @Test
    public void shouldFindByColor() {
        //
    }

    @Test
    public void shouldFindBySize() {
        //
    }

}