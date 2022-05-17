package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.repository;

import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model.Console;
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

public class ConsoleRepositoryTest {

    @Autowired
    ConsoleRepository consoleRepository;

    @org.junit.Before
    public void setUp() throws Exception {
        consoleRepository.deleteAll();
    }

    @Test
    public void addGetDeleteConsole() {
        Console console = new Console();
        console.setId(1L);
        console.setModel("PS5");
        console.setManufacturer("Sony");
        console.setMemoryAmount("825 GB");
        console.setProcessor("AMD Zen 2 CPU");
        console.setPrice(BigDecimal.valueOf(499.99));
        console.setQuantity(100);

        console = consoleRepository.save(console);

        Optional<Console> console1 = consoleRepository.findById(console.getId());

        assertEquals(console1.get(), console);

        consoleRepository.deleteById(console.getId());

        console1 = consoleRepository.findById(console.getId());

        assertFalse(console1.isPresent());

    }

    @Test
    public void updateConsole() {
        Console console = new Console();
        console.setId(1L);
        console.setModel("PS5");
        console.setManufacturer("Sony");
        console.setMemoryAmount("825 GB");
        console.setProcessor("AMD Zen 2 CPU");
        console.setPrice(BigDecimal.valueOf(499.99));
        console.setQuantity(100);

        console = consoleRepository.save(console);

        console.setModel("PS6");
        console.setManufacturer("Sega");
        console.setMemoryAmount("1 TB");
        console.setProcessor("AMD Zen 3 CPU");
        console.setPrice(BigDecimal.valueOf(549.99));
        console.setQuantity(50);

        consoleRepository.save(console);

        Optional<console> console1 = consoleRepository.findById(console.getId());
        assertEquals(console1.get(), console);

    }

    @Test
    public void getAllConsoles() {

        Console console = new Console();
        console.setId(1L);
        console.setModel("PS5");
        console.setManufacturer("Sony");
        console.setMemoryAmount("825 GB");
        console.setProcessor("AMD Zen 2 CPU");
        console.setPrice(BigDecimal.valueOf(499.99));
        console.setQuantity(100);

        console = consoleRepository.save(console);

        console = new Console();
        console.setId(2L);
        console.setModel("XBox Series X");
        console.setManufacturer("Microsoft");
        console.setMemoryAmount("1TB");
        console.setProcessor("AMD Zen 2 CPU");
        console.setPrice(BigDecimal.valueOf(550.99));
        console.setQuantity(200);

        console = consoleRepository.save(console);

        List<Console> aList = consoleRepository.findAll();
        assertEquals(aList.size(), 2);

    }
}