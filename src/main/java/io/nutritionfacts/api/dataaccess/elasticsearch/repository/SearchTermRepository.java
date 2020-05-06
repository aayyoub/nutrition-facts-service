package io.nutritionfacts.api.dataaccess.elasticsearch.repository;

import io.nutritionfacts.api.dataaccess.elasticsearch.entity.SearchTermEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface SearchTermRepository extends ElasticsearchRepository<SearchTermEntity, String> {
    Page<SearchTermEntity> findTop25BySearchTerm(String searchTerm, Pageable pageable);
}