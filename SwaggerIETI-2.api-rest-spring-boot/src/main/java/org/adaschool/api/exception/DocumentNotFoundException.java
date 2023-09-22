package org.adaschool.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class DocumentNotFoundException extends ResponseStatusException{
    public DocumentNotFoundException(String id) {
        super(HttpStatus.NOT_FOUND, "document with ID: " + id + " not found");
    }
}
