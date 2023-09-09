package com.pansobao.ms.kafka.one.application.port.in;

import com.pansobao.ms.kafka.one.domain.Pokemon;

public interface CreatePokemon {
    Integer createPokemon(Pokemon pokemon);
}
