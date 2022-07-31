package com.example.heroes.adapters.outbound.repository;

import com.example.heroes.domain.model.Hero;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface HeroesRepositoryH2 extends CrudRepository<Hero, Long> {
    List<Hero> findByNameContaining(String name);
}
