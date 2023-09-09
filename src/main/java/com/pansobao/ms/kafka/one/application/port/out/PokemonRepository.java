package com.pansobao.ms.kafka.one.application.port.out;

import com.pansobao.ms.kafka.one.domain.Pokemon;

public interface PokemonRepository {
Pokemon getPokemon(String name);

}
