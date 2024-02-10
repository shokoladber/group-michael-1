package org.launchcode.demo.models.data;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.launchcode.demo.models.Seed;
import org.springframework.data.repository.CrudRepository;

public interface SeedRepository extends CrudRepository<Seed, Integer> {
}
