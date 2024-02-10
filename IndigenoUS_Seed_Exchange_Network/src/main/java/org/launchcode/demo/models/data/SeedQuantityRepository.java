package org.launchcode.demo.models.data;

import org.launchcode.demo.models.Seed;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SeedQuantityRepository extends CrudRepository<Seed, Integer> {
}
