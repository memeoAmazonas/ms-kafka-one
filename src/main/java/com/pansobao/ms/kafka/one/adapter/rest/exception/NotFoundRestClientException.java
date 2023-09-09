package com.pansobao.ms.kafka.one.adapter.rest.exception;

import com.pansobao.ms.kafka.one.config.ErrorCode;
import com.pansobao.ms.kafka.one.config.exception.GenericException;

public class NotFoundRestClientException extends GenericException {
    public NotFoundRestClientException(ErrorCode errorCode) {
        super(errorCode);
    }
}
