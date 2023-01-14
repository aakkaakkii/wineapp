package com.wine.userservice.api.configuration;

import com.wine.userservice.api.UserServiceApiProperties;
import com.wine.userservice.api.error.UserServiceErrorDecoder;
import com.wine.userservice.api.feign.FavoritesServiceClient;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SuppressWarnings("SpringFacetCodeInspection")
@Configuration
@RequiredArgsConstructor
public class UserServiceFeignConfiguration {
    private final UserServiceApiProperties userServiceApiProperties;

    @Bean
    public FavoritesServiceClient favoritesServiceClient() {
        return Feign.builder()
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .errorDecoder(new UserServiceErrorDecoder())
                .client(new OkHttpClient())
                .target(FavoritesServiceClient.class, "http://" + userServiceApiProperties.getHost());
    }


}
