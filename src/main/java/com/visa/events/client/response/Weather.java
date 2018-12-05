package com.visa.events.client.response;

import java.io.Serializable;
import java.util.Objects;

public class Weather implements Serializable {


    private int id;

    private String main;

    private String description;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Weather)) {
            return false;
        }
        Weather weather = (Weather) o;
        return id == weather.id &&
                Objects.equals(main, weather.main) &&
                Objects.equals(description, weather.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, main, description);
    }


    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                ", main='" + main + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
