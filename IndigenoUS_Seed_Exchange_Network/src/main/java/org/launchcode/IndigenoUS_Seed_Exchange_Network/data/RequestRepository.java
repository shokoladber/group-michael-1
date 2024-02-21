package org.launchcode.IndigenoUS_Seed_Exchange_Network.data;

import org.launchcode.IndigenoUS_Seed_Exchange_Network.stripePayment.Models.Request;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends CrudRepository <Request, Integer> {

}
