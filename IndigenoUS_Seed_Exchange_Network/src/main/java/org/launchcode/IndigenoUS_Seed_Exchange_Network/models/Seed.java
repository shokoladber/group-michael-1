package org.launchcode.IndigenoUS_Seed_Exchange_Network.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;


@Entity
public class Seed {

    //primary key annotations (@Id , @GeneratedValue) auto generate the id field. Below are columns.
    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message = "Must include botanical name")
    @Size(min = 3, max = 100, message = "Botanical name must be between 3 and 100 characters")
    private String botanicalName;
    @NotBlank(message = "Must include common name")
    @Size(min = 3, max = 100, message = "Common name must be between 3 and 100 characters")
    private String commonName;
    private Integer seedQuantity;
    private Boolean isEndangered = true;
    private Boolean sourceIsIndigenous = true;
    private String[] plantHardinessZone = {"1a", "1b", "2a", "2b", "3a", "3b", "4a", "4b", "5a", "5b", "6a", "6b",
            "7a", "7b", "8a", "8b", "9a", "9b", "10a", "10b", "11a", "11b", "12a", "12b", "13a", "13b"};

    public Seed() {}



    //Creating Object Seed
    public Seed(String botanicalName, String commonName, Boolean endangered,
                String[] plantHardinessZone, Integer seedQuantity, Boolean sourceIsIndigenous) {
        this();
        this.botanicalName = botanicalName;
        this.commonName = commonName;
        this.plantHardinessZone = plantHardinessZone;
        this.seedQuantity = seedQuantity;
        this.isEndangered = endangered;
        this.sourceIsIndigenous = sourceIsIndigenous;
    }


    //Getters and Setters
    public int getId() {
        return id;
    }

    public String getBotanicalName() {
        return botanicalName;
    }

    public String getCommonName() {
        return commonName;
    }

    public Integer getSeedQuantity() {
        return seedQuantity;
    }

    public Boolean getSourceIsIndigenous() {
        return sourceIsIndigenous;
    }

    public String[] getPlantHardinessZone() {
        return plantHardinessZone;
    }

    public void setBotanicalName(String botanicalName) {
        this.botanicalName = botanicalName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public void setSeedQuantity(Integer seedQuantity) {
        this.seedQuantity = seedQuantity;
    }

    public Boolean getEndangered() {
        return isEndangered;
    }

    public void setEndangered(Boolean endangered) {
        isEndangered = endangered;
    }

    public void setSourceIsIndigenous(Boolean sourceIsIndigenous) {
        this.sourceIsIndigenous = sourceIsIndigenous;
    }

    public void setPlantHardinessZone(String[] plantHardinessZone) {
        this.plantHardinessZone = plantHardinessZone;
    }
}

