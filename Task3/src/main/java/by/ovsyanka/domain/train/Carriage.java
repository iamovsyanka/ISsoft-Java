package by.ovsyanka.domain.train;

import lombok.Getter;

import java.util.UUID;

@Getter
public abstract class Carriage {
    private final UUID id;

    protected Carriage() {
        this.id = UUID.randomUUID();
    }
}
