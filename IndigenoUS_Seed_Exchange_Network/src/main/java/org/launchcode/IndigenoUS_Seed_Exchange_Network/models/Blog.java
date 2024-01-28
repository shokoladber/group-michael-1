package org.launchcode.IndigenoUS_Seed_Exchange_Network.models;

import java.time.LocalDate;

public class Blog {

    private int id;
    private static int nextId;
private String title;
private String author;
private String content;
private LocalDate time;

    public Blog(String title, String author, String content) {
        this.title = title;
        this.author = author;
        this.content = content;
        this.id = nextId;
        nextId++;
        this.time=LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getTime() {
        return time;
    }
}
