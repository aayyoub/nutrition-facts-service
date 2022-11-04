package io.nutritionfacts.service.exception;

import org.springframework.http.HttpStatus;

public class InvalidServingSizeException extends RuntimeException {
    public InvalidServingSizeException(String message) {
        super(message);
    }

    public ErrorMessageCode getErrorMessageCode() {
        return ErrorMessageCode.INVALID_SERVING_SIZE;
    }

    public HttpStatus getHttpStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
