package com.voghbum.androidaudiobookprojectbackend.data.util;

public class RepositoryException extends RuntimeException {
    public RepositoryException() {
        this((String)null);
    }

    public RepositoryException(String message) {
        this(message, (Throwable)null);
    }

    public RepositoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public String getMessage() {
        Throwable cause = this.getCause();
        return String.format("{message : %s%s}", super.getMessage(), cause != null ? ", causeMessage : " + cause.getMessage() : "");
    }
}