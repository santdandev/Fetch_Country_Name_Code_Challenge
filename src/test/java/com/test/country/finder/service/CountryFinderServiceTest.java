package com.test.country.finder.service;

import com.test.country.finder.exception.CountryNotFoundException;
import com.test.country.finder.model.CityCountry;
import com.test.country.finder.repository.CityCountryRepository;
import com.test.country.finder.service.impl.CountryFinderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {CountryFinderService.class})
public class CountryFinderServiceTest {

    @MockBean
    private CityCountryRepository repository;

    @Autowired
    private CountryFinderService countryFinderService;

    @Test
    void shouldReturnCountry_Success() throws CountryNotFoundException {
        when(repository.findByCityIgnoreCase("Texas"))
                .thenReturn(new CityCountry(1L, "Texas", "United States"));

        assertThat(countryFinderService.getCountryByCity("Texas"))
                .isNotNull()
                .isEqualTo("United States");
    }

    @Test
    void shouldReturnCountry_Failure() {
        when(repository.findByCityIgnoreCase(anyString())).thenReturn(null);
        Exception exception = assertThrows(CountryNotFoundException.class, () -> countryFinderService.getCountryByCity("Invalid City"));
        assertThat(exception.getMessage().contains("Country Not Found"));

    }


}
