package com.pansobao.ms.kafka.one.adapter.jdbc.exception;

public class SqlReaderException extends RuntimeException {
    public SqlReaderException(String message) {
        super(message);
    }
    public SqlReaderException(Throwable cause) {
        super(cause);
    }
}
