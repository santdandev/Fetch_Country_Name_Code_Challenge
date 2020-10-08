package com.test.country.finder;

import com.test.country.finder.controller.CountryFinderController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CountryFinderApplicationTests {

    @Autowired
    private CountryFinderController controller;

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }

}
