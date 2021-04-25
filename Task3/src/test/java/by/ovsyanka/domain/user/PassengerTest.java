package by.ovsyanka.domain.user;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class PassengerTest {

    @Test
    public void testCreatePassenger() {
        Passenger passenger = Passenger.of("Anna", "Ovsyanka", LocalDate.of(2001, 2, 17));

        assertNotNull(passenger);
    }

    @Test
    public void testGetPassengersFields() {
        String firstName = "Anna";
        String lastName = "Ovsyanka";
        LocalDate birthday = LocalDate.of(2001, 2, 17);
        Passenger passenger = Passenger.of(firstName, lastName, birthday);

        assertEquals(firstName, passenger.getFirstName());
        assertEquals(lastName, passenger.getLastName());
        assertEquals(birthday, passenger.getBirthday());
    }

    @Test
    public void testSetFirstName() {
        String newFirstName = "Anya";
        Passenger passenger = Passenger.of("Anna", "Ovsyanka", LocalDate.of(2001, 2, 17));
        passenger.setFirstName(newFirstName);

        assertEquals(newFirstName, passenger.getFirstName());
    }

    @Test
    public void testSetLastName() {
        String newLastName = "Anya";
        Passenger passenger = Passenger.of("Anna", "Ovsyanka", LocalDate.of(2001, 2, 17));
        passenger.setLastName(newLastName);

        assertEquals(newLastName, passenger.getLastName());
    }

    @Test
    public void testCalculateAge() {
        Passenger passenger = Passenger.of("Anna", "Ovsyanka", LocalDate.of(2001, 2, 17));

        assertEquals(20, User.calculateAge(passenger.getBirthday(), LocalDate.now()));
    }

    @Test
    public void testValidBirthday() {
        LocalDate validBirthday = LocalDate.of(2001, 2, 17);

        assertDoesNotThrow(() -> Passenger.of("Anya", "Ovsyanka", validBirthday));
    }

    @Test
    public void testFutureBirthday() {
        LocalDate futureBirthday = LocalDate.of(2050, 2, 17);

        assertThrows(IllegalArgumentException.class, () -> Passenger.of("Anya", "Ovsyanka", futureBirthday));
    }

    @Test
    public void testInvalidBirthday() {
        LocalDate invalidBirthday = LocalDate.of(1000, 2, 17);

        assertThrows(IllegalArgumentException.class, () -> Passenger.of("Anya", "Ovsyanka", invalidBirthday));
    }
}
