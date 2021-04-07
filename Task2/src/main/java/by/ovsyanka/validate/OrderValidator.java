package by.ovsyanka.validate;

import by.ovsyanka.domain.Order;

public class OrderValidator {

    public boolean checkCreation(Order order) {
        return order.getUserId() != null && order.getDate() != null && order.getAddress() != null && order.getOrderItems() != null && order.getStatus() != null;
    }
}