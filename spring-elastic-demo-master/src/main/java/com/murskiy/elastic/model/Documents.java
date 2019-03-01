package com.murskiy.elastic.model;

@org.springframework.data.elasticsearch.annotations.Document(indexName = "documents", type = "documents", shards = 1)
public class Documents {
    private String name;
    private Long id;
    private String author;
    private String topic;

    public Documents(String name, Long id, String author, String topic) {
        this.name = name;
        this.id = id;
        this.author = author;
        this.topic = topic;
    }

    public Documents(){

    };

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getName() {

        return name;
    }

    public Long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTopic() {
        return topic;
    }
}
