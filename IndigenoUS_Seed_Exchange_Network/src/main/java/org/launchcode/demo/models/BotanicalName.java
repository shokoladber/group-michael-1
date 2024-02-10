package org.launchcode.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;
@Entity
public class BotanicalName extends AbstractEntity{

    //no-arg contstructor
public BotanicalName() {}

@OneToMany
@JoinColumn(name = "botanical_name_id")
private List<Seed> seeds=new ArrayList<>();

@NotBlank(message = "Botanical name is required")
@Size(min = 1, max = 100, message = "The botanical name must be between 1 and 100 characters")
public String botanicalName;

public String getBotanicalName(){return botanicalName;}

public void setBotanicalName(String BotanicalName){this.botanicalName = botanicalName;}

public List<Seed> getSeeds(){return seeds;}
        }