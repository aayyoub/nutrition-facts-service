package io.nutritionfacts.service.api.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class Request {
    @NotEmpty(message = "requestId is mandatory")
    @Size(min = 32, max = 36)
    private String requestId;

    @NotEmpty(message = "clientId is mandatory")
    @Size(min = 3, max = 12)
    private String clientId;
}
