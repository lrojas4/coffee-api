package com.coffee.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
// SQL table name
@Table(name = "orders")
public class Order {

    // Creates a table with id, order date, quantity,
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private LocalDate orderDate;

    @Column
    private int quantity;

    @OneToMany(mappedBy = "order", orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Coffee> coffeeList;

    // Many-to-one relationship with user
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    // gets user
    public User getUser() {
        return user;
    }

    // sets user
    public void setUser(User user) {
        this.user = user;
    }

    // Default constructor
    public Order() {
    }

    // Constructor
    public Order(Long id, String name, LocalDate orderDate, int quantity) {
        this.id = id;
        this.name = name;
        this.orderDate = orderDate;
        this.quantity = quantity;
    }

    // gets order id
    public Long getId() {
        return id;
    }

    // sets order id
    public void setId(Long id) {
        this.id = id;
    }

    // gets order name
    public String getName() {
        return name;
    }

    // sets order name
    public void setName(String name) {
        this.name = name;
    }

    // gets order date
    public LocalDate getOrderDate() {
        return orderDate;
    }

    // sets order date
    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    // gets order quantity
    public int getQuantity() {
        return quantity;
    }

    // sets order quantity
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Coffee> getCoffeeList() {
        return coffeeList;
    }

    public void setCoffeeList(List<Coffee> coffeeList) {
        this.coffeeList = coffeeList;
    }

    // returns string representation
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", orderDate=" + orderDate +
                ", quantity=" + quantity +
                '}';
    }
}
