package by.ovsyanka.service;

import by.ovsyanka.domain.Order;
import by.ovsyanka.domain.User;
import by.ovsyanka.logger.SimpleLogger;
import by.ovsyanka.persistence.OrderStorage;
import by.ovsyanka.persistence.UserStorage;
import by.ovsyanka.validate.OrderValidator;
import com.google.common.base.Preconditions;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class OrderService {
    private final OrderStorage orderStorage;
    private final UserStorage userStorage;
    private final OrderValidator orderValidator;

    public OrderService(OrderStorage orderStorage, UserStorage userStorage, OrderValidator orderValidator) {
        this.orderStorage = orderStorage;
        this.userStorage = userStorage;
        this.orderValidator = orderValidator;
    }

    public UUID placeOrder(Order order) {
        SimpleLogger.writeLog("placeOrder parameter: " + order.toString());
        if (!this.orderValidator.checkCreation(order)) {
            throw new IllegalArgumentException("Order is not valid " + order + "\nPlease, check data");
        } else {
            UUID id = this.orderStorage.persist(order);
            SimpleLogger.writeLog("placeOrder return: " + id);
            return id;
        }
    }

    public List<Order> loadAllByUserId(UUID userId) {
        SimpleLogger.writeLog("loadAllByUserId parameter: " + userId);
        Optional<User> user = this.userStorage.findById(userId);
        Preconditions.checkState(user.isEmpty(), "User is not found");
        List<Order> orders = this.orderStorage.findByUserId(userId);
        SimpleLogger.writeLog("loadAllByUserId return: " + orders);
        return orders;
    }
}
