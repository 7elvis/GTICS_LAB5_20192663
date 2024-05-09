package com.edu.app.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.*;

@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LocationId")
    private int locationid;

    @NotBlank(message = "No puede estar en blanco")
    @Size(min = 1, message = "No puede estar vacío")
    @Column(name = "City")
    private String city;

    @NotBlank(message = "No puede estar en blanco")
    @Size(min = 1, message = "No puede estar vacío")
    @Column(name = "Country")
    private String country;


    public int getLocationid() {
        return locationid;
    }

    public void setLocationid(int locationid) {
        this.locationid = locationid;
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
}
