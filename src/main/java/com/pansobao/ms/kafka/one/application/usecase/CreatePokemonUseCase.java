package com.pansobao.ms.kafka.one.application.usecase;

import com.pansobao.ms.kafka.one.domain.Pokemon;
import com.pansobao.ms.kafka.one.application.port.in.CreatePokemon;
import com.pansobao.ms.kafka.one.application.port.out.PokemonJDBCRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class CreatePokemonUseCase implements CreatePokemon {
    private final PokemonJDBCRepository pokemonJDBCRepository;
    @Override
    public Integer createPokemon(Pokemon pokemon) {
        return pokemonJDBCRepository.createPokemon(pokemon);
    }
}
