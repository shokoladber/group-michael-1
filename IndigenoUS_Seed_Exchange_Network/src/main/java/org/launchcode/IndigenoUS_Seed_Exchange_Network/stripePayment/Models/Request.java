package org.launchcode.IndigenoUS_Seed_Exchange_Network.stripePayment.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Request {
    @Id
    @GeneratedValue

    @NotNull
    @Min(4)
    private Long amount;

    @NotBlank(message="To remain anonymous please enter N/A")
    @Size(min= 1, max=50)
    private String firstName;
    @NotBlank(message="To remain anonymous please enter N/A")
    @Size(min= 1, max=50)
    private String lastName;
    @NotBlank(message="Enter N/A if not applicable")
    @Size(min=2, max=50)
    private String businessName;

    @Email
    private String email;
    @NotBlank
    @Size(min = 5, max = 200)
    private String donationNote;

}