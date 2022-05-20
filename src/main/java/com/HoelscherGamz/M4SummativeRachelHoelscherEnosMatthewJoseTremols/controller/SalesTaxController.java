package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.controller;


import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model.SalesTax;
import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/salestax")
public class SalesTaxController {

    @Autowired
    ServiceLayer serviceLayer;

    //Get all SalesTax
    @GetMapping
    public List<SalesTax> getAllSalesTax()throws Exception {
        return serviceLayer.findAllSalesTax();
    }

    //Get SalesTax by id
    @GetMapping(value = "/{state}")
    @ResponseStatus(HttpStatus.OK)
    public SalesTax getSalesTaxById(@PathVariable String state)throws Exception {
        SalesTax salesTax = serviceLayer.findSalesTax(state);
        return salesTax;
    }


    //Create SalesTax
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SalesTax createSalesTax(@RequestBody @Valid SalesTax salesTax)throws Exception {
        SalesTax returnSalesTax = serviceLayer.saveSalesTax(salesTax);
        return returnSalesTax;
    }

    //Update SalesTax
    @PutMapping(value = "/{state}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateSalesTax(@RequestBody SalesTax salesTax, @PathVariable String state)throws Exception {
        if (salesTax.getState() == null) {
            salesTax.setState(state);
        }

        if (!salesTax.getState().equals(state)) {
            throw new IllegalArgumentException("State state value must match parameter given");
        }
        serviceLayer.updateSalesTax(salesTax);
    }

    //Delete SalesTaxby id
    @DeleteMapping(value = "/{state}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSalesTax(@PathVariable String state)throws Exception {
        serviceLayer.removeSalesTax(state);
    }

}
