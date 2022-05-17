package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.controller;


import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model.TShirt;
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
    public List<TShirt> getAllTShirt() {
        return tShirtRepository.findAll();
    }

    //Get tShirt by id
    @GetMapping(value = "/{id}")
    public TShirt getTShirtById(@PathVariable long id) {
        Optional<TShirt> tShirt = tShirtRepository.findById(id);

        if (!tShirt.isPresent()) {
            return null;
        }

        return tShirt.get();
    }

    //Create tShirt
    @PostMapping
    public TShirt createTShirt(@RequestBody TShirt tShirt) {
        tShirtRepository.save(tShirt);
        return tShirt;
    }

    //Update tShirt
    @PutMapping(value = "/{id}")
    public void updateTShirt(@RequestBody TShirt tShirt, @PathVariable long id) {
        if(tShirt.getT_shirt_id() == null) {
            tShirt.setT_shirt_id(id);
        }

        if(tShirt.getT_shirt_id() != id) {
            throw new IllegalArgumentException("TShirt ID must match parameter given");
        }
        tShirtRepository.save(tShirt);
    }

    //Delete by id
    @DeleteMapping(value = "/{id}")
    public void deleteTShirt(@PathVariable long id) {
        tShirtRepository.deleteById(id);
    }


}
