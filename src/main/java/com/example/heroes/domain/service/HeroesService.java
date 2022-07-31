package com.example.heroes.domain.service;

import com.example.heroes.adapters.inbound.api.request.HeroRequest;
import com.example.heroes.domain.model.Hero;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HeroesService {
    public ResponseEntity save(Hero hero){
        return null;
    }

    public ResponseEntity findByName(String value) {
        return null;
    }

    public ResponseEntity findById(Long id) {
        return null;
    }


    public ResponseEntity update(Hero hero) {
        return null;
    }
}
