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
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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

        //GET by id mock
        Console mockOutput = new Console();
        mockOutput.setConsole_id(2L);
        mockOutput.setModel("xbox");
        mockOutput.setManufacturer("Microsoft");
        mockOutput.setMemory_amount("23");
        mockOutput.setProcessor("intel");
        mockOutput.setPrice(new BigDecimal("499.99"));
        mockOutput.setQuantity(20);

        doReturn(mockOutput).when(serviceLayer).findConsole(2L);

        //POST mock
        Console createInput = new Console();
//        createInput.setConsole_id(0L);
        createInput.setModel("playstation");
        createInput.setManufacturer("sony");
        createInput.setMemory_amount("23");
        createInput.setProcessor("intel");
        createInput.setPrice(new BigDecimal("399.99"));
        createInput.setQuantity(10);

        Console createOutput = new Console();
        createOutput.setConsole_id(6L);
        createOutput.setModel("playstation");
        createOutput.setManufacturer("sony");
        createOutput.setMemory_amount("23");
        createOutput.setProcessor("intel");
        createOutput.setPrice(new BigDecimal("399.99"));
        createOutput.setQuantity(10);

        doReturn(createOutput).when(serviceLayer).saveConsole(createInput);

        //GET all mock
        List<Console> consoleList2 = Arrays.asList(mockOutput, createOutput, createInput);

        doReturn(consoleList2).when(serviceLayer).findAllConsole(null);

    }


    @Test
    public void getAllConsoles() throws Exception {

        mockMvc.perform(get("/console"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]").isNotEmpty());
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

    @Test
    public void createConsole() throws Exception {

        Console createInput = new Console();
//        createInput.setConsole_id(0L);
        createInput.setModel("playstation");
        createInput.setManufacturer("sony");
        createInput.setMemory_amount("23");
        createInput.setProcessor("intel");
        createInput.setPrice(new BigDecimal("399.99"));
        createInput.setQuantity(10);

        String mockInputJson = mapper.writeValueAsString(createInput);

        Console createOutput = new Console();
        createOutput.setConsole_id(6L);
        createOutput.setModel("playstation");
        createOutput.setManufacturer("sony");
        createOutput.setMemory_amount("23");
        createOutput.setProcessor("intel");
        createOutput.setPrice(new BigDecimal("399.99"));
        createOutput.setQuantity(10);

        String mockOutputJson = mapper.writeValueAsString(createOutput);

        mockMvc.perform(post("/console")
                        .content(mockInputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(mockOutputJson));
    }

    @Test
    public void updateConsole() throws Exception {
        Console updateOutput = new Console();
        updateOutput.setConsole_id(8L);
        updateOutput.setModel("N64");
        updateOutput.setManufacturer("Nintendo");
        updateOutput.setMemory_amount("13");
        updateOutput.setProcessor("ryzen");
        updateOutput.setPrice(new BigDecimal("299.99"));
        updateOutput.setQuantity(6);

        String mockUpdateJson = mapper.writeValueAsString(updateOutput);

        mockMvc.perform(
                put("/console/8")
                        .content(mockUpdateJson)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isNoContent());

    }
    @Test
    public void deleteConsole() throws Exception {

        mockMvc.perform(delete("/console/8"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }



    }