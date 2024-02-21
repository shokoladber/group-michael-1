package org.launchcode.IndigenoUS_Seed_Exchange_Network.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


import java.time.LocalDate;

@Entity
public class Blog {
    @Id
    @GeneratedValue
    private int id;


    @NotBlank(message = "Must include title")
    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
    private String title;
    @NotBlank(message = "Must include author")
    @Size(min = 3, max = 50, message = "Author name must be between 3 and 50 characters")
    private String author;
    @NotBlank(message = "Must include content")
    @Size(min = 100, max = 20000, message = "Content must be between 100 and 20000 characters")
    private String content;
    private LocalDate time;

//private String imageFilePath;

//@ManyToOne
//private Admin admin;

    public Blog() {
        this.time = LocalDate.now();
    }

    public Blog(String title, String author, String content) {// String imageFilePath) {
        this();
        this.title = title;
        this.author = author;
        this.content = content;
        //   this.imageFilePath = imageFilePath;
    }

    //  public String getImageFilePath() {
    //      return imageFilePath;
    //  }

    //public void setImage(String imageFilePath) {
    //    this.imageFilePath = imageFilePath;
    // }

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