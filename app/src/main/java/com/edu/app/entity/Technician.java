package com.edu.app.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.*;

@Entity
@Table(name = "technician")
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TechnicianId")
    private int technicianid;

    @NotBlank(message = "No puede estar en blanco")
    @Size(min = 1, message = "No puede estar vacío")
    @Column(name = "FirstNsme")
    private String firstname;

    @NotBlank(message = "No puede estar en blanco")
    @Size(min = 1, message = "No puede estar vacío")
    @Column(name = "LastName")
    private String lastname;

    @NotBlank(message = "El dni no puede estar en blanco")
    @Size(min = 1, message = "El dni no puede estar vacío")
    @Column(name = "Dni")
    private String dni;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Age")
    private int age;

    @ManyToOne
    @JoinColumn(name = "SiteId")
    private Site siteid;

    public int getTechnicianid() {
        return technicianid;
    }

    public void setTechnicianid(int technicianid) {
        this.technicianid = technicianid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Site getSiteid() {
        return siteid;
    }

    public void setSiteid(Site siteid) {
        this.siteid = siteid;
    }
}
