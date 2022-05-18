package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.controller;

import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model.Console;
import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model.TShirt;
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

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(TShirtController.class)
public class TShirtControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @MockBean
    private ServiceLayer serviceLayer;

    @Before
    public void setUp() {

        //GET by id mock
        TShirt mockOutput = new TShirt();
        mockOutput.setT_shirt_id(2L);
        mockOutput.setSize("Large");
        mockOutput.setColor("Blue");
        mockOutput.setDescription("super-soft proprietary cotton-poly fabric");
        mockOutput.setPrice(new BigDecimal("9.99"));
        mockOutput.setQuantity(20);

        doReturn(mockOutput).when(serviceLayer).findTShirt(2L);

        //POST mock
        TShirt createInput = new TShirt();
//        createInput.setT_shirt_id(2L);
        createInput.setSize("Medium");
        createInput.setColor("Green");
        createInput.setDescription("made of 100% organic cotton for superior breathability and undeniable softness");
        createInput.setPrice(new BigDecimal("19.99"));
        createInput.setQuantity(10);

        TShirt createOutput = new TShirt();
        createOutput.setT_shirt_id(2L);
        createOutput.setSize("Medium");
        createOutput.setColor("Green");
        createOutput.setDescription("made of 100% organic cotton for superior breathability and undeniable softness");
        createOutput.setPrice(new BigDecimal("19.99"));
        createOutput.setQuantity(10);

        doReturn(createOutput).when(serviceLayer).saveTShirt(createInput);

        //GET all mock
        List<TShirt> tShirtList = Arrays.asList(mockOutput, createOutput, createInput);

        doReturn(tShirtList).when(serviceLayer).findAllTShirt();


    }

    @Test
    public void getAllTShirt() throws Exception{

        mockMvc.perform(get("/tShirt"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]").isNotEmpty());
    }

    @Test
    public void getTShirtById() throws Exception{

        TShirt mockInput = new TShirt();
        mockInput.setT_shirt_id(2L);
        mockInput.setSize("Large");
        mockInput.setColor("Blue");
        mockInput.setDescription("super-soft proprietary cotton-poly fabric");
        mockInput.setPrice(new BigDecimal("9.99"));
        mockInput.setQuantity(20);

        String mockJson = mapper.writeValueAsString(mockInput);

        mockMvc.perform(get("/tShirt/2")
                ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(mockJson));
    }

    @Test
    public void createTShirt() throws Exception{

        TShirt createInput = new TShirt();
//        createInput.setT_shirt_id(2L);
        createInput.setSize("Medium");
        createInput.setColor("Green");
        createInput.setDescription("made of 100% organic cotton for superior breathability and undeniable softness");
        createInput.setPrice(new BigDecimal("19.99"));
        createInput.setQuantity(10);

        String mockInputJson = mapper.writeValueAsString(createInput);

        TShirt createOutput = new TShirt();
        createOutput.setT_shirt_id(2L);
        createOutput.setSize("Medium");
        createOutput.setColor("Green");
        createOutput.setDescription("made of 100% organic cotton for superior breathability and undeniable softness");
        createOutput.setPrice(new BigDecimal("19.99"));
        createOutput.setQuantity(10);

        String mockOutputJson = mapper.writeValueAsString(createOutput);

        mockMvc.perform(post("/tShirt")
                        .content(mockInputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(mockOutputJson));
    }

    @Test
    public void updateTShirt() throws Exception{

        TShirt updateOutput = new TShirt();
        updateOutput.setT_shirt_id(4L);
        updateOutput.setSize("Small");
        updateOutput.setColor("Charcoal");
        updateOutput.setDescription("8 oz heavy cotton twill is durable and warm");
        updateOutput.setPrice(new BigDecimal("29.99"));
        updateOutput.setQuantity(5);

        String mockUpdateJson = mapper.writeValueAsString(updateOutput);

        mockMvc.perform(
                        put("/tShirt/4")
                                .content(mockUpdateJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void deleteTShirt() throws Exception{

        mockMvc.perform(delete("/tShirt/8"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}