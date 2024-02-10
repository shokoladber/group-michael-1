package org.launchcode.demo.models.data;

import org.launchcode.demo.models.CommonName;
import org.launchcode.demo.models.Seed;
import org.springframework.data.repository.CrudRepository;

public interface CommonNameRepository extends CrudRepository<CommonName, Integer> {
}
