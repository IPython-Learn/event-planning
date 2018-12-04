package com.visa.events.model;

import com.visa.events.controller.validator.EventTypeConstraint;
import com.visa.events.controller.validator.LocalDateConstraint;
import com.visa.events.model.enums.EventType;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

/**
 * This {@link EventDetails} will contains attributes that are required to calculate estimations for an event.
 *
 * @author ThirupathiReddy Vajjala
 */
public class EventDetails {


    @NotEmpty(message = "{contactName.notempty}")
    private String contactName;

    @NotEmpty(message = "{phone.notempty}")
    private String phone;

    @Email(message = "{email.invalid}")
    @NotNull(message = "{email.notempty}")
    @NotEmpty(message = "{email.notempty}")
    private String email;

    @EventTypeConstraint
    @NotEmpty(message = "{eventType.notempty}")
    private String eventType;

    @NotEmpty(message = "{city.notempty}")
    private String city;

    @LocalDateConstraint
    @NotEmpty(message = "{date.invalid}")
    private String date;

    @NotNull(message = "{attendees.notempty}")
    @Min(value = 1, message = "{attendees.invalid}")
    private Integer attendees;


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
        return EventType.valueOf(eventType);
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getDate() {
        return LocalDate.parse(date);
    }

    public void setDate(String date) {
        this.date = date;
    }


    public Integer getAttendees() {
        return attendees;
    }

    public void setAttendees(Integer attendees) {
        this.attendees = attendees;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
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
