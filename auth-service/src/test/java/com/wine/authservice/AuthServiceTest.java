package com.wine.authservice;

import com.wine.authservice.controller.PermissionRestController;
import com.wine.authservice.domain.dto.PermissionDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
//@RunWith(SpringRunner.class)
@TestPropertySource("classpath:application.properties")
public class AuthServiceTest {
    @Autowired
    private PermissionRestController permissionRestController;

    @Test
    public void create() {
        PermissionDto permission = new PermissionDto()
                .setName("perm1");
        PermissionDto res = permissionRestController.add(permission);
        Assertions.assertEquals(res.getName(), permission.getName());
    }
}
