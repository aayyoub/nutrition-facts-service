package io.nutritionfacts.service.api.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class SearchTermRequest {
    @NotEmpty
    @Size(min = 1, max = 200)
    private String searchTerm;
}
