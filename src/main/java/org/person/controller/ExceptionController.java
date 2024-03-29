package org.person.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ExceptionController {
  @ExceptionHandler
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public void handle(Exception e) throws Exception {
    log.warn("Returning HTTP 400 Bad Request", e);
    throw e;
  }
}
