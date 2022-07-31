package com.example.heroes.domain.repository;

import com.example.heroes.domain.model.Hero;


import java.util.List;
import java.util.Optional;

public interface HeroesRepository {
    Hero save(Hero hero);
    List<Hero> findAll();
    List<Hero> findByName(String value);
    Optional<Hero> findById(Long id);
    Hero update(Hero hero);
}
