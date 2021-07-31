package com.example.trendingten.models;

public class Card {

    private int id;
    private String name;
    private String content;
    private String number;
    public String uri;

    public Card(String name, String content, String number, String uri) {
        this.name = name;
        this.content = content;
        this.number = number;
        this.uri = uri;
    }

    public Card() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", number='" + number + '\'' +
                ", uri='" + uri + '\'' +
                '}';
    }
}
