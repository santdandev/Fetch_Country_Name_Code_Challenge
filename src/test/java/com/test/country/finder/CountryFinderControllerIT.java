package com.test.country.finder;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CountryFinderControllerIT {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldReturnCountry_Success() {

        assertThat(this.restTemplate
                .getForObject("http://localhost:" + port + "/country/Delhi", String.class))
                .isNotNull()
                .isEqualTo("India");
    }

    @Test
    public void shouldReturnCountryIgnoreCase_Success() {

        assertThat(this.restTemplate
                .getForObject("http://localhost:" + port + "/country/austria", String.class))
                .isNotNull()
                .isEqualTo("VIENNA");
    }

    @Test
    void shouldReturnCountry_Failure() throws Exception {
        assertThat(this.restTemplate
                .getForObject("http://localhost:" + port + "/country/Invalid", String.class))
                .isNotNull()
                .isEqualTo("Country Not Found");
    }


}
