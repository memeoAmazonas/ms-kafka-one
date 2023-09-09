package com.pansobao.ms.kafka.one.application.port.out;

import com.pansobao.ms.kafka.one.domain.Type;

public interface TypeRepository {
    Type getType(String name);
}
