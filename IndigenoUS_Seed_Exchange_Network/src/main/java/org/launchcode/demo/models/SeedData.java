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
        } else if (fieldName.equals("seed")){
            theValue = seed.getBotanicalName().toString();
        } else {
            theValue = seed.getCommonNames().toString();
        }

        return theValue;
    }

    /**
     * Search all Job fields for the given term.
     *
     * @param value The search term to look for.
     * @param allSeeds The list of jobs to search.
     * @return      List of all jobs with at least one field containing the value.
     */
    public static ArrayList<Seed> findByValue(String value, Iterable<Seed> allSeeds) {


        ArrayList<Seed> results = new ArrayList<>();

        for (Seed seed : allSeeds) {

            if (seed.getName().toLowerCase().contains(value.toLowerCase())) {
                results.add(seed);
            } else if (seed.getBotanicalName().toString().toLowerCase().contains(value.toLowerCase())) {
                results.add(seed);
            } else if (seed.getCommonNames().toString().toLowerCase().contains(value.toLowerCase())) {
                results.add(seed);
            }

        }

        return results;
    }
}
