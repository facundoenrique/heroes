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
public class HeroesController {

    private final HeroesService heroesService;

    @PostMapping
    public ResponseEntity save(@RequestBody @NotNull @Valid HeroRequest hero) {
        return heroesService.save(hero.toDomain());
    }

    @GetMapping
    public ResponseEntity findByName(@RequestParam(required = false) String value) {
        return heroesService.findByName(value);
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable @NotNull Long id) {
        return heroesService.findById(id);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody @NotNull @Valid HeroRequest hero) {
        return heroesService.update(hero.toDomain());
    }
}
