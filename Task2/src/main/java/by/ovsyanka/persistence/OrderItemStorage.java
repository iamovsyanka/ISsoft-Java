package by.ovsyanka.persistence;

import by.ovsyanka.domain.OrderItem;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class OrderItemStorage {

    public Optional<OrderItem> findById(UUID id) {
        return Optional.empty();
    }

    public List<OrderItem> findByName(String name) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public List<OrderItem> findByCount(int count) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public List<OrderItem> findByPrice(int price) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public UUID persist(OrderItem orderItem) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public OrderItem load(UUID id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
