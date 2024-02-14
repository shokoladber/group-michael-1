package org.launchcode.demo.models.data;

import org.launchcode.demo.models.Seed;
import org.launchcode.demo.models.SeedQuantity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SeedQuantityRepository extends CrudRepository<SeedQuantity, Integer> {
}
