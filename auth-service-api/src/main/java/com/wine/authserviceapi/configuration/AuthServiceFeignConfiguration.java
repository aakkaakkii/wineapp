package com.wine.authserviceapi.configuration;

import com.wine.authserviceapi.AuthServiceApiProperties;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class AuthServiceFeignConfiguration {
    private final AuthServiceApiProperties authServiceApiProperties;

    @Bean
    public AuthenticationServiceClient authenticationServiceClient() {
        return Feign.builder()
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .errorDecoder(new UserServiceErrorDecoder())
                .client(new OkHttpClient())
                .target(AuthenticationServiceClient.class, "http://" + userServiceApiProperties.getHost());
    }
}
