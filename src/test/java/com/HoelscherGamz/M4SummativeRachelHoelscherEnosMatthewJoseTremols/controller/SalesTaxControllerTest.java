package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.controller;


import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model.SalesTax;
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
@WebMvcTest(ConsoleController.class)
public class SalesTaxControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @MockBean
    private ServiceLayer serviceLayer;

    @Before
    public void setUp() {

        //GET by id mock
        SalesTax mockOutput = new SalesTax();
        mockOutput.setState("FL");
        mockOutput.setRate(BigDecimal.valueOf(0.06));

        doReturn(mockOutput).when(serviceLayer).findSalesTax("FL");

        //POST mock
        SalesTax createInput = new SalesTax();
        createInput.setState("FL");
        createInput.setRate(BigDecimal.valueOf(0.06));

        doReturn(mockOutput).when(serviceLayer).saveSalesTax(createInput);

        //GET all mock
        List<SalesTax> salesTaxesList = Arrays.asList(mockOutput);

        doReturn(salesTaxesList).when(serviceLayer).findAllSalesTax();

    }

    @Test
    public void getAllSalesTax() throws Exception {

        mockMvc.perform(get("/salestax"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]").isNotEmpty());
    }

    @Test
    public void getSalesTaxById() throws Exception{

        SalesTax mockOutput = new SalesTax();
        mockOutput.setState("FL");
        mockOutput.setRate(BigDecimal.valueOf(0.06));


        String mockJson = mapper.writeValueAsString(mockOutput);

        mockMvc.perform(get("/salestax/FL")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(mockJson));
    }

    @Test
    public void createSalesTax() throws Exception {

        SalesTax createInput = new SalesTax();
        createInput.setState("WY");
        createInput.setRate(BigDecimal.valueOf(0.06));

        String mockInputJson = mapper.writeValueAsString(createInput);

        SalesTax createOutput = new SalesTax();
        createOutput.setState("WY");
        createOutput.setRate(BigDecimal.valueOf(0.06));

        String mockOutputJson = mapper.writeValueAsString(createOutput);

        mockMvc.perform(post("/salestax")
                        .content(mockInputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(mockOutputJson));

    }

    @Test
    public void updateSalesTax() throws Exception {
        SalesTax updateInput = new SalesTax();
        updateInput.setState("WY");
        updateInput.setRate(BigDecimal.valueOf(0.07));

        String mockUpdateJson = mapper.writeValueAsString(updateInput);

        mockMvc.perform(
                        put("/salestax/WY")
                                .content(mockUpdateJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void deleteSalesTax()  throws Exception {

        mockMvc.perform(delete("/salestax/WY"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}