package com.murskiy.elastic.resource;

import com.murskiy.elastic.builder.SearchQueryBuilder;
import com.murskiy.elastic.model.Documents;
import com.murskiy.elastic.repository.DocumentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest/search")
public class SearchResource {

    @Autowired
    DocumentsRepository documentsRepository;

    @Autowired
    private SearchQueryBuilder searchQueryBuilder;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @GetMapping(value = "/name/{name}")
    public List<Documents> searchName(@PathVariable final String name) {
        return documentsRepository.findByName(name);
    }


    @GetMapping(value = "/author/{author}")
    public List<Documents> searchAuthor(@PathVariable final String author) {
        return documentsRepository.findByAuthor(author);
    }

    @GetMapping(value = "/all")
    public List<Documents> searchAll() {
        List<Documents> documentsList = new ArrayList<>();
        Iterable<Documents> documents = documentsRepository.findAll();
        documents.forEach(documentsList::add);
        return documentsList;
    }
    @GetMapping(value = "/add/{name}/{id}/{author}/{topic}")
    public List<Documents> addUser(@PathVariable final String name, @PathVariable final long id, @PathVariable final String author, @PathVariable final String topic) {
        Documents document = new Documents(name, id, author, topic);
        documentsRepository.save(document);
        List<Documents> documentList = new ArrayList<>();
        Iterable<Documents> documents = documentsRepository.findAll();
        documents.forEach(documentList::add);
        return documentList;
    }

    @GetMapping(value = "/remove/{id}")
    public List<Documents> deleteDocument(@PathVariable final long id){
        documentsRepository.deleteById(id);
        return searchAll();
    }

    @GetMapping(value = "/query/{text}")
    public List<Documents> getAll(@PathVariable final String text) {
        return searchQueryBuilder.getAll(text);
    }
}
