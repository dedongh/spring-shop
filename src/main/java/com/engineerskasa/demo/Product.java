package com.engineerskasa.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    private Integer product_id;
    private Integer product_quantity;
    private String product_name;
    private Double product_price;
    private String product_description;

    public Product() {
    }

    public Product(Integer product_id,Integer product_quantity, String product_name,
                   Double product_price, String product_description) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_description = product_description;
        this.product_quantity = product_quantity;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(Double product_price) {
        this.product_price = product_price;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public Integer getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(Integer product_quantity) {
        this.product_quantity = product_quantity;
    }
}
