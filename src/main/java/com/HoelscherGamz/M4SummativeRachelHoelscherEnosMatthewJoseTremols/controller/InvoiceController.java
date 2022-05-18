package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.controller;


import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model.Invoice;
import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingRequestValueException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    ServiceLayer serviceLayer;

    //Get all invoice
    @GetMapping
    public List<Invoice> getAllInvoices() {
        return serviceLayer.findAllInvoice();
    }

    //Get invoice by id
    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Invoice getInvoiceById(@PathVariable long id) {
        Invoice invoice = serviceLayer.findInovice(id);
        return invoice;
    }

    //Create invoice
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Invoice createInvoice(@RequestBody Invoice invoice) throws Exception {
        if (invoice.getName().isEmpty()) {
            throw new MissingRequestValueException("You must provide a value for name in your request body");
        } else if (invoice.getStreet().isEmpty()){
            throw new MissingRequestValueException("You must provide a value for street in your request body");
        } else if (invoice.getCity().isEmpty()){
            throw new MissingRequestValueException("You must provide a value for city in your request body");
        }else if (invoice.getZipcode().isEmpty()){
            throw new MissingRequestValueException("You must provide a value for zipcode in your request body");
        }else if (invoice.getItemType().isEmpty()){
            throw new MissingRequestValueException("You must provide a value for itemType in your request body");
        }else if (invoice.getItemId() == null || invoice.getItemId() == 0){
            throw new MissingRequestValueException("You must provide a value for itemId in your request body");
        }else if (invoice.getQuantity() == 0){
            throw new MissingRequestValueException("You must provide a value for quantity in your request body");
        }

        Invoice returnInvoice = serviceLayer.saveInvoice(invoice);
        return returnInvoice;
    }

    //Update invoice
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateInvoice(@RequestBody Invoice invoice, @PathVariable long id) throws Exception {
        if (invoice.getInvoice_id() == null) {
            invoice.setInvoice_id(id);
        }

        if (invoice.getInvoice_id() != id) {
            throw new IllegalArgumentException("Game ID must match parameter given");
        }
        serviceLayer.updateInvoice(invoice);
    }

    //Delete invoice by id
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteInvoice(@PathVariable long id) {
        serviceLayer.removeInvoice(id);
    }
}
