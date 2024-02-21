package org.launchcode.IndigenoUS_Seed_Exchange_Network.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Seed extends AbstractEntity {

    @ManyToOne
    private BotanicalName botanicalName;
    @ManyToMany
    private List<CommonName> commonNames = new ArrayList<>();
    @ManyToMany
    private List<EndangeredStatus> endangeredStatuses = new ArrayList<>();
    @ManyToMany
    private List<PlantHardinessZone> plantHardinessZones = new ArrayList<>();
    @ManyToMany
    private List<SeedQuantity> seedQuantities = new ArrayList<>();
    @ManyToMany
    private List<SeedSource> seedSources = new ArrayList<>();

    public Seed() {}

    // Initialize the id and value fields.
    public Seed(BotanicalName aBotanicalName, List<CommonName> someCommonNames, List<EndangeredStatus> endangeredStatuses,
                List<PlantHardinessZone> plantHardinessZones, List<SeedQuantity> seedQuantities, List<SeedSource> seedSources) {
        super();
        this.botanicalName = aBotanicalName;
        this.commonNames = someCommonNames;
        this.endangeredStatuses = endangeredStatuses;
        this.plantHardinessZones = plantHardinessZones;
        this.seedQuantities = seedQuantities;
        this.seedSources = seedSources;

    }

    // Getters and setters.
    public BotanicalName getBotanicalName() {
        return botanicalName;
    }
    public void setBotanicalName(BotanicalName botanicalName) {
        this.botanicalName = botanicalName;
    }

    public List<CommonName> getCommonNames() {
        return commonNames;
    }
    public void setCommonNames(List<CommonName> commonNames) {
        this.commonNames = commonNames;
    }

    public List<EndangeredStatus> getEndangeredStatuses() {
        return endangeredStatuses;
    }
    public void setEndangeredStatuses(List<EndangeredStatus> endangeredStatuses) {
        this.endangeredStatuses = endangeredStatuses;
    }

    public List<PlantHardinessZone> getPlantHardinessZones() {
        return plantHardinessZones;
    }
    public void setPlantHardinessZones(List<PlantHardinessZone> plantHardinessZones) {
        this.plantHardinessZones = plantHardinessZones;
    }

    public List<SeedQuantity> getSeedQuantities() {
        return seedQuantities;
    }
    public void setSeedQuantities(List<SeedQuantity> seedQuantities) {
        this.seedQuantities = seedQuantities;
    }

    public List<SeedSource> getSeedSources() {
        return seedSources;
    }

    public void setSeedSources(List<SeedSource> seedSources) {
        this.seedSources = seedSources;
    }
}

