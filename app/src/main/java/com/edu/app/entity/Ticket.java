package com.edu.app.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.*;
import java.security.Timestamp;
@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TicketId")
    private int ticketid;


    @NotBlank(message = "El status no puede estar en blanco")
    @Size(min = 1, message = "El status no puede estar vacío")
    @Column(name = "Status")
    private String status;



    @Temporal(TemporalType.Date)
    @Column(name = "OpenedDate")
    private Timestamp openeddate;

    @Temporal(TemporalType.Date)
    @Column(name = "ClosedDate")
    private Timestamp closeddate;
    @ManyToOne
    @JoinColumn(name = "SiteId", referencedColumnName = "SiteId",
            insertable = false, updatable = false)
    private Ticket siteid;

    @ManyToOne
    @JoinColumn(name = "TechnicianID", referencedColumnName = "TechnicianID",
            insertable = false, updatable = false)
    private Technician technicianid;

    public int getTicketid() {
        return ticketid;
    }

    public void setTicketid(int ticketid) {
        this.ticketid = ticketid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getOpeneddate() {
        return openeddate;
    }

    public void setOpeneddate(Timestamp openeddate) {
        this.openeddate = openeddate;
    }

    public Timestamp getCloseddate() {
        return closeddate;
    }

    public void setCloseddate(Timestamp closeddate) {
        this.closeddate = closeddate;
    }

    public com.edu.app.entity.Ticket getSiteid() {
        return siteid;
    }

    public void setSiteid(com.edu.app.entity.Ticket siteid) {
        this.siteid = siteid;
    }

    public Technician getTechnicianid() {
        return technicianid;
    }

    public void setTechnicianid(Technician technicianid) {
        this.technicianid = technicianid;
    }
}
