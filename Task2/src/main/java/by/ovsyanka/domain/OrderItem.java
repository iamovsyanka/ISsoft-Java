package by.ovsyanka.domain;

import java.util.UUID;

import static com.google.common.base.Preconditions.checkArgument;

public class OrderItem {
    private final UUID id = UUID.randomUUID();
    private String name;
    private int count;
    private int price;

    public OrderItem(String name, int count, int price) {
        checkArgument(count > 0, "Count of orderItem must be > 0");
        checkArgument(price > 0, "Price of orderItem must be > 0");
        this.name = name;
        this.count = count;
        this.price = price;
    }

    public UUID getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        checkArgument(count > 0, "Count of orderItem must be > 0");
        this.count = count;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        checkArgument(price > 0, "Price of orderItem must be > 0");
        this.price = price;
    }
}

