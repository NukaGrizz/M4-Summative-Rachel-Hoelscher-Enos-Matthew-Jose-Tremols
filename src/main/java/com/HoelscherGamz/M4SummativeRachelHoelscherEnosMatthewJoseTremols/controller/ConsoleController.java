package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.controller;

import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model.Console;
import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/console")
public class ConsoleController {

    @Autowired
    ServiceLayer serviceLayer;

    //Get all console
    @GetMapping
    public List<Console> getAllConsoles(@RequestParam(required = false) String manufacturer){

        return serviceLayer.findAllConsole(manufacturer);
    }

    //Get console by id
    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Console getConsoleById(@PathVariable long id) throws Exception{
        Console console = serviceLayer.findConsole(id);
        return console;
    }


    //Create console
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Console createConsole(@RequestBody @Valid Console console){
        Console returnConsole = serviceLayer.saveConsole(console);
        return returnConsole;
    }

    //Update console
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
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
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable long id) {
        serviceLayer.removeConsole(id);
    }


}
