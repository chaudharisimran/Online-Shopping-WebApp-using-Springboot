package com.example.accessingdatamysql.sales;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Sales {
    @Id
    private Integer Sales_ID;
    private Integer Cust_ID;
    private Integer Prod_ID;

    public Integer getSales_ID() {
        return Sales_ID;
    }

    public void setSales_ID(Integer sales_ID) {
        Sales_ID = sales_ID;
    }

    public Integer getCust_ID() {
        return Cust_ID;
    }

    public void setCust_ID(Integer cust_ID) {
        Cust_ID = cust_ID;
    }

    public Integer getProd_ID() {
        return Prod_ID;
    }

    public void setProd_ID(Integer prod_ID) {
        Prod_ID = prod_ID;
    }
}
