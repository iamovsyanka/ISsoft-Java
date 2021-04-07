package by.ovsyanka.persistence;

import by.ovsyanka.domain.OrderItem;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

public class OrderItemStorageTest {
    private OrderItem orderItem = new OrderItem("milk", 10, 5);
    private OrderItemStorage orderItemStorage = new OrderItemStorage();

    public OrderItemStorageTest() {
    }

    @Test
    public void testPersist() {
        UUID id = this.orderItemStorage.persist(this.orderItem);
        MatcherAssert.assertThat(id, is(not(null)));
        OrderItem loaded = this.orderItemStorage.load(id);
        MatcherAssert.assertThat(loaded, CoreMatchers.is(CoreMatchers.equalTo(this.orderItem)));
    }

    @Test
    public void testFindById() {
        Optional<OrderItem> order = this.orderItemStorage.findById(UUID.randomUUID());
        MatcherAssert.assertThat(order, is(not(null)));
    }

    @Test
    public void testFindByName() {
        List<OrderItem> order = this.orderItemStorage.findByName("milk");
        MatcherAssert.assertThat(order, is(not(null)));
    }

    @Test
    public void testFindByCount() {
        List<OrderItem> order = this.orderItemStorage.findByCount(1);
        MatcherAssert.assertThat(order, is(not(null)));
    }

    @Test
    public void testFindByPrice() {
        List<OrderItem> order = this.orderItemStorage.findByPrice(1);
        MatcherAssert.assertThat(order, is(not(null)));
    }
}
