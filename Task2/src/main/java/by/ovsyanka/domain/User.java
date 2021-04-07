package by.ovsyanka.domain;

import java.util.UUID;

public class User {
    private final UUID id = UUID.randomUUID();
    private String firstName;
    private String lastName;
    private int phone;

    public User(String firstName, String lastName, int phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public UUID getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getPhone() {
        return this.phone;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}