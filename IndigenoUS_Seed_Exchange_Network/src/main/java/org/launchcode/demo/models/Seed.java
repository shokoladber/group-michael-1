package org.launchcode.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Seed extends AbstractEntity{

    @ManyToOne
    private BotanicalName botanicalName;

    @ManyToMany
    private List<CommonName> commonNames = new ArrayList<>();

    public Seed() {}

    // Initialize the id and value fields.
    public Seed(BotanicalName aBotanicalName, List<CommonName> someCommonNames) {
        super();
        this.botanicalName = aBotanicalName;
        this.commonNames = someCommonNames;
    }

    // Getters and setters.
    public BotanicalName getBotanicalName() {
        return botanicalName;
    }

    public void setBotanicalName(BotanicalName botanicalName) {
        this.botanicalName = botanicalName;
    }

    public List<CommonName> getCommonNames() {
        return commonNames;
    }
    public void setCommonNames(List<CommonName> commonNames) {
        this.commonNames = commonNames;
    }
}

//    private int id;
//    private static int nextId = 1;
//    private String name;
//    private Indigenous indigenous;
//    private HardinessZone hardinessZone;
//    private RegionUS regionsUS;
//    private Endangered endangered;
//    private Status status;
//    private SunRequirement sunRequirement;
//    private WaterRequirement waterRequirement;
//    private LocalDateTime time;
//
//
//    public Seed() {
//        id = nextId;
//        nextId++;
//    }
//
//    public Seed(String aName, Indigenous isIndigenous, HardinessZone aHardinessZone,
//                RegionUS aRegionUS, Endangered isEndangered, Status aStatus,
//                SunRequirement aSunRequirement, WaterRequirement aWaterRequirement, LocalDateTime aTime) {
//        this();
//        name = aName;
//        indigenous = isIndigenous;
//        hardinessZone = aHardinessZone;
//        regionsUS = aRegionUS;
//        endangered = isEndangered;
//        status = aStatus;
//        sunRequirement = aSunRequirement;
//        waterRequirement = aWaterRequirement;
//        time = aTime;
//    }
//
//    @Override
//    public String toString(){
//        String output = "";
//        if (name.equals("")){
//            name = "Data not available";
//        }
//        if (indigenous.getValue().equals("") || indigenous.getValue() == null){
//            indigenous.setValue("Data not available");
//        }
//        if (hardinessZone.getValue().equals("") || hardinessZone.getValue() == null){
//            hardinessZone.setValue("Data not available");
//        }
//        if (regionsUS.getValue().equals("") || regionsUS.getValue() == null){
//            regionsUS.setValue("Data not available");
//        }
//        if (endangered.getValue().equals("") || endangered.getValue() == null){
//            endangered.setValue("Data not available");
//        }
//        if (status.getValue().equals("") || status.getValue() == null){
//            status.setValue("Data not available");
//        }
//        if (sunRequirement.getValue().equals("") || sunRequirement.getValue() == null){
//            sunRequirement.setValue("Data not available");
//        }
//        if (waterRequirement.getValue().equals("") || waterRequirement.getValue() == null) {
//            waterRequirement.setValue("Data not available");
//        }
//
//            output = String.format("\nID: %d\n" +
//                            "Name: %s\n" +
//                            "Indigenous: %s\n" +
//                            "HardinessZone: %s\n" +
//                            "RegionUS: %s\n" +
//                            "Endangered: %s\n" +
//                            "Status: %s\n" +
//                            "SunRequirement: %s\n" +
//                            "WaterRequirement: %s\n", id, name, indigenous, hardinessZone, regionsUS, endangered,
//                    status, sunRequirement, waterRequirement);
//            return output;
//        }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Seed)) return false;
//        Seed seed = (Seed) o;
//        return id == seed.id;
//    }
//
//
//    public int getId() {
//        return id;
//    }
//
//    public static int getNextId() {
//        return nextId;
//    }
//
//    public LocalDateTime getTime() {
//        return time;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Indigenous getIndigenous() {
//        return indigenous;
//    }
//
//    public void setIndigenous(Indigenous indigenous) {
//        this.indigenous = indigenous;
//    }
//
//    public HardinessZone getHardinessZone() {
//        return hardinessZone;
//    }
//
//    public void setHardinessZone(HardinessZone hardinessZone) {
//        this.hardinessZone = hardinessZone;
//    }
//
//    public RegionUS getRegionsUS() {
//        return regionsUS;
//    }
//
//    public void setRegionsUS(RegionUS regionsUS) {
//        this.regionsUS = regionsUS;
//    }
//
//    public Endangered getEndangered() {
//        return endangered;
//    }
//
//    public void setEndangered(Endangered endangered) {
//        this.endangered = endangered;
//    }
//
//    public Status getStatus() {
//        return status;
//    }
//
//    public void setStatus(Status status) {
//        this.status = status;
//    }
//
//    public SunRequirement getSunRequirement() {
//        return sunRequirement;
//    }
//
//    public void setSunRequirement(SunRequirement sunRequirement) {
//        this.sunRequirement = sunRequirement;
//    }
//
//    public WaterRequirement getWaterRequirement() {
//        return waterRequirement;
//    }
//
//    public void setWaterRequirement(WaterRequirement waterRequirement) {
//        this.waterRequirement = waterRequirement;
//    }


