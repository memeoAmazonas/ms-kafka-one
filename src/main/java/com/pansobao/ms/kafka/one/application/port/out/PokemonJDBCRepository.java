package com.pansobao.ms.kafka.one.application.port.out;

import com.pansobao.ms.kafka.one.domain.Pokemon;

public interface PokemonJDBCRepository {
    Integer createPokemon(Pokemon pokemon);
    Pokemon getPokemonByName(String name);
}
