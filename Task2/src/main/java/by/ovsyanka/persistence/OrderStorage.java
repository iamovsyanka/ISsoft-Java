package by.ovsyanka.persistence;

import by.ovsyanka.domain.Address;
import by.ovsyanka.domain.Order;
import by.ovsyanka.domain.enums.OrderStatus;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class OrderStorage {

    public Optional<Order> findById(UUID id) {
        return Optional.empty();
    }

    public List<Order> findByDate(Date date) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public List<Order> findByStatus(OrderStatus orderStatus) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public List<Order> findByUserId(UUID userId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public List<Order> findByAddress(Address address) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public UUID persist(Order order) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public Order load(UUID id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
