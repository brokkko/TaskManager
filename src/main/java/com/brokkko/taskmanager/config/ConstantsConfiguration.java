package com.brokkko.taskmanager.config;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "api")
@Getter
public class ConstantsConfiguration {
    public static final String API = "/api/v1.0";
    public static final String AUTHENTICATION = API + "/auth";
    public static final String USERS = API + "/users";

    public static final String BOARDS = API + "/boards";
}
