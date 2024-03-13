package org.launchcode.IndigenoUS_Seed_Exchange_Network.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Getter

@Entity
public class Admin {
    @Id
    @GeneratedValue
    private int id;

    private String email;

    private String password;

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        this.password = encoder.encode(password);
    }
}