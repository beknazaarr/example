package org.example.backendjava.auth_service.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.Map;

import static org.example.backendjava.auth_service.util.ErrorResponseUtil.createErrorResponse;

/**
 * Глобальный обработчик для ненайденных URL и ресурсов.
 * Обрабатывает 404 ошибки с единым форматом ответа.
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * Обрабатывает запросы к несуществующим эндпоинтам.
     * Срабатывает когда Spring не находит подходящий контроллер.
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Map<String, Object>> handleNoHandlerFound(NoHandlerFoundException ex) {
        log.warn("No handler found for {} {}", ex.getHttpMethod(), ex.getRequestURL());

        Map<String, Object> response = createErrorResponse(
                HttpStatus.NOT_FOUND,
                "Endpoint not found: " + ex.getHttpMethod() + " " + ex.getRequestURL()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    /**
     * Обрабатывает запросы к несуществующим статичным ресурсам.
     * Используется в Spring Boot 3.x вместо NoHandlerFoundException для ресурсов.
     */
    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<Map<String, Object>> handleNoResourceFound(NoResourceFoundException ex) {
        log.warn("No resource found: {}", ex.getResourcePath());

        Map<String, Object> response = createErrorResponse(
                HttpStatus.NOT_FOUND,
                "Resource not found: " + ex.getResourcePath()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}