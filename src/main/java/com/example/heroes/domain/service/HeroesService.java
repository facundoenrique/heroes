package com.example.heroes.domain.service;

import com.example.heroes.domain.model.Hero;
import com.example.heroes.domain.repository.HeroesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

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
        return ResponseEntity.ok(heroesRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND)));
    }


    public ResponseEntity update(Hero hero) {
        return new ResponseEntity(heroesRepository.save(hero), HttpStatus.OK);
    }
}
