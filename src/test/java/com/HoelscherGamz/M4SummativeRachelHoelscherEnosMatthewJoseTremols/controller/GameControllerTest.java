package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.controller;

import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model.Console;
import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model.Game;
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
@WebMvcTest(GameController.class)
public class GameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @MockBean
    private ServiceLayer serviceLayer;

    @Before
    public void setUp() {

        //GET by id mock
        Game mockOutput = new Game();
        mockOutput.setGame_id(3L);
        mockOutput.setTitle("Doom");
        mockOutput.setEsrbRating("Mature");
        mockOutput.setDescription("1993 first-person shooter (FPS) game developed by id Software for MS-DOS");
        mockOutput.setPrice(new BigDecimal("49.99"));
        mockOutput.setStudio("Bethesda");
        mockOutput.setQuantity(1);

        doReturn(mockOutput).when(serviceLayer).findGame(3L);

        //POST mock
        Game createInput = new Game();
//        createInput.setGame_id(3L);
        createInput.setTitle("Borderlands");
        createInput.setEsrbRating("Mature");
        createInput.setDescription("sci-fi first-person shooter in which players assume the roles of mercenary treasure hunters");
        createInput.setPrice(new BigDecimal("59.99"));
        createInput.setStudio("2kGames");
        createInput.setQuantity(2);

        Game createOutput = new Game();
        createOutput.setGame_id(3L);
        createOutput.setTitle("Borderlands");
        createOutput.setEsrbRating("Mature");
        createOutput.setDescription("sci-fi first-person shooter in which players assume the roles of mercenary treasure hunters");
        createOutput.setPrice(new BigDecimal("59.99"));
        createOutput.setStudio("2kGames");
        createOutput.setQuantity(2);

        doReturn(createOutput).when(serviceLayer).saveGame(createInput);

        //GET all mock
        List<Game> gameList = Arrays.asList(mockOutput, createOutput, createInput);

        doReturn(gameList).when(serviceLayer).findAllGame(null, null, null);




    }


    @Test
    public void getAllGames() throws Exception {

        mockMvc.perform(get("/game"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]").isNotEmpty());
    }

    @Test
    public void getGameById() throws Exception{

        Game mockOutput = new Game();
        mockOutput.setGame_id(3L);
        mockOutput.setTitle("Doom");
        mockOutput.setEsrbRating("Mature");
        mockOutput.setDescription("1993 first-person shooter (FPS) game developed by id Software for MS-DOS");
        mockOutput.setPrice(new BigDecimal("49.99"));
        mockOutput.setStudio("Bethesda");
        mockOutput.setQuantity(1);

        String mockJson = mapper.writeValueAsString(mockOutput);

        mockMvc.perform(get("/game/3")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(mockJson));
    }

    @Test
    public void createGame() throws Exception {

        Game createInput = new Game();
//        createInput.setGame_id(3L);
        createInput.setTitle("Borderlands");
        createInput.setEsrbRating("Mature");
        createInput.setDescription("sci-fi first-person shooter in which players assume the roles of mercenary treasure hunters");
        createInput.setPrice(new BigDecimal("59.99"));
        createInput.setStudio("2kGames");
        createInput.setQuantity(2);

        String mockInputJson = mapper.writeValueAsString(createInput);

        Game createOutput = new Game();
        createOutput.setGame_id(3L);
        createOutput.setTitle("Borderlands");
        createOutput.setEsrbRating("Mature");
        createOutput.setDescription("sci-fi first-person shooter in which players assume the roles of mercenary treasure hunters");
        createOutput.setPrice(new BigDecimal("59.99"));
        createOutput.setStudio("2kGames");
        createOutput.setQuantity(2);

        String mockOutputJson = mapper.writeValueAsString(createOutput);

        mockMvc.perform(post("/game")
                        .content(mockInputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(mockOutputJson));

    }

    @Test
    public void updateGame() throws Exception {
        Game updateOutput = new Game();
        updateOutput.setGame_id(8L);
        updateOutput.setTitle("Stardew Valley");
        updateOutput.setEsrbRating("Everyone");
        updateOutput.setDescription("role-playing game in which players move to the country after inheriting a farm");
        updateOutput.setPrice(new BigDecimal("29.99"));
        updateOutput.setStudio("Chucklefish Limited");
        updateOutput.setQuantity(6);

        String mockUpdateJson = mapper.writeValueAsString(updateOutput);

        mockMvc.perform(
                        put("/game/8")
                                .content(mockUpdateJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void deleteGame()  throws Exception {

        mockMvc.perform(delete("/game/8"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}