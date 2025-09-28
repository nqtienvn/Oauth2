package com.tien.oauth2_demo.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http,
                                                   ClientRegistrationRepository clientRegistrationRepository) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated() // tất cả request cần xác thực
                )
                //vất tất cả các phương thức login qua repository
                .oauth2Login(oauth2 -> oauth2
                        .clientRegistrationRepository(clientRegistrationRepository) // truyền bean qua DI
                );

        return http.build();
    }
//    @Bean
//    public ClientRegistration clientRegistration() {
//        return CommonOAuth2Provider.GITHUB
//                .getBuilder("github")
//                .clientId(clientProperties.getClientId())
//                .clientSecret(clientProperties.getClientSecret())
//                .build();
//    }
//    @Bean
//    public ClientRegistrationRepository clientRegistrationRepository() {
//        //giống y đúc userDetailService cũng có duy nhất 1 client là load
//        return new InMemoryClientRegistrationRepository(clientRegistration());
//    }
}
