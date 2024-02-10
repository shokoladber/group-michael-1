package org.launchcode.demo.models.data;

import org.launchcode.demo.models.BotanicalName;
import org.launchcode.demo.models.Seed;
import org.springframework.data.repository.CrudRepository;

public interface BotanicalNameRepository extends CrudRepository<BotanicalName, Integer> {
}
