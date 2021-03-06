package com.nbouraoui.entities;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.experimental.SuperBuilder;
@Data
@SuperBuilder
@JsonInclude
public class Response {
	protected LocalDateTime timeStamp;
    protected int statusCode;
    protected HttpStatus status;
    protected String reason;
    protected String message;
    protected String description;
    protected String developerMessage;
    protected Map<?, ?> data;

}
