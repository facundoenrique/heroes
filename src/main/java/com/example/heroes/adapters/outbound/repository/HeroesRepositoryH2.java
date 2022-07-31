package com.example.heroes.adapters.outbound.repository;

import com.example.heroes.domain.model.Hero;
import org.springframework.data.repository.CrudRepository;


public interface HeroesRepositoryH2 extends CrudRepository<Hero, Long> {
}
