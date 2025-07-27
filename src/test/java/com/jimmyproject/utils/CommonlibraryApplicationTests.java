package com.jimmyproject.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = CommonlibraryApplication.class)
@ActiveProfiles("test")
class CommonlibraryApplicationTests {

    @Test
    void contextLoads() {
        // This test will verify that the Spring application context loads successfully
    }
}
