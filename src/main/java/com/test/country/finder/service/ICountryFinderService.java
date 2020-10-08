package com.test.country.finder.service;

import com.test.country.finder.exception.CountryNotFoundException;

public interface ICountryFinderService {

    String getCountryByCity(String cityName) throws CountryNotFoundException;

}
