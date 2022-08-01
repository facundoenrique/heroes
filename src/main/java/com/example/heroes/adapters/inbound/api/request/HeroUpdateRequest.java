package com.example.heroes.adapters.inbound.api.request;

import com.example.heroes.domain.model.Hero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HeroUpdateRequest {

    @NotNull
    @Positive
    private Long id;
    @NotEmpty
    private String name;

    public Hero toDomain(){
        return Hero.builder()
                .name(name)
                .id(id)
                .build();
    }
}

