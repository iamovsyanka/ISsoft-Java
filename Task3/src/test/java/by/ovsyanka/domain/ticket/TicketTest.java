package by.ovsyanka.domain.ticket;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class TicketTest {

    @Test
    public void testCreateTicket() {
        Ticket ticket = Ticket.of(12, UUID.randomUUID());

        assertNotNull(ticket);
    }

    @Test
    public void testGetValidPlace() {
        assertEquals(12, Ticket.of(12, UUID.randomUUID()).getPlace());
    }

    @Test
    public void testGetInvalidPlace() {
        assertNotEquals(11, Ticket.of(12, UUID.randomUUID()).getPlace());
    }

    @Test
    public void testGetPassengerCarriageId() {
        UUID passengerCarriageId = UUID.randomUUID();

        assertEquals(passengerCarriageId, Ticket.of(12, passengerCarriageId).getPassengerCarriageId());
    }

    @Test
    public void testGetInvalidPassengerCarriageId() {
        UUID passengerCarriageId = UUID.randomUUID();

        assertNotEquals(passengerCarriageId, Ticket.of(12, UUID.randomUUID()).getPassengerCarriageId());
    }
}
