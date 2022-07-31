package com.example.heroes.adapters.outbound.repository;

import com.example.heroes.adapters.inbound.api.request.HeroRequest;
import com.example.heroes.domain.model.Hero;
import com.example.heroes.domain.repository.HeroesRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HeroesRepositoryImpl implements HeroesRepository {
    @Override
    public Hero save(Hero heroRequest) {
        return null;
    }

    @Override
    public List<Hero> findByName(String value) {
        return null;
    }

    @Override
    public Hero findById(Long id) {
        return null;
    }

    @Override
    public Hero update(Hero hero) {
        return null;
    }
}
