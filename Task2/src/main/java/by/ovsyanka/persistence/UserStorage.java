package by.ovsyanka.persistence;

import by.ovsyanka.domain.User;

import java.util.Optional;
import java.util.UUID;

public class UserStorage {

    public Optional<User> findById(UUID id) {
        return Optional.empty();
    }

    public UUID persist(User user) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public User load(UUID id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}