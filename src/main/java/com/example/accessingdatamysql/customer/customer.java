package com.example.accessingdatamysql.customer;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class customer {
    @Id
    private Integer Cust_ID;
    private String Cust_Name;
    private String Cust_Phone;
    private String Cust_Address;

    public Integer getCust_ID() {
        return Cust_ID;
    }

    public void setCust_ID(Integer cust_ID) {
        Cust_ID = cust_ID;
    }

    public String getCust_Name() {
        return Cust_Name;
    }

    public void setCust_Name(String cust_Name) {
        Cust_Name = cust_Name;
    }

    public String getCust_Phone() {
        return Cust_Phone;
    }

    public void setCust_Phone(String cust_Phone) {
        Cust_Phone = cust_Phone;
    }

    public String getCust_Address() {
        return Cust_Address;
    }

    public void setCust_Address(String cust_Address) {
        Cust_Address = cust_Address;
    }
}
