package org.launchcode.demo.models.data;

import org.launchcode.demo.models.Seed;
import org.springframework.data.repository.CrudRepository;

public interface SeedQuantityRepository extends CrudRepository<Seed, Integer> {
}
