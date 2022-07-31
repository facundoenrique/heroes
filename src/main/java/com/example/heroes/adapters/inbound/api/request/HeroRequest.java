package com.example.heroes.adapters.inbound.api.request;

import com.example.heroes.domain.model.Hero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HeroRequest {
    private String name;

    public Hero toDomain(){
        return Hero.builder()
                .name(name)
                .build();
    }
}

