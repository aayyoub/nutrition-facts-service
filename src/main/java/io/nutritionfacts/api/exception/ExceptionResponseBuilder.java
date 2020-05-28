package io.nutritionfacts.api.exception;

import io.nutritionfacts.api.api.filter.RequestContext;
import io.nutritionfacts.api.api.model.Response;
import io.nutritionfacts.api.util.Translator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ExceptionResponseBuilder {
    private final Translator translator;
    private final RequestContext requestContext;

    public ExceptionResponseBuilder(Translator translator, RequestContext requestContext) {
        this.translator = translator;
        this.requestContext = requestContext;
    }

    public ResponseEntity<Object> buildResponse(HttpStatus httpStatus, ErrorMessageCode errorMessageCode) {
        Response response = new Response();
        response.setRequestId(requestContext.getRequestId());
        response.setHttpStatus(httpStatus);
        response.setResponseMessage(translator.getMessage(errorMessageCode.getValue()));

        return new ResponseEntity<>(response, httpStatus);
    }
}
