package com.brokkko.taskmanager.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GenerateAppNameServiceTest {
    @Autowired
    public GenerateAppNameService generateAppNameService;

    @Test
    public void generateAppNameServiceShouldReturnCorrectAppName() {
        String firstname = "name";
        String lastname = "lastname";
        assertEquals("n.lastname", generateAppNameService.generateAppName(firstname, lastname));
    }
}
