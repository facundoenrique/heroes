package com.example.heroes.adapters.outbound.repository;

import com.example.heroes.adapters.inbound.api.request.HeroRequest;
import com.example.heroes.domain.model.Hero;
import com.example.heroes.domain.repository.HeroesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
@RequiredArgsConstructor
public class HeroesRepositoryImpl implements HeroesRepository {

    private final HeroesRepositoryH2 heroesRepositoryH2;

    @Override
    public Hero save(Hero hero) {
        return heroesRepositoryH2.save(hero);
    }

    @Override
    public List<Hero> findAll() {
        return StreamSupport.stream(heroesRepositoryH2.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }

    @Override
    public List<Hero> findByName(String value) {
        return heroesRepositoryH2.findByNameContaining(value);
    }

    @Override
    public Optional<Hero> findById(Long id) {
        return heroesRepositoryH2.findById(id);
    }

    @Override
    public Hero update(Hero hero) {
        return heroesRepositoryH2.save(hero);
    }
}
