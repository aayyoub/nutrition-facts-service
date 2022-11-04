package io.nutritionfacts.service.exception;

import org.springframework.http.HttpStatus;

public class FoodNotFoundException extends RuntimeException {
    public FoodNotFoundException(String message) {
        super(message);
    }

    public ErrorMessageCode getErrorMessageCode() {
        return ErrorMessageCode.FOOD_NOT_FOUND;
    }

    public HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
