package com.wine.userservice.api;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

@PropertySources({
        @PropertySource("classpath:application-user-service-api.properties"),
        @PropertySource("classpath:application-user-service-api-${spring.profiles.active:local}.properties")
})
@ConfigurationProperties(prefix = "user.service.api")
@Setter
@Component
@Getter
public class UserServiceApiProperties {
    private String host;

    // topic names
    private String winePriceUpdatedWithTokensTopicName;
    private String userUpdatedTopicName;
    private String favoritesUpdatedTopicName;
}
