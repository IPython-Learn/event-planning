package com.visa.events.client.response;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Objects;

public class WeatherData implements Serializable {


    private long dt;


    private List<Weather> weather;


    public LocalDate getDate() {
        return Instant.ofEpochSecond(dt).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WeatherData)) {
            return false;
        }
        WeatherData that = (WeatherData) o;
        return dt == that.dt &&
                Objects.equals(weather, that.weather);
    }

    @Override
    public int hashCode() {

        return Objects.hash(dt, weather);
    }


    @Override
    public String toString() {
        return "WeatherData{" +
                "dt=" + dt +
                ", weather=" + weather +
                '}';
    }
}
