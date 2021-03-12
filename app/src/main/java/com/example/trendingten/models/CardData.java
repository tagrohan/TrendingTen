package com.example.trendingten.models;

public class CardData {

    private String name;
    private String content;
    private String number;
    private int image;


    public CardData() {
    }


    public CardData(String name, String content, String number, int image) {
        this.name = name;
        this.content = content;
        this.number = number;
        this.image = image;
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

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}