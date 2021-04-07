package by.ovsyanka.domain;

import by.ovsyanka.domain.enums.OrderStatus;

import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

public class Order {
    private final UUID id = UUID.randomUUID();
    private UUID userId;
    private OrderStatus status;
    private OrderItem[] orderItems;
    private Date date;
    private Address address;
    private String comment;

    public Order(UUID userId, OrderStatus status, OrderItem[] orderItems, Date date, Address address) {
        this.userId = userId;
        this.status = status;
        this.orderItems = orderItems;
        this.date = date;
        this.address = address;
    }

    public UUID getId() {
        return this.id;
    }

    public UUID getUserId() {
        return this.userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public OrderStatus getStatus() {
        return this.status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public OrderItem[] getOrderItems() {
        return this.orderItems;
    }

    public void setOrderItems(OrderItem[] orderItems) {
        this.orderItems = orderItems;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String toString() {
        UUID var10000 = this.id;
        return "Order{id=" + var10000 + ", userId=" + this.userId + ", status=" + this.status + ", orderItems=" + Arrays.toString(this.orderItems) + ", date=" + this.date + ", address=" + this.address + ", comment='" + this.comment + "'}";
    }
}

