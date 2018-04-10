package com.modal;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "persons")
public class Persons implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String fname;
    String lname;
    String address;

    public Persons(String fname, String lname, String address) {
        this.fname = fname;
        this.lname = lname;
        this.address = address;
    }

    public Persons() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
