package com.miage.altea.tp.pokemon_type_api.controller;

import com.miage.altea.tp.pokemon_type_api.bo.PokemonType;
import com.miage.altea.tp.pokemon_type_api.service.PokemonTypeService;
import com.miage.altea.tp.pokemon_type_api.service.PokemonTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pokemon-types")
public class PokemonTypeController {

    public PokemonTypeService pokemonTypeService;

    @Autowired
    public PokemonTypeController(PokemonTypeService pokemonTypeService) {
        this.pokemonTypeService = pokemonTypeService;
    }


    @GetMapping(value = "/{id}")
    public PokemonType getPokemonTypeFromId(@PathVariable(value = "id") int id){
        return this.pokemonTypeService.getPokemonType(id);
    }

    @GetMapping(value = "/")
    public List<PokemonType> getAllPokemonTypes() {
        return this.pokemonTypeService.getAllPokemonTypes();
    }

    @GetMapping(value = "/", params = "name")
    public PokemonType getPokemonTypeFromName(@RequestParam(value = "name") String name){
        return this.pokemonTypeService.getPokemonTypeFromName(name);
    }

    @GetMapping(value = "/", params = "types")
    public List<PokemonType> getPokemonTypeFromType(@RequestParam(value = "types") List<String> list){
        return this.pokemonTypeService.getPokemonTypeFromType(list);
    }



}
