package com.example.accessingdatamysql.product;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class product {
    @Id
    private Integer Prod_ID;
    private String Prod_Name;
    private String Colour;
    private String Size;
    private String Price;
    private String Company;

    public Integer getProd_ID() {
        return Prod_ID;
    }

    public void setProd_ID(Integer prod_ID) {
        Prod_ID = prod_ID;
    }

    public String getProd_Name() {
        return Prod_Name;
    }

    public void setProd_Name(String prod_Name) {
        Prod_Name = prod_Name;
    }

    public String getColour() {
        return Colour;
    }

    public void setColour(String colour) {
        Colour = colour;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String size) {
        Size = size;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }
}
