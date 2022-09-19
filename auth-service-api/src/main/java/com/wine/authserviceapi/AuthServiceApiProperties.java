package com.wine.authserviceapi;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

@PropertySources({
        @PropertySource("classpath:application-auth-service-api.properties"),
        @PropertySource("classpath:application-auth-service-api-${spring.profiles.active:local}.properties")
})
@ConfigurationProperties(prefix = "user.service.api")
@Setter
@Component
@Getter
public class AuthServiceApiProperties {
    private String host;


}
