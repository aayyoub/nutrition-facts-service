package io.nutritionfacts.api.dataaccess.elasticsearch.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "search", type = "search_term")
public class SearchTermEntity {
    @Id
    private String id;
    private String searchTerm;

    public SearchTermEntity() {
    }

    public SearchTermEntity(String id, String searchTerm) {
        this.id = id;
        this.searchTerm = searchTerm;
    }
}