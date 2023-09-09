package com.pansobao.ms.kafka.one.adapter.rest.exception;

import com.pansobao.ms.kafka.one.config.ErrorCode;
import com.pansobao.ms.kafka.one.config.exception.GenericException;

public class NonTargetRestClientException extends GenericException {
    public NonTargetRestClientException(ErrorCode errorCode) {
        super(errorCode);
    }
}
