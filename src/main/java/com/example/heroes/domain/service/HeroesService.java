package com.example.heroes.domain.service;

import com.example.heroes.domain.model.Hero;
import com.example.heroes.domain.repository.HeroesRepository;
import io.swagger.models.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class HeroesService {

    private final HeroesRepository heroesRepository;

    public ResponseEntity save(Hero hero){
        return new ResponseEntity(heroesRepository.save(hero), HttpStatus.CREATED);
    }

    public ResponseEntity findByName(String value) {
        if (StringUtils.isBlank(value)){
            return new ResponseEntity(heroesRepository.findAll(),HttpStatus.OK);
        } else {
            return new ResponseEntity(heroesRepository.findByName(value),HttpStatus.OK);
        }
    }

    public ResponseEntity findById(Long id) {
        Optional<Hero> hero = heroesRepository.findById(id);
        if (hero.isPresent()){
            return ResponseEntity.ok(hero.get());
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }


    public ResponseEntity update(Hero hero) {
        return new ResponseEntity(heroesRepository.update(hero), HttpStatus.OK);
    }
}
