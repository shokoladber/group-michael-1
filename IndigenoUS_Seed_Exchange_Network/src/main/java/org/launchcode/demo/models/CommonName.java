package org.launchcode.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class CommonName extends AbstractEntity {

    public CommonName() {}

    @ManyToMany(mappedBy = "commonNames")
    private final List<Seed> seeds = new ArrayList<>();

    @NotBlank(message = "Common name is required")
    @Size(max = 50, message = "Common name is too long!")
    public String commonNameLength;

    public String getCommonNameLength() {
        return commonNameLength;
    }

    public void setCommonNameLength(String commonNameLength) {
        this.commonNameLength = commonNameLength;
    }

    public List<Seed> getSeeds() { return seeds; }
}
