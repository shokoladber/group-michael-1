package org.launchcode.IndigenoUS_Seed_Exchange_Network.models;

import java.util.ArrayList;

public class SeedData {

    public static ArrayList<Seed> findByColumnAndValue(String column, String value, Iterable<Seed> allSeeds) {

        ArrayList<Seed> results = new ArrayList<>();

        if (value.equalsIgnoreCase("all")){
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
        String theValue = switch (fieldName) {
            case "botanicalName" -> seed.getBotanicalName().toString();
            case "commonName" -> seed.getCommonName().toString();
            case "isEndangered" -> seed.getEndangered().toString();
            case "plantHardinessZone" -> seed.getPlantHardinessZone().toString();
            case "seedQuantity" -> seed.getSeedQuantity().toString();
            default -> seed.getSourceIsIndigenous().toString();
        };

        return theValue;
    }

    public static ArrayList<Seed> findByValue(String value, Iterable<Seed> allSeeds) {


        ArrayList<Seed> results = new ArrayList<>();

        for (Seed seed : allSeeds) {

          if (seed.getBotanicalName().toString().toLowerCase().contains(value.toLowerCase())) {
                results.add(seed);
            } else if (seed.getCommonName().toString().toLowerCase().contains(value.toLowerCase())) {
                results.add(seed);
            } else if (seed.getEndangered().toString().toLowerCase().contains(value.toLowerCase())) {
                results.add(seed);
            }else if (seed.getPlantHardinessZone().toString().toLowerCase().contains(value.toLowerCase())) {
                results.add(seed);
            }else if (seed.getSeedQuantity().toString().toLowerCase().contains(value.toLowerCase())) {
                results.add(seed);
            }else if (seed.getSourceIsIndigenous().toString().toLowerCase().contains(value.toLowerCase())) {
                results.add(seed);
            }
        }

        return results;
    }
}
