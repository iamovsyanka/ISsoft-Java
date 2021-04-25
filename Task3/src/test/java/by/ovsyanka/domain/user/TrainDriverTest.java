package by.ovsyanka.domain.user;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TrainDriverTest {

    @Test
    public void testCreateTrainDriver() {
        TrainDriver trainDriver = TrainDriver.of("Anna", "Ovsyanka", LocalDate.of(2001, 2, 17));

        assertNotNull(trainDriver);
    }

    @Test
    public void testGetTrainDriversFields() {
        String firstName = "Anna";
        String lastName = "Ovsyanka";
        LocalDate birthday = LocalDate.of(2001, 2, 17);
        TrainDriver trainDriver = TrainDriver.of(firstName, lastName, birthday);

        assertEquals(firstName, trainDriver.getFirstName());
        assertEquals(lastName, trainDriver.getLastName());
        assertEquals(birthday, trainDriver.getBirthday());
    }

    @Test
    public void testSetFirstName() {
        String newFirstName = "Anya";
        TrainDriver trainDriver = TrainDriver.of("Anna", "Ovsyanka", LocalDate.of(2001, 2, 17));
        trainDriver.setFirstName(newFirstName);

        assertEquals(newFirstName, trainDriver.getFirstName());
    }

    @Test
    public void testSetLastName() {
        String newLastName = "Anya";
        TrainDriver trainDriver = TrainDriver.of("Anna", "Ovsyanka", LocalDate.of(2001, 2, 17));
        trainDriver.setLastName(newLastName);

        assertEquals(newLastName, trainDriver.getLastName());
    }

    @Test
    public void testInvalidBirthday() {
        LocalDate invalidBirthday = LocalDate.of(2015, 2, 17);

        assertThrows(IllegalArgumentException.class, () -> TrainDriver.of("Anya", "Ovsyanka", invalidBirthday));
    }

    @Test
    public void testValidBirthday() {
        LocalDate validBirthday = LocalDate.of(2001, 2, 17);

        assertDoesNotThrow(() -> TrainDriver.of("Anya", "Ovsyanka", validBirthday));
    }
}
