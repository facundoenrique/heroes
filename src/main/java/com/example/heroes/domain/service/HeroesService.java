package com.example.heroes.domain.service;

import com.example.heroes.domain.model.Hero;
import com.example.heroes.domain.repository.HeroesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

@Service
@RequiredArgsConstructor
public class HeroesService {

    private final HeroesRepository heroesRepository;

    public ResponseEntity save(Hero hero){
        return new ResponseEntity(heroesRepository.save(hero), HttpStatus.CREATED);
    }

    public ResponseEntity findByName(String value) {
        if (StringUtils.isEmpty(value)){
            return new ResponseEntity(heroesRepository.findAll(),HttpStatus.OK);
        } else {
            return new ResponseEntity(heroesRepository.findByName(value),HttpStatus.OK);
        }
    }

    public ResponseEntity findById(Long id) {
        return ResponseEntity.ok(heroesRepository.findById(id));
    }


    public ResponseEntity update(Hero hero) {
        return new ResponseEntity(heroesRepository.save(hero), HttpStatus.OK);
    }
}
