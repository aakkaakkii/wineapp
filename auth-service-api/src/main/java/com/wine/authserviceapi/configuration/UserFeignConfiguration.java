package com.wine.authserviceapi.configuration;

import com.wine.authserviceapi.AuthServiceApiProperties;
import com.wine.authserviceapi.error.UserServiceErrorDecoder;
import com.wine.authserviceapi.feign.UserServiceClient;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class UserFeignConfiguration {
    private final AuthServiceApiProperties authServiceApiProperties;

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
