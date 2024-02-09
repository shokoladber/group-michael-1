package org.launchcode.IndigenoUS_Seed_Exchange_Network.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Admin {
    @GeneratedValue
    @Id
    private int id;
    private String adminname;
@OneToMany(mappedBy = "")
    private List<Blog> blogs = new ArrayList<>();

    public int getId() {return id;}

    public String getAdminname() {return adminname;}

    public void setAdminname(String adminname) {this.adminname = adminname;}
}
