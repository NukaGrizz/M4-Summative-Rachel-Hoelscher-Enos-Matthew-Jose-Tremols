package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.controller;

import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model.Console;
import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/console")
public class ConsoleController {

    @Autowired
    ServiceLayer serviceLayer;

    //Get all consoles
    @GetMapping(value = "/")
    public List<Console> getAllConsoles() {
        return serviceLayer.findAllConsole();
    }

    //Get console by id
    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Console getConsoleById(@PathVariable long id) {
        Console console = serviceLayer.findConsole(id);
        return console;
    }


    //Create console
    @PostMapping
    public Console createConsole(@RequestBody Console console) {
        Console returnConsole = serviceLayer.saveConsole(console);
        return returnConsole;
    }

    //Update console
    @PutMapping(value = "/{id}")
    public void updateConsole(@RequestBody Console console, @PathVariable long id) {
        if (console.getConsole_id() == null) {
            console.setConsole_id(id);
        }

        if (console.getConsole_id() != id) {
            throw new IllegalArgumentException("Console ID must match parameter given");
        }
        serviceLayer.updateConsole(console);
    }

    //Delete by id
    @DeleteMapping(value = "/{id}")
    public void deleteConsole(@PathVariable long id) {
        serviceLayer.removeConsole(id);
    }


}
