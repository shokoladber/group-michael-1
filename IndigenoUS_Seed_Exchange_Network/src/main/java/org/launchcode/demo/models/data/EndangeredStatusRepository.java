package org.launchcode.demo.models.data;

import org.launchcode.demo.models.EndangeredStatus;
import org.launchcode.demo.models.Seed;
import org.springframework.data.repository.CrudRepository;

public interface EndangeredStatusRepository extends CrudRepository<EndangeredStatus, Integer> {
}
