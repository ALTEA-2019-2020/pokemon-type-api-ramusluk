package com.miage.altea.tp.pokemon_type_api.service;

import com.miage.altea.tp.pokemon_type_api.bo.PokemonType;
import com.miage.altea.tp.pokemon_type_api.repository.PokemonTypeRepository;
import com.miage.altea.tp.pokemon_type_api.repository.PokemonTypeRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PokemonTypeServiceImpl implements PokemonTypeService{

    public PokemonTypeRepository pokemonTypeRepository;

    @Autowired
    public PokemonTypeServiceImpl(PokemonTypeRepository pokemonTypeRepository){
        this.pokemonTypeRepository = pokemonTypeRepository;
    }

    @Override
    public PokemonType getPokemonType(int id) {
        return this.pokemonTypeRepository.findPokemonTypeById(id);
    }

    @Override
    public List<PokemonType> getAllPokemonTypes(){
        return this.pokemonTypeRepository.findAllPokemonType();
    }

    @Override
    public PokemonType getPokemonTypeFromName(String name) {
        return this.pokemonTypeRepository.findPokemonTypeByName(name);
    }

    @Override
    public List<PokemonType> getPokemonTypeFromType(List<String> list) {
        return this.pokemonTypeRepository.findPokemonTypeByType(list);
    }
}
