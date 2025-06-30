package com.example.demo.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="userinventory")
public class User {
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column(name= "location")
    private String location;

     @Column(name= "product")
    private String product;

     @Column(name= "quantity")
    private Integer quantity;

    @Column(name="email")
    private String email;

    @Column(name="number")
    private Integer number;

    public User(){

    }
    
    public User( String location, String product, Integer quantity, String email, Integer number) {
        this.location = location;
        this.product = product;
        this.quantity = quantity;
        this.email = email;
        this.number = number;
    }

    public long getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public String getProduct() {
        return product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getEmail() {
        return email;
    }

    public Integer getNumber() {
        return number;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", location=" + location + ", product=" + product + ", quantity=" + quantity
                + ", email=" + email + ", number=" + number + "]";
    }

    
}