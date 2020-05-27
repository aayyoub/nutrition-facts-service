package io.nutritionfacts.api.api.exceptionhandler;

import io.nutritionfacts.api.api.model.Response;
import io.nutritionfacts.api.api.filter.RequestContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
    private final RequestContext requestContext;

    public ControllerExceptionHandler(RequestContext requestContext) {
        this.requestContext = requestContext;
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Response> exceptionHandler(Exception exception) {
        Response response = new Response();
        response.setRequestId(requestContext.getRequestId());
        response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
