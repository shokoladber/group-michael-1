package org.launchcode.demo.models;

import java.util.Objects;
public abstract class SeedInfo {
    private int id;
    private static int nextId = 1;
    private String value;

    public SeedInfo() {
        id = nextId;
        nextId++;
    }

    public SeedInfo(String value) {
        this();
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SeedInfo)) return false;
        SeedInfo jobField = (SeedInfo) o;
        return id == jobField.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
