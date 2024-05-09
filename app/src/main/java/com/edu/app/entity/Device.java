package com.edu.app.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.*;

@Entity
@Table(name = "device")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Device_id")
    private int deviceid;

    @NotBlank(message = "No puede estar en blanco")
    @Size(min = 1, message = "No puede estar vacío")
    @Column(name = "DeviceName")
    private String devicename;

    @NotBlank(message = "No puede estar en blanco")
    @Size(min = 1, message = "No puede estar vacío")
    @Column(name = "Device_Type")
    private String devicetype;

    @NotBlank(message = "El modelo no puede estar en blanco")
    @Size(min = 1, message = "El modelo no puede estar vacío")
    @Column(name = "Model")
    private String email;

    @Column(name = "SerialNumber")
    private String serialnumber;

    @Column(name = "SiteId")
    private int siteid;



    @ManyToOne
    @JoinColumn(name = "SiteId")
    private Site siteid;

    public int getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(int deviceid) {
        this.deviceid = deviceid;
    }

    public String getDevicename() {
        return devicename;
    }

    public void setDevicename(String devicename) {
        this.devicename = devicename;
    }

    public String getDevicetype() {
        return devicetype;
    }

    public void setDevicetype(String devicetype) {
        this.devicetype = devicetype;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }

    public int getSiteid() {
        return siteid;
    }

    public void setSiteid(Site siteid) {
        this.siteid = siteid;
    }

    public void setSiteid(int siteid) {
        this.siteid = siteid;
    }
}
