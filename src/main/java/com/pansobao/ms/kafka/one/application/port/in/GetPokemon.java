package com.pansobao.ms.kafka.one.application.port.in;

import com.pansobao.ms.kafka.one.domain.Pokemon;

import java.util.concurrent.ExecutionException;

public interface GetPokemon {

    Pokemon getPokemon(String name) throws ExecutionException, InterruptedException;
    Pokemon getInternal(String name);


}
