package io.nutritionfacts.service.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {
    private Integer statusCode;
    private String statusMessage;
    private String responseMessage;
    private T result;

    public void setHttpStatus(HttpStatus statusCode) {
        this.statusCode = statusCode.value();
        this.statusMessage = statusCode.getReasonPhrase();
    }
}
