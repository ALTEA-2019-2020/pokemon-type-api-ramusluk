package com.miage.altea.tp.pokemon_type_api.service;

import com.miage.altea.tp.pokemon_type_api.bo.PokemonType;
import com.miage.altea.tp.pokemon_type_api.repository.PokemonTypeRepository;
import com.miage.altea.tp.pokemon_type_api.repository.PokemonTypeRepositoryImpl;
import com.miage.altea.tp.pokemon_type_api.repository.TranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

@Component
public class PokemonTypeServiceImpl implements PokemonTypeService{

    public PokemonTypeRepository pokemonTypeRepository;
    public TranslationRepository translationRepository;

    @Autowired
    public PokemonTypeServiceImpl(PokemonTypeRepository pokemonTypeRepository){
        this.pokemonTypeRepository = pokemonTypeRepository;
    }

    public PokemonTypeServiceImpl(){
    }



    @Override
    public PokemonType getPokemonType(int id) {
        PokemonType pokemonType = this.pokemonTypeRepository.findPokemonTypeById(id);
        pokemonType.setName(this.translationRepository.getPokemonName(id, LocaleContextHolder.getLocale()));
        return pokemonType;
    }

    @Override
    public ArrayList<PokemonType> getAllPokemonTypes(){
        //this.pokemonTypeRepository.findAllPokemonType();
        ArrayList<PokemonType> list = new ArrayList<>(this.pokemonTypeRepository.findAllPokemonType());
        for (PokemonType pokemonType : list ){
            pokemonType.setName(this.translationRepository.getPokemonName(pokemonType.getId(), LocaleContextHolder.getLocale()));
        }
        list.sort(Comparator.comparing(PokemonType::getId));
        return list;
    }

    @Override
    public PokemonType getPokemonTypeFromName(String name) {
        return this.pokemonTypeRepository.findPokemonTypeByName(name);
    }

    @Override
    public List<PokemonType> getPokemonTypeFromType(List<String> list) {
        return this.pokemonTypeRepository.findPokemonTypeByType(list);
    }


    public PokemonTypeRepository getPokemonTypeRepository() {
        return pokemonTypeRepository;
    }

    public void setPokemonTypeRepository(PokemonTypeRepository pokemonTypeRepository) {
        this.pokemonTypeRepository = pokemonTypeRepository;
    }

    public TranslationRepository getTranslationRepository() {
        return translationRepository;
    }

    @Autowired
    public void setTranslationRepository(TranslationRepository translationRepository) {
        this.translationRepository = translationRepository;
    }
}
