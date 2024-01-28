package org.launchcode.IndigenoUS_Seed_Exchange_Network.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class Blog {

    private int id;
    private static int nextId;

@NotBlank(message = "Must include title")
@Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
private String title;
@NotBlank(message = "Must include author")
@Size(min = 3, max = 50, message = "Author name must be between 3 and 50 characters")
private String author;
@NotBlank(message = "Must include content")
@Size(min = 100, max =  20000, message = "Content must be between 100 and 20000 characters")
private String content;
private LocalDate time;

    public Blog(){
        this.id = nextId;
        nextId++;
        this.time=LocalDate.now();
    }

    public Blog(String title, String author, String content) {
        this();
        this.title = title;
        this.author = author;
        this.content = content;
    }
//think this is where error is
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
