package com.github.douglasmiguel7.queue.domain;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity(name = "COMPANY")
public class Company {

    @Id
    @GenericGenerator(name = "companySequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {@Parameter(name = "sequence_name", value = "COMPANY_SEQUENCE")})
    @GeneratedValue(generator = "companySequenceGenerator")
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @Column(name = "OPEN_AT", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date openAt;

    @Column(name = "CLOSES_AT", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date closesAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getOpenAt() {
        return openAt;
    }

    public void setOpenAt(Date openAt) {
        this.openAt = openAt;
    }

    public Date getClosesAt() {
        return closesAt;
    }

    public void setClosesAt(Date closesAt) {
        this.closesAt = closesAt;
    }
}