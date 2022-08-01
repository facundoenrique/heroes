package com.example.heroes.adapters.inbound.api.controller;

import com.example.heroes.adapters.inbound.api.request.HeroRequest;
import com.example.heroes.adapters.inbound.api.request.HeroUpdateRequest;
import com.example.heroes.domain.model.Hero;
import com.example.heroes.domain.service.HeroesService;
import com.example.heroes.utils.Mocks;
import com.example.heroes.utils.TestUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import java.util.List;

import static org.mockito.ArgumentMatchers.*;

@ExtendWith(MockitoExtension.class)
public class HeroesControllerTest  {

    private final String PATH = "/heroes";
    private MockMvc mockMvc;

    @Mock
    private HeroesService heroesService;

    @InjectMocks
    private HeroesController heroesController;

    @BeforeEach
    void setUp(){
        mockMvc = MockMvcBuilders
                .standaloneSetup(heroesController)
                .alwaysDo(MockMvcResultHandlers.print())
                .build();
    }


    @Test
    void save() throws Exception {
        //Mocks
        HeroRequest heroRequestMock = Mocks.getHeroRequest();
        Hero heroMock = Mocks.getHero();

        //given
        BDDMockito.given(heroesService.save(any(Hero.class)))
                .willReturn(ResponseEntity.ok(heroMock));

        //when
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post(PATH)
                .content(TestUtil.toJson(heroRequestMock))
                .contentType(MediaType.APPLICATION_JSON));

        // Then
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
        resultActions.andExpect(MockMvcResultMatchers.jsonPath("name").exists());
        resultActions.andExpect(MockMvcResultMatchers.jsonPath("id").exists());
    }

    @Test
    void findByName() throws Exception {
        //mocks
        Hero heroMock = Mocks.getHero();

        //given
        BDDMockito.given(heroesService.findByName(anyString()))
                .willReturn(ResponseEntity.ok(List.of(heroMock)));

        //when
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get(PATH + "/")
                .queryParam("value", "man")
                .contentType(MediaType.APPLICATION_JSON));

        // Then
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
        resultActions.andExpect(MockMvcResultMatchers.jsonPath("[0].name").exists());
        resultActions.andExpect(MockMvcResultMatchers.jsonPath("[0].id").exists());

    }

    @Test
    void findById() throws Exception {
        //mocks
        Hero heroMock = Mocks.getHero();

        //given
        BDDMockito.given(heroesService.findById(anyLong()))
                .willReturn(ResponseEntity.ok(heroMock));


        //when
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get(PATH+"/{id}",1l)
                .contentType(MediaType.APPLICATION_JSON));

        // Then
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
        resultActions.andExpect(MockMvcResultMatchers.jsonPath("id").exists());
        resultActions.andExpect(MockMvcResultMatchers.jsonPath("name").exists());
    }

    @Test
    void update() throws Exception {
        //Mocks
        HeroUpdateRequest heroRequestMock = Mocks.getHeroUpdateRequest();
        Hero heroMock = Mocks.getHero();

        //given
        BDDMockito.given(heroesService.update(any(Hero.class)))
                .willReturn(ResponseEntity.ok(heroMock));

        //when
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.put(PATH)
                .content(TestUtil.toJson(heroRequestMock))
                .contentType(MediaType.APPLICATION_JSON));

        // Then
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
        resultActions.andExpect(MockMvcResultMatchers.jsonPath("name").exists());
        resultActions.andExpect(MockMvcResultMatchers.jsonPath("id").exists());
    }
}
