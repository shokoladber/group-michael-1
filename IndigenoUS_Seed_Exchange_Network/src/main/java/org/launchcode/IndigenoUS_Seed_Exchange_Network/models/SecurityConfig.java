package org.launchcode.IndigenoUS_Seed_Exchange_Network.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {
public SecurityConfig(){
}

    @Value("https://dev-cuxzun3pg8wwfwns.us.auth0.com/")
    private String issuer;
    @Value("Gtk4PDcCbSddLUG8mZTZqmvPcGt2OCCB")
    private String clientId;

    public SecurityConfig(String issuer, String clientId) {
        this.issuer = issuer;
        this.clientId = clientId;
    }

    //    @Bean
//    public OktaOAuth2Properties oktaOAuth2Properties() {
//        OktaOAuth2Properties properties = new OktaOAuth2Properties();
//        properties.setClientId(clientId);
//        properties.setIssuer(issuer);
//        return properties;
//    }
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/", "/images/**").permitAll()
                        .anyRequest().authenticated()
                )
                .oauth2Login(withDefaults())
                .logout(logout -> logout
                        .addLogoutHandler(logoutHandler()));
        return http.build();
    }

    private LogoutHandler logoutHandler() {
        return (request, response, authentication) -> {
            try {
                String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
                response.sendRedirect(issuer + "v2/logout?client_id=" + clientId + "&returnTo=" + baseUrl);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

    //import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.oauth2.client.registration.ClientRegistration;
//import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
//import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
//import org.springframework.security.oauth2.core.AuthorizationGrantType;
//import org.springframework.security.oauth2.core.oidc.IdTokenClaimNames;
//
//import org.springframework.security.web.SecurityFilterChain;
//import static org.springframework.security.config.Customizer.withDefaults;
//import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//    @Bean
//    public SecurityFilterChain configure(ServerHttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(authorize -> authorize
//                        .anyRequest().authenticated()
//                )
//                .oauth2Login(withDefaults());
//        return http.build();
//
//    }
////
    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        return new InMemoryClientRegistrationRepository(
                ClientRegistration.withRegistrationId("IndigenUsSeedExchangeNetworkApplication")
                        .clientId("Gtk4PDcCbSddLUG8mZTZqmvPcGt2OCCB")
                        .clientSecret("tWQaqDJpHThNgyA-H9a1uZcuTR9EajA4c5Hemg_57C0PS1z8MXh1-w1uuO7EYtHB")
                        .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                        .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                        //this is what redirects to the homepage after login.
                        .redirectUri("http://localhost:8080/")
                        .scope("read", "write")
                        .authorizationUri("https://dev-cuxzun3pg8wwfwns.us.auth0.com/authorize/")
                        .tokenUri("https://authorization-server.com/oauth2/token")
                        .userInfoUri("https://resource-server.com/userinfo")
                        .userNameAttributeName("sub")
                        .clientName("My OAuth 2.0 Client")
                        .build()
        );
    }
}



//}