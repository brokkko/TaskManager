package com.brokkko.taskmanager.services.utils;

import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class GenerateAppNameService {
    public String generateAppName(String firstname, String lastname) {
        return new StringBuilder()
                .append(firstname.toLowerCase(Locale.ROOT).charAt(0))
                .append('.')
                .append(lastname.toLowerCase(Locale.ROOT))
                .toString();
    }
}
