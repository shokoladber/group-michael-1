package org.launchcode.demo.models.data;

import org.launchcode.demo.models.PlantHardinessZone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PlantHardinessZoneRepository extends CrudRepository<PlantHardinessZone, Integer> {
}
