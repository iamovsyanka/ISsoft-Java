package by.ovsyanka.domain.ticket;

import by.ovsyanka.domain.enums.TicketType;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

import static com.google.common.base.Preconditions.checkArgument;

@Slf4j
@Getter
public class Ticket {

    private final UUID id;
    private final int place;
    private final UUID passengerCarriageId;
    @Setter
    private TicketType ticketType;

    public Ticket(int place, UUID passengerCarriageId) {
        checkArgument(place > 0, "Place must be > 0");

        this.place = place;
        this.passengerCarriageId = passengerCarriageId;
        this.id = UUID.randomUUID();

        log.info("Ticket {} created", toString());
    }

    public static Ticket of(int place, UUID passengerCarriageId) {
        return new Ticket(place, passengerCarriageId);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", place=" + place +
                ", passengerCarriageId=" + passengerCarriageId +
                ", ticketType=" + ticketType +
                '}';
    }
}
