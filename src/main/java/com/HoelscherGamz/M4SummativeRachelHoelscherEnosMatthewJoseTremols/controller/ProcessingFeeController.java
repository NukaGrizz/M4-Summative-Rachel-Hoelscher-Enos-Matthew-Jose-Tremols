package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.controller;

import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model.ProcessingFee;
import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model.SalesTax;
import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/processingfee")
public class ProcessingFeeController {

        @Autowired
        ServiceLayer serviceLayer;

        //Get all ProcessingFee
        @GetMapping
        public List<ProcessingFee> getAllProcessingFee() {
            return serviceLayer.findAllProcessingFee();
        }

        //Get ProcessingFee by id
        @GetMapping(value = "/{productType}")
        @ResponseStatus(HttpStatus.OK)
        public ProcessingFee getProcessingFeeById(@PathVariable String productType) {
            ProcessingFee processingFee = serviceLayer.findProcessingFee(productType);
            return processingFee;
        }


        //Create ProcessingFee
        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public ProcessingFee createProcessingFee(@RequestBody @Valid ProcessingFee processingFee) {
            ProcessingFee returnProcessingFee = serviceLayer.saveProcessingFee(processingFee);
            return returnProcessingFee;
        }

        //Update ProcessingFee
        @PutMapping(value = "/{productType}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void updateProcessingFee(@RequestBody ProcessingFee processingFee, @PathVariable String productType) {
            if (processingFee.getProduct_type() == null) {
                processingFee.setProduct_type(productType);
            }

            if (!processingFee.getProduct_type().equals(productType)) {
                throw new IllegalArgumentException("ProcessingFee productType value must match parameter given");
            }
            serviceLayer.updateProcessingFee(processingFee);
        }

        //Delete ProcessingFee by id
        @DeleteMapping(value = "/{productType}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void deleteProcessingFee(@PathVariable String productType) { serviceLayer.removeProcessingFee(productType) ;}
}
