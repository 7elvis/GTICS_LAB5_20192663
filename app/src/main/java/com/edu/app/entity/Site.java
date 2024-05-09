package com.edu.app.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.*;

@Entity
@Table(name = "site")
public class Site {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SiteId")
    private int siteid;

    @NotBlank(message = "No puede estar en blanco")
    @Size(min = 1, message = "No puede estar vacío")
    @Column(name = "SiteName")
    private String sitename;

    @NotBlank(message = "No puede estar en blanco")
    @Size(min = 1, message = "No puede estar vacío")
    @Column(name = "LocationId")
    private int locationid;

    @NotBlank(message = "El correo no puede estar en blanco")
    @Size(min = 1, message = "El correo no puede estar vacío")
    @Column(name = "InstallationDate")
    private Date installationate;

    @Column(name = "Latitude")
    private String latitude;

    @Column(name = "Longitude")
    private String longitude;

    @ManyToOne
    @JoinColumn(name = "LocationId")
    private Location locationid;


    public int getSiteid() {
        return siteid;
    }

    public void setSiteid(int siteid) {
        this.siteid = siteid;
    }

    public String getSitename() {
        return sitename;
    }

    public void setSitename(String sitename) {
        this.sitename = sitename;
    }

    public int getLocationid() {
        return locationid;
    }

    public void setLocationid(Location locationid) {
        this.locationid = locationid;
    }

    public void setLocationid(int locationid) {
        this.locationid = locationid;
    }

    public Date getInstallationate() {
        return installationate;
    }

    public void setInstallationate(Date installationate) {
        this.installationate = installationate;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
