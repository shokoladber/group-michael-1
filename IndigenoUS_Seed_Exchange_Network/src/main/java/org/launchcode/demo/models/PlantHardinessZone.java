package org.launchcode.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class PlantHardinessZone extends AbstractEntity {
    public PlantHardinessZone() {}
    @ManyToMany(mappedBy = "plantHardinessZone")
    private final List<Seed> seeds = new ArrayList<>();

    @NotBlank(message = "Plant hardiness zone is required")
    @Size(max = 50, message = "Plant hardiness zone is too long!")
    public String plantHardinessZoneLength;

    public String getPlantHardinessZoneLength() {
        return plantHardinessZoneLength;
    }

    public void setPlantHardinessZoneLength(String plantHardinessZoneLength) {
        this.plantHardinessZoneLength = plantHardinessZoneLength;
    }
    public List<Seed> getSeeds() { return seeds; }
}
