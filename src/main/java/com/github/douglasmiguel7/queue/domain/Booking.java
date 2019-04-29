package com.github.douglasmiguel7.queue.domain;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity(name = "BOOKING")
public class Booking {

    @Id
    @GenericGenerator(name = "bookingSequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {@Parameter(name = "sequence_name", value = "BOOKING_SEQUENCE")})
    @GeneratedValue(generator = "bookingSequenceGenerator")
    @Column(name = "ID")
    private Long id;

    @Column(name = "CREATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @ManyToOne(optional = false)
    @JoinColumn(name = "SERVICE_ID", referencedColumnName = "ID", nullable = false, foreignKey = @ForeignKey(name = "BOOKING_SERVICE_FK"))
    private Service service;

    @ManyToOne(optional = false)
    @JoinColumn(name = "APP_USER_ID", referencedColumnName = "ID", nullable = false, foreignKey = @ForeignKey(name = "BOOKING_APP_USER_FK"))
    private AppUser appUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
