package com.visa.events.client.response;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class WeatherResponse implements Serializable {


    private String cod;


    private List<WeatherData> list;


    private City city;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public List<WeatherData> getList() {
        return list;
    }

    public void setList(List<WeatherData> list) {
        this.list = list;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WeatherResponse)) {
            return false;
        }
        WeatherResponse that = (WeatherResponse) o;
        return Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {

        return Objects.hash(city);
    }


    @Override
    public String toString() {
        return "WeatherResponse{" +
                "cod='" + cod + '\'' +
                ", list=" + list +
                ", city=" + city +
                '}';
    }
}
