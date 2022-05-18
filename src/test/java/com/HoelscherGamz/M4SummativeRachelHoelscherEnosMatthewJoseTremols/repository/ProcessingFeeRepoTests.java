package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.repository;

import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model.ProcessingFee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProcessingFeeRepoTests {

    @Autowired
    ProcessingFeeRepository repo;

    @Before
    public void setUp() throws Exception {
        repo.deleteAll();
    }

    @Test
    public void shouldAddGetDeleteProcessingFee() {
        ProcessingFee newProcessingFee = repo.save(new ProcessingFee("game", new BigDecimal("1.49")));
        assertEquals(true, repo.existsById(newProcessingFee.getProduct_type()));
        repo.deleteById(newProcessingFee.getProduct_type());
        assertEquals(false, repo.existsById(newProcessingFee.getProduct_type()));
    }

    @Test
    public void shouldGetAllProcessingFees() {
        repo.save(new ProcessingFee("game", new BigDecimal("1.49")));
        repo.save(new ProcessingFee("shirt", new BigDecimal("1.98")));


        List<ProcessingFee> processingFees = repo.findAll();
        assertEquals(2, processingFees.size());
    }

    @Test
    public void shouldUpdateProcessingFee() {
        BigDecimal newFee = new BigDecimal(1.75);

        ProcessingFee newProcessingFee = repo.save(new ProcessingFee("game", new BigDecimal("1.49")));
        newProcessingFee.setFee(newFee);
        ProcessingFee updatedFee = repo.save(newProcessingFee);
        assertEquals(newFee, updatedFee.getFee());
    }
}
