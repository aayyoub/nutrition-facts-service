package io.nutritionfacts.service.dataaccess.elasticsearch.repository;

import io.nutritionfacts.service.dataaccess.elasticsearch.entity.SearchTermEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface SearchTermRepository extends ElasticsearchRepository<SearchTermEntity, String> {
    Page<SearchTermEntity> findTop35BySearchTerm(String searchTerm, Pageable pageable);
}
