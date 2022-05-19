package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.controller;

import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model.ProcessingFee;
import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.service.ServiceLayer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;


import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ProcessingFeeController.class)
public class ProcessingFeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @MockBean
    private ServiceLayer serviceLayer;

    @Before
    public void setUp() {

        //GET by id mock
        ProcessingFee mockOutput = new ProcessingFee();
        mockOutput.setProduct_type("game");
        mockOutput.setFee(BigDecimal.valueOf(15.00));

        doReturn(mockOutput).when(serviceLayer).findProcessingFee("game");

        //POST mock
        ProcessingFee createInput = new ProcessingFee();
        createInput.setProduct_type("game");
        createInput.setFee(BigDecimal.valueOf(15.00));

        doReturn(mockOutput).when(serviceLayer).saveProcessingFee(createInput);

        //GET all mock
        List<ProcessingFee> processingFeeList = Arrays.asList(mockOutput);

        doReturn(processingFeeList).when(serviceLayer).findAllProcessingFee();

    }

    @Test
    public void getAllProcessingFee() throws Exception {

        mockMvc.perform(get("/processingfee"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]").isNotEmpty());
    }

    @Test
    public void getProcessingFeeById() throws Exception {

        ProcessingFee mockOutput = new ProcessingFee();
        mockOutput.setProduct_type("game");
        mockOutput.setFee(BigDecimal.valueOf(15.00));


        String mockJson = mapper.writeValueAsString(mockOutput);

        mockMvc.perform(get("/processingfee/game")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(mockJson));
    }

    @Test
    public void createProcessingFee() throws Exception {

        ProcessingFee createInput = new ProcessingFee();
        createInput.setProduct_type("game");
        createInput.setFee(BigDecimal.valueOf(15.00));

        String mockInputJson = mapper.writeValueAsString(createInput);

        ProcessingFee createOutput = new ProcessingFee();
        createOutput.setProduct_type("game");
        createOutput.setFee(new BigDecimal("15.00"));

        String mockOutputJson = mapper.writeValueAsString(createOutput);

        mockMvc.perform(post("/processingfee")
                        .content(mockInputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(mockOutputJson));

    }

    @Test
    public void updateProcessingFee() throws Exception {
        ProcessingFee updateInput = new ProcessingFee();
        updateInput.setProduct_type("game");
        updateInput.setFee(BigDecimal.valueOf(10.00));

        String mockUpdateJson = mapper.writeValueAsString(updateInput);

        mockMvc.perform(
                        put("/processingfee/game")
                                .content(mockUpdateJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void deleteSalesTax() throws Exception {

        mockMvc.perform(delete("/processingfee/game"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}