package com.test.country.finder.model;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "city_country")
public class CityCountry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String city;

    @Column(length = 100, nullable = false)
    private String country;

    public CityCountry() {
    }

    public CityCountry(Long id, String city, String country) {
        this.id = id;
        this.city = city;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "CityCountry{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CityCountry)) return false;
        CityCountry that = (CityCountry) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(city, that.city) &&
                Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city, country);
    }
}
