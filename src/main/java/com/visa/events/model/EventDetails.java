package com.visa.events.model;

import com.visa.events.model.enums.EventType;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;

/**
 * This {@link EventDetails} will contains attributes that are required to calculate estimations for an event.
 *
 * @author ThirupathiReddy Vajjala
 */
public class EventDetails {


    private String contactName;

    private String phone;

    private String email;

    private EventType eventType;

    private String city;

    private LocalDate date;

    private int attendees;


    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


    public int getAttendees() {
        return attendees;
    }

    public void setAttendees(int attendees) {
        this.attendees = attendees;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventDetails that = (EventDetails) o;
        return attendees == that.attendees &&
                Objects.equals(contactName, that.contactName) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(email, that.email) &&
                eventType == that.eventType &&
                Objects.equals(city, that.city) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {

        return Objects.hash(contactName, phone, email, eventType, city, date, attendees);
    }
}
