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
public class Response {
    private HttpStatus httpStatus;
    private Integer responseCode;
    private String responseMessage;
    private Object result;

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        this.responseCode = httpStatus.value();
    }
}
