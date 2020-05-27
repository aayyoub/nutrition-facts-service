package io.nutritionfacts.api.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Response<T> {
    private String requestId;
    private Integer statusCode;
    private String responseMessage;
    private T result;

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode.value();
        this.responseMessage = statusCode.getReasonPhrase();
    }
}
