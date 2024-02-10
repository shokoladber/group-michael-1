package org.launchcode.demo.models.data;

import org.launchcode.demo.models.BotanicalName;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BotanicalNameRepository extends CrudRepository<BotanicalName, Integer> {
}
