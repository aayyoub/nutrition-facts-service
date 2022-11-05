package io.nutritionfacts.service.api.model.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class SearchRequest {
    @NotEmpty
    @Size(min = 1, max = 200)
    private String searchTerm;
}
