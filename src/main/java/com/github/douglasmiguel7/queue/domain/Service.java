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
import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "SERVICE")
public class Service {

    @Id
    @GenericGenerator(name = "serviceSequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {@Parameter(name = "sequence_name", value = "SERVICE_SEQUENCE")})
    @GeneratedValue(generator = "serviceSequenceGenerator")
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne(optional = false)
    @JoinColumn(name = "COMPANY_ID", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "SERVICE_COMPANY_FK"))
    private Company company;

    @Column(name = "ENDLESS", columnDefinition = "boolean default true")
    private Boolean endless = Boolean.TRUE;

    @Column(name = "END_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endAt;

    @Column(name = "PRICE")
    private BigDecimal price;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Boolean getEndless() {
        return endless;
    }

    public void setEndless(Boolean endless) {
        this.endless = endless;
    }

    public Date getEndAt() {
        return endAt;
    }

    public void setEndAt(Date endAt) {
        this.endAt = endAt;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}