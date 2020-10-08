package com.test.country.finder.controller;

import com.test.country.finder.exception.CountryNotFoundException;
import com.test.country.finder.service.ICountryFinderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/country")
public class CountryFinderController {

    @Autowired
    private ICountryFinderService countryFinderService;

    @GetMapping("/{cityName}")
    public ResponseEntity<String> getCountryByCity(@PathVariable("cityName") String cityName) throws CountryNotFoundException {
        return new ResponseEntity<>(countryFinderService.getCountryByCity(cityName), HttpStatus.OK);
    }
}
