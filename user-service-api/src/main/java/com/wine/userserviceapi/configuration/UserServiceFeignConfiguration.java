package com.wine.userserviceapi.configuration;

import com.wine.userserviceapi.UserServiceApiProperties;
import com.wine.userserviceapi.error.UserServiceErrorDecoder;
import com.wine.userserviceapi.feign.AuthenticationServiceClient;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class UserServiceFeignConfiguration {
    private final UserServiceApiProperties userServiceApiProperties;

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
