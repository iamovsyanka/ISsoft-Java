package by.ovsyanka.persistence;

import by.ovsyanka.domain.Address;

import java.util.Optional;
import java.util.UUID;

public class AddressStore {

    public Optional<Address> findById(UUID id) {
        return Optional.empty();
    }

    public UUID persist(Address address) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public Address load(UUID id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
