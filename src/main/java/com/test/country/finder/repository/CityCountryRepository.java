package com.test.country.finder.repository;

import com.test.country.finder.model.CityCountry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityCountryRepository extends CrudRepository<CityCountry, Long> {

    CityCountry findByCityIgnoreCase(String city);
}
