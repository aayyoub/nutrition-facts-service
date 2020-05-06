package io.nutritionfacts.api.api.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class SearchTermRequest {
    @NotNull
    @Size(min = 1, max = 200)
    private String searchTerm;
}
