package com.customer_management_app.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty
    private long id;

    @Column(nullable = false, unique = false)
    @JsonProperty
    private String forename;

    @Column(nullable = false, unique = false)
    @JsonProperty
    private String surname;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Set<Account> accounts;

    @Column
    private Date date;

    public Customer(long id, String forename, String surname, Date date) {
        this.id = id;
        this.forename = forename;
        this.surname = surname;
        this.date = date;
    }

    public Customer() {
        this.accounts = new HashSet<>();
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }
}
