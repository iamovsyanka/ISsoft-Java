package by.ovsyanka.service;

import by.ovsyanka.domain.Order;
import by.ovsyanka.domain.User;
import by.ovsyanka.domain.enums.OrderStatus;
import by.ovsyanka.persistence.OrderStorage;
import by.ovsyanka.persistence.UserStorage;
import by.ovsyanka.validate.OrderValidator;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Date;
import java.util.UUID;

public class OrderServiceTest {

    private Order order;
    private OrderService orderService;

    @Mock
    private OrderValidator orderValidator;

    @Mock
    private OrderStorage orderStorage;

    @Mock
    private UserStorage userStorage;

    public OrderServiceTest() {
        UUID userId = UUID.randomUUID();
        this.order = new Order(userId, OrderStatus.ON_THE_WAY, null, new Date(), null);
    }

    @BeforeEach
    public void before() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(this.orderStorage.persist((Order) Matchers.any())).thenReturn(UUID.randomUUID());
        Mockito.when(this.userStorage.persist((User) Matchers.any())).thenReturn(UUID.randomUUID());
        this.orderService = new OrderService(this.orderStorage, this.userStorage, this.orderValidator);
    }

    @Test
    public void testPlaceInvalidOrder() {
        Mockito.when(this.orderValidator.checkCreation(this.order)).thenReturn(false);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            this.orderService.placeOrder(this.order);
        });
        Mockito.verify(this.orderStorage, Mockito.never()).persist(Matchers.any());
    }

    @Test
    public void testPlaceOrder() {
        Mockito.when(this.orderValidator.checkCreation(this.order)).thenReturn(true);
        UUID id = this.orderService.placeOrder(this.order);
        Assertions.assertNotNull(id);
        Mockito.verify(this.orderStorage).persist(this.order);
        MatcherAssert.assertThat(this.order.getStatus(), CoreMatchers.is(OrderStatus.ON_THE_WAY));
    }

    @Test
    public void testLoadAllByInvalidUserId() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            this.orderService.loadAllByUserId(UUID.randomUUID());
        });
        Mockito.verify(this.orderStorage, Mockito.never()).persist(Matchers.any());
    }
}