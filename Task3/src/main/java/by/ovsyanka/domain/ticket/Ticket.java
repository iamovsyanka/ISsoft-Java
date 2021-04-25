package by.ovsyanka.domain.ticket;

import by.ovsyanka.domain.enums.TicketType;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

import static com.google.common.base.Preconditions.checkArgument;

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
    }

    public static Ticket of(int place, UUID passengerCarriageId) {
        return new Ticket(place, passengerCarriageId);
    }
}
