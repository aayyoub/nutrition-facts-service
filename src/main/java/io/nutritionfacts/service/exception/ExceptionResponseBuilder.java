package io.nutritionfacts.service.exception;

import io.nutritionfacts.service.api.model.Response;
import io.nutritionfacts.service.util.Translator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ExceptionResponseBuilder {
    private final Translator translator;

    public ExceptionResponseBuilder(Translator translator) {
        this.translator = translator;
    }

    public ResponseEntity<Object> buildResponse(HttpStatus httpStatus, ErrorMessageCode errorMessageCode) {
        Response response = new Response();
        response.setHttpStatus(httpStatus);
        response.setResponseMessage(translator.getMessage(errorMessageCode.getValue()));

        return new ResponseEntity<>(response, httpStatus);
    }
}
