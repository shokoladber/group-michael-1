package org.launchcode.demo.models;

import org.launchcode.demo.models.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.launchcode.demo.NameSorter;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;

public class SeedData {
//    private static Map<Integer, Seed> seeds = new HashMap<>();
//    public static Collection<Seed> getAll() {return seeds.values();}
//    public static void add(Seed seed) {seeds.put(seed.getId(), seed);}
//    public static Seed getById(Integer id) {return seeds.get(id);}
//    public static void remove(Integer id) {
//        if (seeds.containsKey(id)) {
//            seeds.remove(id);
//        }
//    }

    private static boolean isDataLoaded = false;

    private static ArrayList<Seed> allSeeds;
    private static ArrayList<Endangered> allEndangered = new ArrayList<>();
    private static ArrayList<HardinessZone> allHardinessZones = new ArrayList<>();
    private static ArrayList<Indigenous> allIndigenous = new ArrayList<>();
    private static ArrayList<RegionUS> allRegionsUS = new ArrayList<>();
    private static ArrayList<Status> allStatuses = new ArrayList<>();
    private static ArrayList<SunRequirement> allSunRequirements = new ArrayList<>();
    private static ArrayList<WaterRequirement> allWaterRequirements = new ArrayList<>();

    public static ArrayList<Seed> findAll() {

        // load data, if not already loaded
        loadData();

        // Bonus mission; normal version returns allseeds
        return new ArrayList<>(allSeeds);
    }
    public static ArrayList<Seed> findByColumnAndValue(String column, String value) {

        // load data, if not already loaded
        loadData();

        ArrayList<Seed> seeds = new ArrayList<>();

        if (value.toLowerCase().equals("all")){
            return findAll();
        }

        if (column.equals("all")){
            seeds = findByValue(value);
            return seeds;
        }
        for (Seed seed : allSeeds) {

            String aValue = getFieldValue(seed, column);

            if (aValue != null && aValue.toLowerCase().contains(value.toLowerCase())) {
                seeds.add(seed);
            }
        }

        return seeds;
    }

    public static String getFieldValue(Seed seed, String seedInfo){
        String theValue;
        if (seedInfo.equals("name")){
            theValue = seed.getName();
        } else if (seedInfo.equals("endangered")){
            theValue = seed.getEndangered().toString();
        } else if (seedInfo.equals("hardinessZone")){
            theValue = seed.getHardinessZone().toString();
        } else if (seedInfo.equals("indigenous")){
            theValue = seed.getIndigenous().toString();
        } else if (seedInfo.equals("regionUS")){
        theValue = seed.getRegionsUS().toString();
        } else if (seedInfo.equals("status")) {
            theValue = seed.getStatus().toString();
        } else if (seedInfo.equals("sunRequirements")) {
                theValue = seed.getSunRequirement().toString();
        } else {
            theValue = seed.getWaterRequirement().toString();
        }

        return theValue;
    }

    public static ArrayList<Seed> findByValue(String value) {

        // load data, if not already loaded
        loadData();

        ArrayList<Seed> seeds = new ArrayList<>();

        for (Seed seed : allSeeds) {

            if (seed.getName().toLowerCase().contains(value.toLowerCase())) {
                seeds.add(seed);
            } else if (seed.getEndangered().toString().toLowerCase().contains(value.toLowerCase())) {
                seeds.add(seed);
            } else if (seed.getHardinessZone().toString().toLowerCase().contains(value.toLowerCase())) {
                seeds.add(seed);
            } else if (seed.getIndigenous().toString().toLowerCase().contains(value.toLowerCase())) {
                seeds.add(seed);
            } else if (seed.getRegionsUS().toString().toLowerCase().contains(value.toLowerCase())) {
                seeds.add(seed);
            }else if (seed.getStatus().toString().toLowerCase().contains(value.toLowerCase())) {
                seeds.add(seed);
            }else if (seed.getSunRequirement().toString().toLowerCase().contains(value.toLowerCase())) {
                seeds.add(seed);
            }else if (seed.getWaterRequirement().toString().toLowerCase().contains(value.toLowerCase())) {
                seeds.add(seed);
            }

        }

        return seeds;
    }

    private static Object findExistingObject(ArrayList list, String value){
        for (Object item : list){
            if (item.toString().toLowerCase().equals(value.toLowerCase())){
                return item;
            }
        }
        return null;
    }

    private static void loadData() {

        // Only load data once
        if (isDataLoaded) {
            return;
        }

        try {

            // Open the CSV file and set up pull out column header info and records
            //Resource resource = new ClassPathResource(DATA_FILE);
            InputStream is = resource.getInputStream();
            Reader reader = new InputStreamReader(is);
            CSVParser parser = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(reader);
            List<CSVRecord> records = parser.getRecords();
            Integer numberOfColumns = records.get(0).size();
            String[] headers = parser.getHeaderMap().keySet().toArray(new String[numberOfColumns]);

            allSeeds = new ArrayList<>();

            // Put the records into a more friendly format
            for (CSVRecord record : records) {

                String aName = record.get(0);
                String anEmployer = record.get(1);
                String aLocation = record.get(2);
                String aPosition = record.get(3);
                String aSkill = record.get(4);

                Endangered newEndangered = (Endangered) findExistingObject(allEndangered, isEndangered);
                HardinessZone newHardinessZone = (HardinessZone) findExistingObject(allHardinessZones, aHardinessZone);
                Indigenous newIndigenous = (Indigenous) findExistingObject(allIndigenous, isIndigenous);
                RegionUS newRegionUS = (RegionUS) findExistingObject(allRegionsUS, aRegionUS);
                Status newStatus = (Status) findExistingObject(allStatuses, aStatus);
                SunRequirement newSunRequirement = (SunRequirement) findExistingObject(allSunRequirements, aSunRequirement);
                WaterRequirement newWaterRequirement = (WaterRequirement) findExistingObject(allWaterRequirements, aWaterRequirement);

                if (newEndangered == null){
                    newEndangered = new Endangered(isEndangered);
                    allEndangered.add(newEndangered);
                }

                if (new HardinessZone()== null){
                    newHardinessZone = new HardinessZone(aHardinessZones);
                    allHardinessZones.add(newHardinessZone);
                }

                if (newIndigenous == null){
                    newIndigenous = new Indigenous(isIndigenous);
                    allIndigenous.add(newIndigenous);
                }

                if (newRegionUS == null){
                    newRegionUS = new Status(aRegionUS);
                    allRegionsUS.add(newRegionUS);
                }

                if (newStatus == null){
                    newStatus = new Status(aStatus);
                    allStatuses.add(newStatus);
                }

                if (newSunRequirement == null){
                    newSunRequirement = new Status(aSunRequirement);
                    allSunRequirements.add(newSunRequirement);
                }

                if (newWaterRequirement == null){
                    newWaterRequirement = new WaterRequirement(aWaterRequirement);
                    allWaterRequirements.add(newWaterRequirement);
                }

                Seed newSeed = new Seed(aName, newEndangered, newHardinessZone, newIndigenous, newRegionUS, newStatus, newSunRequirement, newWaterRequirement);

                allSeeds.add(newSeed);
            }

            isDataLoaded = true;

        } catch (IOException e) {
            System.out.println("Failed to load seed data");
            e.printStackTrace();
        }
    }


    public static ArrayList<Endangered> getAllEndangered() {
        loadData();
        allEndangered.sort(new NameSorter());
        return allEndangered;
    }

    public static ArrayList<HardinessZone> getAllHardinessZones() {
        loadData();
        allHardinessZones.sort(new NameSorter());
        return allHardinessZones;
    }

    public static ArrayList<Indigenous> getAllIndigenous() {
        loadData();
        allIndigenous.sort(new NameSorter());
        return allIndigenous;
    }

    public static ArrayList<RegionUS> getAllRegionsUS() {
        loadData();
        allRegionsUS.sort(new NameSorter());
        return allRegionsUS;
    }

    public static ArrayList<Status> getAllStatuses() {
        loadData();
        allStatuses.sort(new NameSorter());
        return allStatuses;
    }

    public static ArrayList<SunRequirement> getAllSunRequirements() {
        loadData();
        allSunRequirements.sort(new NameSorter());
        return allSunRequirements;
    }

    public static ArrayList<WaterRequirement> getAllWaterRequirements() {
        loadData();
        allWaterRequirements.sort(new NameSorter());
        return allWaterRequirements;
    }

}
