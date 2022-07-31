package com.example.heroes.adapters.outbound.repository;

import com.example.heroes.domain.model.Hero;
import com.example.heroes.domain.repository.HeroesRepository;
import com.example.heroes.utils.Mocks;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;

@ExtendWith(MockitoExtension.class)
public class HeroesRepositoryImplTest {

    @Mock
    private HeroesRepositoryH2 heroesRepositoryH2;

    @InjectMocks
    private HeroesRepository heroesRepository;

    @Test
    void save(){

        //mock
        Hero heroMock = Mocks.getHero();

        //given
        BDDMockito.given(heroesRepositoryH2.save(any(Hero.class)))
                .willReturn(heroMock);

        heroMock.setId(null);
        //when
        var result = heroesRepository.save(heroMock);

        //then
        BDDAssertions.then(result).isNotNull();
        BDDAssertions.then(result.getId()).isEqualTo(1l);
        BDDAssertions.then(result.getName()).isEqualTo(heroMock.getName());
    }

    @Test
    void findAll(){
        //mock
        Hero heroMock = Mocks.getHero();

        //given
        BDDMockito.given(heroesRepositoryH2.findAll())
                .willReturn(List.of(heroMock));

        //when
        List<Hero> result = heroesRepository.findAll("man");

        //then
        //then
        BDDAssertions.then(result).isNotNull();
        BDDAssertions.then(result.get(0).getId()).isEqualTo(1l);
        BDDAssertions.then(result.get(0).getName()).isEqualTo(heroMock.getName());
    }
    @Test
    void findByName(){
        //mock
        Hero heroMock = Mocks.getHero();

        //given
        BDDMockito.given(heroesRepositoryH2.findByName(anyString()))
                .willReturn(List.of(heroMock));

        //when
        List<Hero> result = heroesRepository.findByName("man");

        //then
        //then
        BDDAssertions.then(result).isNotNull();
        BDDAssertions.then(result.get(0).getId()).isEqualTo(1l);
        BDDAssertions.then(result.get(0).getName()).isEqualTo(heroMock.getName());
    }

    @Test
    void findById(){
        //mock
        Hero heroMock = Mocks.getHero();

        //given
        BDDMockito.given(heroesRepositoryH2.findById(anyLong()))
                .willReturn(Optional.of(heroMock));

        //when
        var result = heroesRepository.findById(1l);

        //then
        BDDAssertions.then(result).isNotNull();
        BDDAssertions.then(result.getId()).isEqualTo(1l);
        BDDAssertions.then(result.getName()).isEqualTo(heroMock.getName());


    }

    @Test
    void update(){
//mock
        Hero heroMock = Mocks.getHero();

        //given
        BDDMockito.given(heroesRepositoryH2.save(any(Hero.class)))
                .willReturn(heroMock);

        //when
        var result = heroesRepository.update(heroMock);

        //then
        BDDAssertions.then(result).isNotNull();
        BDDAssertions.then(result.getId()).isEqualTo(1l);
        BDDAssertions.then(result.getName()).isEqualTo(heroMock.getName());
    }

}
