package com.pansobao.ms.kafka.one.adapter.rest.pokemon;

import com.pansobao.ms.kafka.one.config.ErrorCode;
import com.pansobao.ms.kafka.one.config.property.PokemonProperty;
import com.pansobao.ms.kafka.one.domain.Pokemon;
import com.pansobao.ms.kafka.one.adapter.rest.exception.BadRequestRestClientException;
import com.pansobao.ms.kafka.one.adapter.rest.exception.EmptyOrNullBodyRestClientException;
import com.pansobao.ms.kafka.one.adapter.rest.exception.NotFoundRestClientException;
import com.pansobao.ms.kafka.one.adapter.rest.exception.TimeoutRestClientException;
import com.pansobao.ms.kafka.one.adapter.rest.handler.RestTemplateErrorHandler;
import com.pansobao.ms.kafka.one.adapter.rest.pokemon.model.pokemon.PokemonModel;
import com.pansobao.ms.kafka.one.application.port.out.PokemonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Optional;

@Slf4j
@Repository
public class PokemonRestClientAdapter implements PokemonRepository {
private final PokemonProperty property;
private final RestTemplate restTemplate;
    public PokemonRestClientAdapter(PokemonProperty property, RestTemplate restTemplate) {
        this.property = property;
        this.restTemplate = restTemplate;
        var errorHandler = new RestTemplateErrorHandler(
                Map.of(
                        HttpStatus.NOT_FOUND, new NotFoundRestClientException(ErrorCode.POKEMON_NOT_FOUND),
                        HttpStatus.REQUEST_TIMEOUT, new TimeoutRestClientException(ErrorCode.POKEMON_TIMEOUT),
                        HttpStatus.BAD_REQUEST, new BadRequestRestClientException(ErrorCode.POKEMON_BAD_REQUEST)
                )
        );
        this.restTemplate.setErrorHandler(errorHandler);
    }

    @Override
    public Pokemon getPokemon(String name) {
    log.info("Servicio obtener pokemon, buscar: [{}]" ,property.getUrl(property.getUrlName(), name));
    log.debug("este mensaje no debe aparece en el modo develop");
        PokemonModel response = Optional.ofNullable(restTemplate.getForObject(property.getUrl(property.getUrlName(), name),PokemonModel.class,name))
                .orElseThrow(()-> new EmptyOrNullBodyRestClientException(ErrorCode.POKEMON_NOT_FOUND));
        log.info("Respuesta obtenida desde el servicio obtener pokemon data: [{}]", response);
        return response.toPokemonDomain();
    }
}
