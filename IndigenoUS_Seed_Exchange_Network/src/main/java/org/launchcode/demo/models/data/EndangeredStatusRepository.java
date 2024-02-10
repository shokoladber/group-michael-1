package org.launchcode.demo.models.data;

import org.launchcode.demo.models.EndangeredStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EndangeredStatusRepository extends CrudRepository<EndangeredStatus, Integer> {
}
