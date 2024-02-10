package org.launchcode.demo.models.data;

import org.launchcode.demo.models.CommonName;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonNameRepository extends CrudRepository<CommonName, Integer> {
}
