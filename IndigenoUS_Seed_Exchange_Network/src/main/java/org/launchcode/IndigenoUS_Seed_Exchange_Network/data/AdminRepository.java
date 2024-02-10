package org.launchcode.IndigenoUS_Seed_Exchange_Network.data;

import org.launchcode.IndigenoUS_Seed_Exchange_Network.models.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Integer> {

}