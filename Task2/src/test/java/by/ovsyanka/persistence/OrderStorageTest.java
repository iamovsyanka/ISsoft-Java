package by.ovsyanka.persistence;

import by.ovsyanka.domain.Address;
import by.ovsyanka.domain.Order;
import by.ovsyanka.domain.OrderItem;
import by.ovsyanka.domain.enums.OrderStatus;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;

public class OrderStorageTest {
    private Order order;
    private OrderStorage orderStorage;

    public OrderStorageTest() {
        this.order = new Order(UUID.randomUUID(), OrderStatus.ON_THE_WAY, (OrderItem[])null, new Date(), (Address)null);
        this.orderStorage = new OrderStorage();
    }

    @Test
    public void testPersist() {
        UUID id = this.orderStorage.persist(this.order);
        MatcherAssert.assertThat(id, is(not(null)));
        Order loaded = this.orderStorage.load(id);
        MatcherAssert.assertThat(loaded, is(equalTo(this.order)));
    }

    @Test
    public void testFindByUserId() {
        List<Order> order = this.orderStorage.findByUserId(UUID.randomUUID());
        MatcherAssert.assertThat(order, is(not(null)));
    }

    @Test
    public void testFindByDate() {
        List<Order> order = this.orderStorage.findByDate(new Date());
        MatcherAssert.assertThat(order, is(not(null)));
    }

    @Test
    public void testFindByStatus() {
        List<Order> order = this.orderStorage.findByStatus(OrderStatus.ON_THE_WAY);
        MatcherAssert.assertThat(order, is(not(null)));
    }

    @Test
    public void testFindById() {
        Optional<Order> order = this.orderStorage.findById(UUID.randomUUID());
        MatcherAssert.assertThat(order, is(not(null)));
    }
}
