package br.ifmg.produto1_2026.resources.exception;

import br.ifmg.produto1_2026.service.exception.ResourceNotFound;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandier {
    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<StandartError>  entityNotFound(ResourceNotFound exception, HttpServletRequest request){
          StandartError error = new StandartError();
          error.setStatus(HttpStatus.NOT_FOUND.value());
          error.setMessage(exception.getMessage());
          error.setError("Resource Not Found");
          error.setTimestamp(Instant.now());
          error.setPath(request.getRequestURI());

          return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

}
