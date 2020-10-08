package com.test.country.finder.controller;

import com.test.country.finder.service.impl.CountryFinderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class CountryFinderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CountryFinderService service;


    @Test
    void shouldReturnCountry_Success() throws Exception {
        when(service.getCountryByCity(anyString())).thenReturn("United States");

        this.mockMvc.perform(get("/country/Texas")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string("United States"));
    }

    @Test
    void shouldReturnCountry_Failure() throws Exception {
        when(service.getCountryByCity(anyString())).thenReturn("Country Not Found");

        this.mockMvc.perform(get("/country/Invalid")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string("Country Not Found"));
    }
}
