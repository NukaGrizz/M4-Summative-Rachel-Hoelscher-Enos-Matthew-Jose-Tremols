package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.controller;

import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model.Console;
import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.service.ServiceLayer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ConsoleController.class)
public class ConsoleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @MockBean
    private ServiceLayer serviceLayer;

    @Before
    public void setUp() {
        Console mockOutput = new Console();
        mockOutput.setConsole_id(2L);
        mockOutput.setModel("xbox");
        mockOutput.setManufacturer("Microsoft");
        mockOutput.setMemory_amount("23");
        mockOutput.setProcessor("intel");
        mockOutput.setPrice(new BigDecimal("499.99"));
        mockOutput.setQuantity(20);

        doReturn(mockOutput).when(serviceLayer).findConsole(2L);

    }


    @Test
    public void getConsoleById() throws Exception {

        Console mockInput = new Console();
        mockInput.setConsole_id(2L);
        mockInput.setModel("xbox");
        mockInput.setManufacturer("Microsoft");
        mockInput.setMemory_amount("23");
        mockInput.setProcessor("intel");
        mockInput.setPrice(new BigDecimal("499.99"));
        mockInput.setQuantity(20);

        String mockJson = mapper.writeValueAsString(mockInput);

        mockMvc.perform(get("/console/2")
                ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(mockJson));

    }
}