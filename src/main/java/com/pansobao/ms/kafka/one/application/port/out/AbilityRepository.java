package com.pansobao.ms.kafka.one.application.port.out;

import com.pansobao.ms.kafka.one.domain.Ability;

public interface AbilityRepository {
    Ability getAbility(String name);
}
