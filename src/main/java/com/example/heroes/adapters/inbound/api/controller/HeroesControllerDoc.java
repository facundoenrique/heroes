package com.example.heroes.adapters.inbound.api.controller;

import com.example.heroes.adapters.inbound.api.request.HeroRequest;
import com.example.heroes.domain.model.Hero;
import com.example.heroes.utils.ApiDocConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Tag(name="Heroes")
@Validated
public interface HeroesControllerDoc {
    @Operation(summary = "Save message",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = { @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = HeroRequest.class),
                            examples = { @ExampleObject(value = ApiDocConstants.HERO_SAVE)})}))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok", content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
            @ApiResponse(responseCode = "409", description = "Conflict", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Error", content = @Content)
    })
    @PostMapping
    ResponseEntity save(
            @RequestBody @Valid HeroRequest hero);



    @Operation(summary = "get heroes",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = { @Content()}))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok", content = @Content),
            @ApiResponse(responseCode = "204", description = "No content", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Error", content = @Content)
    })
    @GetMapping
    ResponseEntity findByName(
            @RequestParam(required = false) @NotNull String value);



    @Operation(summary = "get hero by id",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = { @Content()}))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok", content = @Content),
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Error", content = @Content)
    })
    @GetMapping("{id}")
    ResponseEntity findById(
            @PathVariable Long id);


    @Operation(summary = "Save message",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = { @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = HeroRequest.class),
                            examples = { @ExampleObject(value = ApiDocConstants.HERO_UPDATE)})}))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok", content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Error", content = @Content)
    })
    @PutMapping
    ResponseEntity update(@RequestBody @Valid @NotNull HeroRequest hero);
}

