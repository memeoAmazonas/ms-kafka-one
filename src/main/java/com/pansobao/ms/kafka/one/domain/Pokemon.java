package com.pansobao.ms.kafka.one.domain;

import lombok.Builder;
import lombok.Value;
import lombok.With;

import java.math.BigDecimal;

@Value
@Builder
@With
public class Pokemon {

    String name;
    Ability ability;
    Type type;
    BigDecimal health;

}
