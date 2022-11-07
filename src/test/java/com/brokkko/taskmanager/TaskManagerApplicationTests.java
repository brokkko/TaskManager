package com.brokkko.taskmanager;

import com.brokkko.taskmanager.initializer.PostgreSQL;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@ContextConfiguration(initializers = {
        PostgreSQL.Initializer.class
})
@Testcontainers
class TaskManagerApplicationTests {

    @BeforeAll
    public static void init() {
        PostgreSQL.container.start();
    }

    @Test
    void contextLoads() {
    }

}
