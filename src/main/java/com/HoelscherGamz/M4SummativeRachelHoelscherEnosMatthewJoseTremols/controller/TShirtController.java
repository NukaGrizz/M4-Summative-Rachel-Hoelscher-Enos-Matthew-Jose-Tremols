package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.controller;

import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.models.TShirts;
import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.repository.TShirtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tShirt")
public class TShirtController {

    @Autowired
    TShirtRepository tShirtRepository;

    //Get all tShirt
    @GetMapping(value = "/{id}")
    public List<TShirts> getAllTShirts() {
        return tShirtRepository.findAll();
    }

    //Get tShirt by id
    @GetMapping(value = "/{id}")
    public TShirts getCarById(@PathVariable int id) {
        Optional<TShirts> tShirts = tShirtRepository.findById(id);

        if (!tShirts.isPresent()) {
            return null;
        }

        return tShirts.get();
    }

    //Create tShirt
    @PostMapping
    public TShirts createTShirt(@RequestBody TShirts tShirts) {
        tShirtRepository.save(tShirts);
        return tShirts;
    }

    //Update tShirt
    @PutMapping(value = "/{id}")
    public void updateTShirt(@RequestBody TShirts tShirts, @PathVariable long id) {
        if(tShirts.getId() == null) {
            tShirts.setId(id);
        }

        if(tShirts.getId() != id) {
            throw new IllegalArgumentException("TShirt ID must match parameter given");
        }
        tShirtRepository.save(tShirts);
    }

    //Delete by id
    @DeleteMapping(value = "/{id}")
    public void deleteTShirt(@PathVariable int id) {
        tShirtRepository.deleteById(id);
    }


}
