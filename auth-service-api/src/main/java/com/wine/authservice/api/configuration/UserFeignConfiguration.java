package com.wine.authservice.api.configuration;

import com.wine.authservice.api.feign.UserServiceClient;
import com.wine.authservice.api.AuthServiceApiProperties;
import com.wine.authservice.api.error.UserServiceErrorDecoder;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class UserFeignConfiguration {
    @Autowired
    private AuthServiceApiProperties authServiceApiProperties;

    @Bean
    public UserServiceClient authenticationServiceClient() {
        return Feign.builder()
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .errorDecoder(new UserServiceErrorDecoder())
                .client(new OkHttpClient())
                .target(UserServiceClient.class, "http://" + authServiceApiProperties.getHost());
    }
}
