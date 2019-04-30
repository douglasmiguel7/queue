package com.github.douglasmiguel7.queue.domain;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "BOOKING")
public class Booking implements Domain {

    @Id
    @GenericGenerator(name = "bookingSequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {@Parameter(name = "sequence_name", value = "BOOKING_SEQUENCE")})
    @GeneratedValue(generator = "bookingSequenceGenerator")
    @Column(name = "ID")
    private Long id;

    @Column(name = "CREATED_AT", nullable = false, columnDefinition = "timestamp without time zone default now()")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();

    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "SERVICE_ID", referencedColumnName = "ID", nullable = false, foreignKey = @ForeignKey(name = "BOOKING_SERVICE_FK"))
    private Service service;

    @ManyToOne(optional = false)
    @JoinColumn(name = "APP_USER_ID", referencedColumnName = "ID", nullable = false, foreignKey = @ForeignKey(name = "BOOKING_APP_USER_FK"))
    private AppUser appUser;

    @Column(name = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "CANCEL_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cancelDate;

    @Column(name = "REASON_CANCEL", columnDefinition = "text")
    private String reasonCancel;

    @ManyToOne
    @JoinColumn(name = "CANCELATION_APP_USER_ID", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "BOOKING_CANCELATION_APP_USER_FK"))
    private AppUser cancelationAppUser;

    @Override
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(Date cancelDate) {
        this.cancelDate = cancelDate;
    }

    public String getReasonCancel() {
        return reasonCancel;
    }

    public void setReasonCancel(String reasonCancel) {
        this.reasonCancel = reasonCancel;
    }

    public AppUser getCancelationAppUser() {
        return cancelationAppUser;
    }

    public void setCancelationAppUser(AppUser cancelationAppUser) {
        this.cancelationAppUser = cancelationAppUser;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Booking{");
        sb.append("id=").append(id);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", date=").append(date);
        sb.append(", cancelDate=").append(cancelDate);
        sb.append(", reasonCancel='").append(reasonCancel).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
