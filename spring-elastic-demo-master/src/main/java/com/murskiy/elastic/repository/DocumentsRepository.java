package com.murskiy.elastic.repository;

import com.murskiy.elastic.model.Documents;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface DocumentsRepository extends ElasticsearchRepository<Documents, Long>{
    List<Documents> findByName(String name);
    List<Documents> findByAuthor(String author);
    List<Documents> findById(Long id);
    List<Documents> findByTopic(String topic);
    void deleteById(Long id);
}