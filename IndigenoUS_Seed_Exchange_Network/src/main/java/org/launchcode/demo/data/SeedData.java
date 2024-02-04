package org.launchcode.demo.data;

import org.launchcode.demo.models.Seed;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SeedData {
    private static Map<Integer, Seed> seeds = new HashMap<>();
    public static Collection<Seed> getAll() {return seeds.values();}
    public static void add(Seed seed) {seeds.put(seed.getId(), seed);}
    public static Seed getById(Integer id) {return seeds.get(id);}
    public static void remove(Integer id) {
        if (seeds.containsKey(id)) {
            seeds.remove(id);
        }
    }

}
