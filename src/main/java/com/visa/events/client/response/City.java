package com.visa.events.client.response;

import java.io.Serializable;
import java.util.Objects;

public class City implements Serializable {


    private String name;


    private String country;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof City)) {
            return false;
        }
        City city = (City) o;
        return Objects.equals(name, city.name) &&
                Objects.equals(country, city.country);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, country);
    }


    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
