package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.controller;


import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model.TShirt;
import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.repository.TShirtRepository;
import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tShirt")
public class TShirtController {

    @Autowired
    ServiceLayer serviceLayer;

    //Get all tShirt
    @GetMapping
    public List<TShirt> getAllTShirt(@RequestParam(required = false) String color, @RequestParam(required = false) String size){
        return serviceLayer.findAllTShirt(color, size);
    }

    //Get tShirt by id
    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TShirt getTShirtById(@PathVariable long id)throws Exception {
       TShirt tShirt = serviceLayer.findTShirt(id);
        return tShirt;
    }

    //Create tShirt
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TShirt createTShirt(@RequestBody @Valid TShirt tShirt){
        TShirt returnTShirt = serviceLayer.saveTShirt(tShirt);
        return returnTShirt;
    }

    //Update tShirt
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTShirt(@RequestBody TShirt tShirt, @PathVariable long id){
        if(tShirt.getT_shirt_id() == null) {
            tShirt.setT_shirt_id(id);
        }

        if(tShirt.getT_shirt_id() != id) {
            throw new IllegalArgumentException("TShirt ID must match parameter given");
        }
        serviceLayer.updateTShirt(tShirt);
    }

    //Delete by id
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTShirt(@PathVariable long id){
        serviceLayer.removeTShirt(id);
    }


}
