package org.launchcode.IndigenoUS_Seed_Exchange_Network.stripePayment.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    private String intentID;
    private String clientSecret;
}
