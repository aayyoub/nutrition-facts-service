package io.nutritionfacts.service.exception;

import io.nutritionfacts.service.exception.ErrorMessageCode;
import io.nutritionfacts.service.exception.ExceptionResponseBuilder;
import io.nutritionfacts.service.exception.FoodNotFoundException;
import io.nutritionfacts.service.exception.InvalidServingSizeException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(annotations = RestController.class)
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
    private final ExceptionResponseBuilder exceptionResponseBuilder;

    public ControllerExceptionHandler(ExceptionResponseBuilder exceptionResponseBuilder) {
        this.exceptionResponseBuilder = exceptionResponseBuilder;
    }

    @ExceptionHandler(FoodNotFoundException.class)
    public ResponseEntity<Object> handleFoodNotFoundException(FoodNotFoundException exception) {
        return exceptionResponseBuilder.buildResponse(exception.getHttpStatus(), exception.getErrorMessageCode());
    }

    @ExceptionHandler(InvalidServingSizeException.class)
    public ResponseEntity<Object> handleInvalidServingSizeException(InvalidServingSizeException exception) {
        return exceptionResponseBuilder.buildResponse(exception.getHttpStatus(), exception.getErrorMessageCode());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception exception) {
        return exceptionResponseBuilder.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, ErrorMessageCode.GENERAL_EXCEPTION);
    }

    @Override
    public ResponseEntity<Object> handleExceptionInternal(Exception exception, Object body, HttpHeaders httpHeaders, HttpStatus httpStatus, WebRequest webRequest) {
        return exceptionResponseBuilder.buildResponse(httpStatus, ErrorMessageCode.VALIDATION_EXCEPTION);
    }
}
