package org.launchcode.IndigenoUS_Seed_Exchange_Network.models;

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
       if (fieldName.equals("botanicalName")){
            theValue = seed.getBotanicalName().toString();
        } else if (fieldName.equals("commonName")){
            theValue = seed.getCommonName().toString();
        } else if (fieldName.equals("isEndangered")){
            theValue = seed.getEndangered().toString();
        } else if (fieldName.equals("plantHardinessZone")){
            theValue = seed.getPlantHardinessZone().toString();
        } else if (fieldName.equals("seedQuantity")){
            theValue = seed.getSeedQuantity().toString();
        } else {
        theValue = seed.getSourceIsIndigenous().toString();
    }

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
