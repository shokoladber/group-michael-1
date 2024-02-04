package org.launchcode.demo.models;

import java.time.LocalDate;

public class Seed {

    private int id;
    private static int nextId;
    private String title;
    private String content;
    private LocalDate time;
    private String status;

    public Seed(String title, String content, String status) {
        this.title = title;
        this.content = content;
        this.status = status;
        this.id = nextId;
        nextId++;
        this.time = LocalDate.now();
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getTime() {
        return time;
    }
}
