package com.example.heroes.adapters.inbound.api.request;

import com.example.heroes.domain.model.Hero;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class HeroRequest {
    private String name;

    public Hero toDomain(){
        return Hero.builder()
                .name(name)
                .build();
    }
}

