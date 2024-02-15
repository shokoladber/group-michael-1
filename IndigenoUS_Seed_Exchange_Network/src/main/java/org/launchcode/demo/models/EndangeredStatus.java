package org.launchcode.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class EndangeredStatus extends AbstractEntity {
    public EndangeredStatus() {}
    @ManyToMany(mappedBy = "endangeredStatuses")
    private final List<Seed> seeds = new ArrayList<>();

    @NotBlank(message = "Endangered status is required")
    @Size(max = 50, message = "Endangered status is too long!")
    public String endangeredStatusLength;

    public String getEndangeredStatusLength() {
        return endangeredStatusLength;
    }

    public void setEndangeredStatusLength(String endangeredStatusLength) {
        this.endangeredStatusLength = endangeredStatusLength;
    }

    public List<Seed> getSeeds() { return seeds; }
}
