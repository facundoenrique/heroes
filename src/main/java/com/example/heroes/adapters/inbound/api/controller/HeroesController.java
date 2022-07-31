package com.example.heroes.adapters.inbound.api.controller;

import com.example.heroes.adapters.inbound.api.request.HeroRequest;
import com.example.heroes.domain.model.Hero;
import com.example.heroes.domain.service.HeroesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("heroes")
@RequiredArgsConstructor
@Validated
public class HeroesController implements HeroesControllerDoc {

    private final HeroesService heroesService;
    @Override
    @PostMapping
    public ResponseEntity save(@RequestBody @NotNull @Valid HeroRequest hero) {
        return heroesService.save(hero.toDomain());
    }

    @Override
    @GetMapping
    public ResponseEntity findByName(@RequestParam(required = false) String value) {
        return heroesService.findByName(value);
    }

    @Override
    @GetMapping
    public ResponseEntity findById(@PathVariable @NotNull Long id) {
        return heroesService.findById(id);
    }

    @Override
    @PutMapping
    public ResponseEntity update(@RequestBody @NotNull @Valid HeroRequest hero) {
        return heroesService.update(hero.toDomain());
    }
}
