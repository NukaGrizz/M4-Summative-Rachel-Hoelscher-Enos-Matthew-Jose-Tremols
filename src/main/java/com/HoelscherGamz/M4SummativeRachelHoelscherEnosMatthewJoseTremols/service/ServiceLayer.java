package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.service;

import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model.Console;
import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Component
public class ServiceLayer {

    private ConsoleRepository consoleRepository;
    private GameRespository gameRespository;
    private InvoiceRepository invoiceRepository;
    private ProcessingFeeRepository processingFeeRepository;
    private SalesTaxRepository salesTaxRepository;
    private TShirtRepository tShirtRepository;

    @Autowired
    public ServiceLayer(ConsoleRepository consoleRepository, GameRespository gameRespository,InvoiceRepository invoiceRepository, ProcessingFeeRepository processingFeeRepository, SalesTaxRepository salesTaxRepository, TShirtRepository tShirtRepository){
        this.consoleRepository = consoleRepository;
        this.gameRespository = gameRespository;
        this.tShirtRepository = tShirtRepository;
        this.invoiceRepository = invoiceRepository;
        this.processingFeeRepository = processingFeeRepository;
        this.salesTaxRepository = salesTaxRepository;
    }

    //CRUD OPERATIONS FOR CONSOLE
    @Transactional
    public Console saveConsole(Console console) {

        // Persist Album
        Console c = new Console();
        c.setModel(console.getModel());
        c.setManufacturer(console.getManufacturer());
        c.setMemoryAmount(console.getMemoryAmount());
        c.setProcessor(console.getProcessor());
        c.setPrice(console.getPrice());
        c.setQuantity(console.getQuantity());
        consoleRepository.save(c);
        console.setId(c.getId());
        return  console;
    }

    public Console findConsole(Long id) {

        // Get the album object first
        Optional<Console> console = consoleRepository.findById(id);

        return console.isPresent() ? console.get() : null;
    }

    public List<Console> findAllConsole() {

        List<Console> consoleList = consoleRepository.findAll();

        return consoleList;
    }

    public List<Console> findByManufacturer(String manufacturer){
        return consoleRepository.findByManufacturer(manufacturer);
    }


    @Transactional
    public void updateConsole(Console console) {

        // Update the album information
        Console c = new Console();
        c.setModel(console.getModel());
        c.setManufacturer(console.getManufacturer());
        c.setMemoryAmount(console.getMemoryAmount());
        c.setProcessor(console.getProcessor());
        c.setPrice(console.getPrice());
        c.setQuantity(console.getQuantity());
        consoleRepository.save(c);
    }

    @Transactional
    public void removeConsole(Long id) {
        // Remove Console
        consoleRepository.deleteById(id);
    }

    //CRUD OPERATIONS FOR GAME

    //CRUD OPERATIONS FOR TSHIRT

    //CRUD OPERATIONS FOR INVOICE

    //CRUD OPERATIONS FOR PROCESSING FEE

    //CRUD OPERATIONS FOR SALES TAX
}
