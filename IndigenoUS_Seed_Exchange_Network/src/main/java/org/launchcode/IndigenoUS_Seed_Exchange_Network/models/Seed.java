package org.launchcode.IndigenoUS_Seed_Exchange_Network.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

//Creating attributes of Object Seed
@Entity
public class Seed {

    @Id
    @GeneratedValue
    private int seedId;

    private String BotanicalName;
    private String CommonName;
    private Integer SeedQuantity;
    private Boolean isEndangered = true;
    private Boolean SourceIsIndigenous = true;
    private String[] PlantHardinessZone = {"1a", "1b", "2a", "2b", "3a", "3b", "4a", "4b", "5a", "5b", "6a", "6b",
            "7a", "7b", "8a", "8b", "9a", "9b", "10a", "10b", "11a", "11b", "12a", "12b", "13a", "13b"};

    //Creating Object Seed
    public Seed(String botanicalName, String commonName, Boolean endangered,
                String[] plantHardinessZone, Integer seedQuantity, Boolean isIndigenous) {

        this.BotanicalName = botanicalName;
        this.CommonName = commonName;
        this.PlantHardinessZone = plantHardinessZone;
        this.SeedQuantity = seedQuantity;
        this.isEndangered = endangered;
        this.SourceIsIndigenous = isIndigenous;
    }

    //Getters and Setters

    public int getSeedId() {
        return seedId;
    }

    public String getBotanicalName() {
        return BotanicalName;
    }

    public void setBotanicalName(String botanicalName) {
        BotanicalName = botanicalName;
    }

    public String getCommonName() {
        return CommonName;
    }

    public void setCommonName(String commonName) {
        CommonName = commonName;
    }

    public Integer getSeedQuantity() {
        return SeedQuantity;
    }

    public void setSeedQuantity(Integer seedQuantity) {
        SeedQuantity = seedQuantity;
    }

    public Boolean getEndangered() {
        return isEndangered;
    }

    public void setEndangered(Boolean endangered) {
        isEndangered = endangered;
    }

    public Boolean getSourceIsIndigenous() {
        return SourceIsIndigenous;
    }

    public void setSourceIsIndigenous(Boolean sourceIsIndigenous) {
        SourceIsIndigenous = sourceIsIndigenous;
    }

    public String[] getPlantHardinessZone() {
        return PlantHardinessZone;
    }

    public void setPlantHardinessZone(String[] plantHardinessZone) {
        PlantHardinessZone = plantHardinessZone;
    }
}

