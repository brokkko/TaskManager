package com.brokkko.taskmanager.repositories;

import com.brokkko.taskmanager.enumerations.Role;
import com.brokkko.taskmanager.models.UserEntity;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.PostgreSQLContainer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(initializers = {UserRepositoryTest.Initializer.class})
public class UserRepositoryTest {

    @ClassRule
    public static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer("postgres:11.1")
            .withDatabaseName("integration-tests-db")
            .withUsername("brokkko")
            .withPassword("brokkko");

    @Autowired
    private UserRepository userRepository;

    @Test
    public void usersRepositoryFindsUserByEmail() {
        String email = "test@mail.ru";
        UserEntity user = UserEntity.builder()
                .id(null)
                .email(email)
                .password("111")
                .userAppName("")
                .firstname("testname")
                .lastname("testlastname")
                .role(Role.ROLE_USER)
                .build();
        userRepository.save(user);
        assertEquals(true, userRepository.existsByEmail(email));
        assertNotEquals(null, userRepository.findByEmail(email).get().getId());
    }

    static class Initializer
            implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues.of(
                    "spring.datasource.url=" + postgreSQLContainer.getJdbcUrl(),
                    "spring.datasource.username=" + postgreSQLContainer.getUsername(),
                    "spring.datasource.password=" + postgreSQLContainer.getPassword()
            ).applyTo(configurableApplicationContext.getEnvironment());
        }
    }


}
