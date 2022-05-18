package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.repository;

import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model.TShirt;
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

public class TShirtRepositoryTest {
    @Autowired
    TShirtRepository tShirtRepository;

    @org.junit.Before
    public void setUp() throws Exception {
        tShirtRepository.deleteAll();
    }

    @Test
    public void addGetDeleteTShirt() {
        TShirt tShirt = new TShirt();
        tShirt.setT_shirt_id(1L);
        tShirt.setSize("Large");
        tShirt.setColor("Blue");
        tShirt.setDescription("Men's 100% Smash Bros Shirt");
        tShirt.setPrice(BigDecimal.valueOf(29.99));
        tShirt.setQuantity(1000);

        tShirt = tShirtRepository.save(tShirt);

        Optional<TShirt> tshirt1 = tShirtRepository.findById(tShirt.getT_shirt_id());

        assertEquals(tshirt1.get(), tShirt);

        tShirtRepository.deleteById(tShirt.getT_shirt_id());

        tshirt1 = tShirtRepository.findById(tShirt.getT_shirt_id());

        assertFalse(tshirt1.isPresent());

    }

    @Test
    public void updateTShirt() {
        TShirt tShirt = new TShirt();
        tShirt.setT_shirt_id(1L);
        tShirt.setSize("Large");
        tShirt.setColor("Blue");
        tShirt.setDescription("Men's 100% Smash Bros Shirt");
        tShirt.setPrice(BigDecimal.valueOf(29.99));
        tShirt.setQuantity(1000);

        tShirt = tShirtRepository.save(tShirt);

        tShirt.setSize("Medium");
        tShirt.setColor("Green");
        tShirt.setDescription("Women's Horizon Zero Dawn t-shirt");
        tShirt.setPrice(BigDecimal.valueOf(35.99));
        tShirt.setQuantity(1500);

        tShirtRepository.save(tShirt);

        Optional<TShirt> tShirt1 = tShirtRepository.findById(tShirt.getT_shirt_id());
        assertEquals(tShirt1.get(), tShirt);

    }

    @Test
    public void getAllTShirts() {

        TShirt tShirt = new TShirt();
        tShirt.setT_shirt_id(1L);
        tShirt.setSize("Large");
        tShirt.setColor("Blue");
        tShirt.setDescription("Men's 100% Smash Bros Shirt");
        tShirt.setPrice(BigDecimal.valueOf(29.99));
        tShirt.setQuantity(1000);

        tShirt = tShirtRepository.save(tShirt);

        tShirt = new TShirt();
        tShirt.setT_shirt_id(2L);
        tShirt.setSize("Medium");
        tShirt.setColor("Green");
        tShirt.setDescription("Women's Horizon Zero Dawn t-shirt");
        tShirt.setPrice(BigDecimal.valueOf(35.99));
        tShirt.setQuantity(1500);

        tShirt = tShirtRepository.save(tShirt);

        List<TShirt> aList = tShirtRepository.findAll();
        assertEquals(aList.size(), 2);

    }
}