package com.brokkko.taskmanager.domain;

import com.brokkko.taskmanager.domain.users.UserService;
import com.brokkko.taskmanager.services.mapping.users.MappingUserService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @MockBean
    private MappingUserService mappingUserService;

//    @Test
//    public void saveUser() {
//        User user = User.builder()
//                .username("test username")
//                .password("password")
//                .build();
//        User savedUser = userService.create(user);
//        Assert.assertEquals(user.getUsername(), savedUser.getUsername());
//        Assert.assertEquals(user.getPassword(), savedUser.getPassword());
//        Assert.assertNotNull(savedUser.getId());
//    }
}
