package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.repository;

import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model.ProcessingFee;
import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model.SalesTax;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProcessingFeeRepositoryTest {

    @Autowired
    ProcessingFeeRepository processingFeeRepository;

    @org.junit.Before
    public void setUp() throws Exception {
        processingFeeRepository.deleteAll();
    }

    @Test
    public void shouldAddGetDeleteProcessingFee() {
        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setProduct_type("game");
        processingFee.setFee(BigDecimal.valueOf(1.49));

        processingFee = processingFeeRepository.save(processingFee);

        Optional<ProcessingFee> processingFee1 = processingFeeRepository.findOne(processingFee.getProduct_type("game"));

        assertEquals(processingFee1.get(), processingFee);

        // how to delete by something other than ID?
        processingFeeRepository.deleteById(processingFee.getProduct_type("game"));

        processingFee1 = processingFeeRepository.findBy(processingFee.getProduct_type("game"));

        assertFalse(processingFee1.isPresent());
    }

    @Test
    public void shouldUpdateProcessingFee() {
        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setProduct_type("game");
        processingFee.setFee(BigDecimal.valueOf(1.49));
        processingFeeRepository.save(processingFee);

        processingFee.setProduct_type("console");
        processingFee.setFee(BigDecimal.valueOf(14.99));
        processingFeeRepository.save(processingFee);

        Optional<ProcessingFee> processingFee1 = processingFeeRepository.findBy(processingFee.getProduct_type("console"));
        assertEquals(processingFee1.get(), processingFee);

    }

    @Test
    public void shouldGetAllProcessingFee() {

        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setProduct_type("game");
        processingFee.setFee(BigDecimal.valueOf(1.49));
        processingFeeRepository.save(processingFee);

        processingFee = processingFeeRepository.save(processingFee);

        processingFee.setProduct_type("console");
        processingFee.setFee(BigDecimal.valueOf(14.99));
        processingFeeRepository.save(processingFee);


        processingFee = processingFeeRepository.save(processingFee);

        List<ProcessingFee> aList = processingFeeRepository.findAll();
        assertEquals(aList.size(), 2);

    }
}