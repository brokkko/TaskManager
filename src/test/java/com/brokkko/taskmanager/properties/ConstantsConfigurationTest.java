package com.brokkko.taskmanager.properties;

import com.brokkko.taskmanager.config.ConstantsConfiguration;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ConstantsConfiguration.class)
@EnableConfigurationProperties(ConstantsConfiguration.class)
@TestPropertySource(locations="classpath:custom.properties")
public class ConstantsConfigurationTest {



}
