package org.launchcode.demo.models.data;

import org.launchcode.demo.models.Seed;
import org.launchcode.demo.models.SeedSource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SeedSourceRepository extends CrudRepository<SeedSource, Integer> {
}
