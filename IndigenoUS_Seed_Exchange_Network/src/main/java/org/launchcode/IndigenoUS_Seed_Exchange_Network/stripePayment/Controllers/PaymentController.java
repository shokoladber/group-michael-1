package org.launchcode.IndigenoUS_Seed_Exchange_Network.stripePayment.Controllers;

import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.launchcode.IndigenoUS_Seed_Exchange_Network.stripePayment.Models.Request;
import org.launchcode.IndigenoUS_Seed_Exchange_Network.stripePayment.Models.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PaymentController {
    @PostMapping("/create-payment-intent")
   public Response createPaymentIntent(@RequestBody Request request) throws StripeException {
        PaymentIntentCreateParams params =
                PaymentIntentCreateParams.builder()
                        .setAmount(request.getAmount() * 100L)
                        .putMetadata("firstName", request.getFirstName())
                        .putMetadata("lastName", request.getLastName())
                        .putMetadata("businessName", request.getBusinessName())
                        .putMetadata("donationNote", request.getDonationNote())
                        .setCurrency("usd")
                        .setAutomaticPaymentMethods(
                                PaymentIntentCreateParams
                                        .AutomaticPaymentMethods
                                        .builder()
                                        .setEnabled(true)
                                        .build()
                        )
                        .build();
        PaymentIntent intent = PaymentIntent.create(params);
        return new Response(intent.getId(), intent.getClientSecret());
    }
}

/*@RestController
public class PaymentController {

    @PostMapping("/create-payment-intent")
    public Response createPaymentIntent(@RequestBody Request request) {
        PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                .setAmount(request.getAmount() * 100L)
                .putMetadata("productName", request.getProductName())
                .setCurrency("usd")
                .setAutomaticPaymentMethods(
                        PaymentIntentCreateParams
                                .AutomaticPaymentMethods
                                .builder()
                                .setEnabled(true)
                                .build()
                }
                .build();
        PaymentIntent intent = PaymentIntent.create(params);
        return new Response(intent.getId(), intent.getClientSecret());
    }
}
*/
