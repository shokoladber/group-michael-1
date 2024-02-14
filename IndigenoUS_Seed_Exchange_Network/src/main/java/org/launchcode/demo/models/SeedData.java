package org.launchcode.demo.models;

import java.util.ArrayList;

public class SeedData {

    public static ArrayList<Seed> findByColumnAndValue(String column, String value, Iterable<Seed> allSeeds) {

        ArrayList<Seed> results = new ArrayList<>();

        if (value.toLowerCase().equals("all")){
            return (ArrayList<Seed>) allSeeds;
        }

        if (column.equals("all")){
            results = findByValue(value, allSeeds);
            return results;
        }
        for (Seed seed : allSeeds) {

            String aValue = getFieldValue(seed, column);

            if (aValue != null && aValue.toLowerCase().contains(value.toLowerCase())) {
                results.add(seed);
            }
        }

        return results;
    }

    public static String getFieldValue(Seed seed, String fieldName){
        String theValue;
        if (fieldName.equals("name")){
            theValue = seed.getName();
        } else if (fieldName.equals("botanicalName")){
            theValue = seed.getBotanicalName().toString();
        } else if (fieldName.equals("commonName")){
            theValue = seed.getCommonNames().toString();
        } else if (fieldName.equals("endangeredStatus")){
            theValue = seed.getEndangeredStatuses().toString();
        } else if (fieldName.equals("plantHardinessZone")){
            theValue = seed.getPlantHardinessZones().toString();
        } else if (fieldName.equals("seedQuantity")){
            theValue = seed.getSeedQuantities().toString();
        } else {
        theValue = seed.getSeedSources().toString();
    }

        return theValue;
    }

    public static ArrayList<Seed> findByValue(String value, Iterable<Seed> allSeeds) {


        ArrayList<Seed> results = new ArrayList<>();

        for (Seed seed : allSeeds) {

            if (seed.getName().toLowerCase().contains(value.toLowerCase())) {
                results.add(seed);
            } else if (seed.getBotanicalName().toString().toLowerCase().contains(value.toLowerCase())) {
                results.add(seed);
            } else if (seed.getCommonNames().toString().toLowerCase().contains(value.toLowerCase())) {
                results.add(seed);
            } else if (seed.getEndangeredStatuses().toString().toLowerCase().contains(value.toLowerCase())) {
                results.add(seed);
            }else if (seed.getPlantHardinessZones().toString().toLowerCase().contains(value.toLowerCase())) {
                results.add(seed);
            }else if (seed.getSeedQuantities().toString().toLowerCase().contains(value.toLowerCase())) {
                results.add(seed);
            }else if (seed.getSeedSources().toString().toLowerCase().contains(value.toLowerCase())) {
                results.add(seed);
            }
        }

        return results;
    }
}
