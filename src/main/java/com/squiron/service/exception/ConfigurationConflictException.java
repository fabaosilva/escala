package com.squiron.service.exception;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ConfigurationConflictException extends RuntimeException {

}
