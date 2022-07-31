package com.example.heroes.domain.repository;

import com.example.heroes.adapters.inbound.api.request.HeroRequest;
import com.example.heroes.domain.model.Hero;


import java.util.List;

public interface HeroesRepository {
    Hero save(Hero hero);

    List<Hero> findByName(String value);

    Hero findById(Long id);

    Hero update(Hero hero);
}
