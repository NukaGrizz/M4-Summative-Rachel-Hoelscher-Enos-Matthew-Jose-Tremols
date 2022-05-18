package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.repository;

import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model.Console;
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
public class ConsoleRepoTests {
    @Autowired
    ConsoleRepository repo;

    @Before
    public void setUp() throws Exception {
        repo.deleteAll();
    }

    @Test
    public void shouldAddGetDeleteConsole() {
        Console newConsole = repo.save(new Console(1L, "PS5", "Sony", "825 GB", "AMD Zen 2 CPU", new BigDecimal("499.99"), 100));
        assertEquals(true, repo.existsById(newConsole.getConsole_id()));
        repo.deleteById(newConsole.getConsole_id());
        assertEquals(false, repo.existsById(newConsole.getConsole_id()));
    }

    @Test
    public void shouldGetAllConsoles() {
        repo.save(new Console(1L, "PS5", "Sony", "825 GB", "AMD Zen 2 CPU", new BigDecimal("499.99"), 100));
        repo.save(new Console(2L, "PS6", "Sony", "1 TB","AMD Zen 3 CPU", new BigDecimal("649.99"),50));

        List<Console> consoles = repo.findAll();
        assertEquals(2, consoles.size());
    }

    @Test
    public void shouldUpdateConsole() {
        String newManufacturer = "Sony";

        Console newConsole = repo.save(new Console(3L, "XBox Series X", "Microsoft", "1TB", "AMD Zen 4 CPU", new BigDecimal("550.99"), 200));
        newConsole.setManufacturer(newManufacturer);
        Console updatedConsole = repo.save(newConsole);
        assertEquals(newManufacturer, updatedConsole.getManufacturer());
    }

    @Test
    public void shouldFindByManufacturer() {
        repo.save(new Console(1L, "PS5", "Sony", "825 GB", "AMD Zen 2 CPU", new BigDecimal("499.99"), 100));
        repo.save(new Console(2L, "PS6", "Sony", "1 TB","AMD Zen 3 CPU", new BigDecimal("649.99"),50));

        List<Console> consoles = repo.findByManufacturer("Sony");
        assertEquals(2, consoles.size());
    }

}