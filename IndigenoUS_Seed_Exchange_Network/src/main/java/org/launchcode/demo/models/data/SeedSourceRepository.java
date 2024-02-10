package org.launchcode.demo.models.data;

import org.launchcode.demo.models.Seed;
import org.springframework.data.repository.CrudRepository;

public interface SeedSourceRepository extends CrudRepository<Seed, Integer> {
}
