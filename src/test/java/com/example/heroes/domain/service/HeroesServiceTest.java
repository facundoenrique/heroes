package com.example.heroes.domain.service;

import com.example.heroes.adapters.outbound.repository.HeroesRepositoryImpl;
import com.example.heroes.domain.model.Hero;
import com.example.heroes.utils.Mocks;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;

@ExtendWith(MockitoExtension.class)
public class HeroesServiceTest {
    @Mock
    private HeroesRepositoryImpl heroesRepository;

    @InjectMocks
    private HeroesService heroesService;

    @Test
    void save(){
        //mocks
        Hero heroMock = Mocks.getHero();
        //given
        BDDMockito.given(heroesRepository.save(any(Hero.class)))
                .willReturn(heroMock);
        //when
        var result = heroesService.save(heroMock);

        //then
        BDDAssertions.then(result.getStatusCode().is2xxSuccessful()).isTrue();
        BDDAssertions.then(((Hero)result.getBody()).getId()).isEqualTo(heroMock.getId());
        BDDAssertions.then(((Hero)result.getBody()).getName()).isEqualTo(heroMock.getName());

    }

    @Test
    void findAll(){
        Hero heroMock = Mocks.getHero();

        //given
        BDDMockito.given(heroesRepository.findAll())
                .willReturn(List.of(heroMock));
        //when
        var result = heroesService.findByName("man");

        //then
        BDDAssertions.then(result.getStatusCode().is2xxSuccessful()).isTrue();
        BDDAssertions.then(((List<Hero>)result.getBody()).get(0).getId()).isEqualTo(heroMock.getId());
        BDDAssertions.then(((List<Hero>)result.getBody()).get(0).getName()).isEqualTo(heroMock.getName());
    }

    @Test
    void findByName(){
        Hero heroMock = Mocks.getHero();

        //given
        BDDMockito.given(heroesRepository.findByName(anyString()))
                .willReturn(List.of(heroMock));
        //when
        var result = heroesService.findByName("man");

        //then
        BDDAssertions.then(result.getStatusCode().is2xxSuccessful()).isTrue();
        BDDAssertions.then(((List<Hero>)result.getBody()).get(0).getId()).isEqualTo(heroMock.getId());
        BDDAssertions.then(((List<Hero>)result.getBody()).get(0).getName()).isEqualTo(heroMock.getName());
    }

    @Test
    void findById(){
        Hero heroMock = Mocks.getHero();

        //given
        BDDMockito.given(heroesRepository.findById(anyLong()))
                .willReturn(Optional.of(heroMock));
        //when
        var result = heroesService.findById(1l);

        //then
        BDDAssertions.then(result.getStatusCode().is2xxSuccessful()).isTrue();
        BDDAssertions.then(((Hero)result.getBody()).getId()).isEqualTo(heroMock.getId());
        BDDAssertions.then(((Hero)result.getBody()).getName()).isEqualTo(heroMock.getName());
    }

    @Test
    void update(){
        //mocks
        Hero heroMock = Mocks.getHero();

        //given
        BDDMockito.given(heroesRepository.save(any(Hero.class)))
                .willReturn(heroMock);
        //when
        var result = heroesService.save(heroMock);

        //then
        BDDAssertions.then(result.getStatusCode().is2xxSuccessful()).isTrue();
        BDDAssertions.then(((Hero)result.getBody()).getId()).isEqualTo(heroMock.getId());
        BDDAssertions.then(((Hero)result.getBody()).getName()).isEqualTo(heroMock.getName());

    }
}
