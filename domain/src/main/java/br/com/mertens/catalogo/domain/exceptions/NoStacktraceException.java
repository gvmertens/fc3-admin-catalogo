package br.com.mertens.catalogo.domain.exceptions;

public class NoStacktraceException extends RuntimeException{

    public NoStacktraceException(final String message) {
        this(message, null);
    }

    public NoStacktraceException(String message, Throwable cause) {
        super(message, cause, true, false);
    }
}
