package by.ovsyanka.domain.train;

import by.ovsyanka.domain.ticket.Ticket;
import by.ovsyanka.domain.user.Passenger;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class PassengerCarriageTest {

    @Test
    public void testCreatePassengerCarriage() {
        PassengerCarriage passengerCarriage = PassengerCarriage.of(20);

        assertNotNull(passengerCarriage);
    }

    @Test
    public void testInvalidMaxCountPlace() {
        assertThrows(IllegalArgumentException.class, () -> PassengerCarriage.of(-1));
    }

    @Test
    public void testGetMaxCountPlace() {
        assertEquals(10, PassengerCarriage.of(10).getMaxCountPlace());
    }

    @Test
    public void testAddPassenger() {
        Passenger passenger = Passenger.of("Anna", "Ovsyanka", LocalDate.of(2001, 2, 17));
        PassengerCarriage passengerCarriage = PassengerCarriage.of(20);
        Ticket ticket = Ticket.of(10, passengerCarriage.getId());
        passenger.setTicket(ticket);

        assertEquals(ticket, passenger.getTicket());

        passengerCarriage.addPassenger(passenger);

        assertEquals(false, passengerCarriage.getPlaces().get(ticket.getPlace()));
    }

    @Test
    public void testAddInvalidPassenger() {
        Passenger passenger = Passenger.of("Anna", "Ovsyanka", LocalDate.of(2001, 2, 17));
        PassengerCarriage passengerCarriage = PassengerCarriage.of(20);
        Ticket ticket = Ticket.of(10, UUID.randomUUID());
        passenger.setTicket(ticket);

        assertEquals(ticket, passenger.getTicket());

        assertThrows(IllegalArgumentException.class, () -> passengerCarriage.addPassenger(passenger));
    }
}
