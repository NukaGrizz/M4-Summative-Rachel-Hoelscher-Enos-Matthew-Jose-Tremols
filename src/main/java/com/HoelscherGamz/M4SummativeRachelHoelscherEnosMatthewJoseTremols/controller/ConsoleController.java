package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.controller;

import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model.Console;
import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.repository.ConsoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/console")
public class ConsoleController {

    @Autowired
    ConsoleRepository consoleRepository;

    //Get all consoles
    @GetMapping(value = "/{id}")
    public List<Console> getAllConsoles() {return consoleRepository.findAll();}

    //Get console by id
    @GetMapping(value = "/{id}")
    public Console getConsoleById(@PathVariable long id) {
        Optional<Console> console = consoleRepository.findById(id);
        if (!console.isPresent()) {
            return null;
        }

        return console.get();
    }

    //Create console
    @PostMapping
    public Console createConsole(@RequestBody Console console) {
        consoleRepository.save(console);
        return console;
    }

    //Update console
    @PutMapping(value = "/{id}")
    public void updateConsole(@RequestBody Console console, @PathVariable long id) {
        if(console.getConsole_id() == null) {
            console.setConsole_id(id);
        }

        if(console.getConsole_id() != id) {
            throw new IllegalArgumentException("Console ID must match parameter given");
        }
        consoleRepository.save(console);
    }

    //Delete by id
    @DeleteMapping(value = "/{id}")
    public void deleteConsole(@PathVariable long id) {
        consoleRepository.deleteById(id);
    }


}
