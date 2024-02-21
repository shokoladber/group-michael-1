package org.launchcode.IndigenoUS_Seed_Exchange_Network.data;

import org.launchcode.IndigenoUS_Seed_Exchange_Network.models.SeedQuantity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SeedQuantityRepository extends CrudRepository<SeedQuantity, Integer> {
}
