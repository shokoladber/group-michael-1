package org.launchcode.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class SeedSource extends AbstractEntity {
    public SeedSource() {}
    @ManyToMany(mappedBy = "seedSources")
    private final List<Seed> seeds = new ArrayList<>();

    @NotBlank(message = "Seed source is required")
    @Size(max = 50, message = "Seed source is too long!")
    public String seedSourceLength;

    public String getSeedSourceLength() {
        return seedSourceLength;
    }

    public void setSeedSourceLength(String seedSourceLength) {
        this.seedSourceLength = seedSourceLength;
    }

    public List<Seed> getSeeds() { return seeds; }
}
