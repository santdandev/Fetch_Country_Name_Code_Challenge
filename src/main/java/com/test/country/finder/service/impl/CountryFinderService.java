package com.test.country.finder.service.impl;

import com.test.country.finder.exception.CountryNotFoundException;
import com.test.country.finder.model.CityCountry;
import com.test.country.finder.repository.CityCountryRepository;
import com.test.country.finder.service.ICountryFinderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryFinderService implements ICountryFinderService {

    @Autowired
    private CityCountryRepository cityCountryRepository;


    public String getCountryByCity(String cityName) throws CountryNotFoundException {
        CityCountry cityCountry = cityCountryRepository.findByCityIgnoreCase(cityName);
        if (cityCountry == null) {
            throw new CountryNotFoundException("Country Not Found");
        }
        return cityCountry.getCountry();
    }
}
