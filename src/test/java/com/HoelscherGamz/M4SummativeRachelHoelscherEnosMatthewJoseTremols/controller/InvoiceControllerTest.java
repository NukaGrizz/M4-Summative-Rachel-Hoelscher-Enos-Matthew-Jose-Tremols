package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.controller;

import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model.Invoice;
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

import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(InvoiceController.class)
public class InvoiceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @MockBean
    private ServiceLayer serviceLayer;

    @Before
    public void setUp() throws Exception {

        //GET by id mock
        Invoice mockOutput = new Invoice();
        mockOutput.setInvoice_id(1L);
        mockOutput.setName("Joe");
        mockOutput.setStreet("These Streets");
        mockOutput.setCity("This City");
        mockOutput.setState("FL");
        mockOutput.setZipcode("66666");
        mockOutput.setItemType("game");
        mockOutput.setItemId(1L);
        mockOutput.setUnit_price(BigDecimal.valueOf(2.00));
        mockOutput.setQuantity(2);
        mockOutput.setSubtotal(BigDecimal.valueOf(4.00));
        mockOutput.setTax(BigDecimal.valueOf(0.24));
        mockOutput.setProcessing_fee(BigDecimal.valueOf(1.49));
        mockOutput.setTotal(BigDecimal.valueOf(5.73));


        doReturn(mockOutput).when(serviceLayer).findInvoice(1L);

        //POST mock
        Invoice createInput = new Invoice();
        createInput.setName("Joe");
        createInput.setStreet("These Streets");
        createInput.setCity("This City");
        createInput.setState("FL");
        createInput.setZipcode("66666");
        createInput.setItemType("game");
        createInput.setItemId(1L);
        createInput.setQuantity(2);

        doReturn(mockOutput).when(serviceLayer).saveInvoice(createInput);

        //GET all mock
        List<Invoice> invoiceList = Arrays.asList(mockOutput);

        doReturn(invoiceList).when(serviceLayer).findAllInvoice();

    }

    @Test
    public void getAllInvoices() throws Exception{

        mockMvc.perform(get("/invoice"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]").isNotEmpty());
    }

    @Test
    public void getInvoiceById() throws Exception{

        Invoice mockOutput = new Invoice();
        mockOutput.setInvoice_id(1L);
        mockOutput.setName("Joe");
        mockOutput.setStreet("These Streets");
        mockOutput.setCity("This City");
        mockOutput.setState("FL");
        mockOutput.setZipcode("66666");
        mockOutput.setItemType("game");
        mockOutput.setItemId(1L);
        mockOutput.setUnit_price(BigDecimal.valueOf(2.00));
        mockOutput.setQuantity(2);
        mockOutput.setSubtotal(BigDecimal.valueOf(4.00));
        mockOutput.setTax(BigDecimal.valueOf(0.24));
        mockOutput.setProcessing_fee(BigDecimal.valueOf(1.49));
        mockOutput.setTotal(BigDecimal.valueOf(5.73));


        String mockJson = mapper.writeValueAsString(mockOutput);

        mockMvc.perform(get("/invoice/1")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(mockJson));
    }

    @Test
    public void createInvoice() throws Exception{

        Invoice createInput= new Invoice();
        createInput.setName("Joe");
        createInput.setStreet("These Streets");
        createInput.setCity("This City");
        createInput.setState("FL");
        createInput.setZipcode("66666");
        createInput.setItemType("game");
        createInput.setItemId(1L);
        createInput.setQuantity(2);

        String mockInputJson = mapper.writeValueAsString(createInput);

        Invoice createOutput = new Invoice();
        createOutput.setInvoice_id(1L);
        createOutput.setName("Joe");
        createOutput.setStreet("These Streets");
        createOutput.setCity("This City");
        createOutput.setState("FL");
        createOutput.setZipcode("66666");
        createOutput.setItemType("game");
        createOutput.setItemId(1L);
        createOutput.setUnit_price(BigDecimal.valueOf(2.00));
        createOutput.setQuantity(2);
        createOutput.setSubtotal(BigDecimal.valueOf(4.00));
        createOutput.setTax(BigDecimal.valueOf(0.24));
        createOutput.setProcessing_fee(BigDecimal.valueOf(1.49));
        createOutput.setTotal(BigDecimal.valueOf(5.73));

        String mockOutputJson = mapper.writeValueAsString(createOutput);

        mockMvc.perform(post("/invoice")
                        .content(mockInputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(mockOutputJson));
    }

    @Test
    public void updateInvoice() throws Exception{

        Invoice updateInput = new Invoice();
        updateInput.setInvoice_id(1L);
        updateInput.setName("John");
        updateInput.setStreet("Those Streets");
        updateInput.setCity("That City");
        updateInput.setState("CA");
        updateInput.setZipcode("77777");
        updateInput.setItemType("console");
        updateInput.setItemId(1L);
        updateInput.setUnit_price(BigDecimal.valueOf(2.00));
        updateInput.setQuantity(2);
        updateInput.setSubtotal(BigDecimal.valueOf(4.00));
        updateInput.setTax(BigDecimal.valueOf(0.24));
        updateInput.setProcessing_fee(BigDecimal.valueOf(1.49));
        updateInput.setTotal(BigDecimal.valueOf(5.73));

        String mockUpdateJson = mapper.writeValueAsString(updateInput);

        mockMvc.perform(
                        put("/invoice/1")
                                .content(mockUpdateJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void deleteInvoice() throws Exception{

        mockMvc.perform(delete("/invoice/1"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}