package org.launchcode.IndigenoUS_Seed_Exchange_Network.models;

import jakarta.persistence.*;

public class ProfessionalReference {
    private String name;
    private String institution;
    private String position;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Entity
    @Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
    public static class User {

        @Id
        @GeneratedValue

        private Integer id;
        private String email;
        private String password;

        public User(){}

        public User(Integer id, String fullName, String email, String password, String role) {
            this.id = id;
            this.email = email;
            this.password = password;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }


        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
