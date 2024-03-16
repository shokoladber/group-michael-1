package org.launchcode.IndigenoUS_Seed_Exchange_Network.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;


import java.time.LocalDate;

@Getter
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


    private String imageUrl;



    public Blog() {
        this.time = LocalDate.now();
    }

    public Blog(String title, String author, String content) {
        this();
        this.title = title;
        this.author = author;
        this.content = content;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

