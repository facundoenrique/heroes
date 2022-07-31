package com.example.heroes.utils;

import com.example.heroes.adapters.inbound.api.request.HeroRequest;
import com.example.heroes.domain.model.Hero;


public class Mocks {
    public static HeroRequest getHeroRequest(){
        return HeroRequest.builder()
                .name("superman")
                .build();
    }

    public static Hero getHero(){
        return Hero.builder()
                .id(1l)
                .name("supermeman")
                .build();
    }

}
