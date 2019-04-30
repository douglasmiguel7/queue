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
import javax.persistence.Table;

@Entity
@Table(name = "APP_USER")
public class AppUser implements Domain {

    @Id
    @GenericGenerator(name = "appUserSequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {@Parameter(name = "sequence_name", value = "APP_USER_SEQUENCE")})
    @GeneratedValue(generator = "appUserSequenceGenerator")
    @Column(name = "ID")
    private Long id;

    @Column(name = "NICKNAME", nullable = false)
    private String nickname;

    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "COMPANY_ID", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "APP_USER_COMPANY_FK"))
    private Company company;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
