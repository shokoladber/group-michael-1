package org.launchcode.IndigenoUS_Seed_Exchange_Network.data;


import org.launchcode.IndigenoUS_Seed_Exchange_Network.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}

