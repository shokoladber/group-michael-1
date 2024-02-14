package org.launchcode.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
public class SeedQuantity  extends AbstractEntity {
    public SeedQuantity() {}
    @ManyToMany(mappedBy = "seedQuantity")
    private final List<Seed> seeds = new ArrayList<>();

    @NotBlank(message = "Seed quantity is required")
    public String seedQuantityLength;

    public String getSeedQuantityLength() {
        return seedQuantityLength;
    }

    public void setSeedQuantityLength(String seedQuantityLength) {
        this.seedQuantityLength = seedQuantityLength;
    }
    public List<Seed> getSeeds() { return seeds; }
}
