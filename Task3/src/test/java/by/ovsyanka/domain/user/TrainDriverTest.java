package by.ovsyanka.domain.user;

import by.ovsyanka.domain.enums.LicenseType;
import by.ovsyanka.domain.license.License;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TrainDriverTest {

    @Test
    public void testCreateTrainDriver() {
        TrainDriver trainDriver = TrainDriver.of("Anna", "Ovsyanka",
                LocalDate.of(2001, 2, 17),
                LocalDate.of(2022, 12, 12));

        assertNotNull(trainDriver);
    }

    @Test
    public void testGetTrainDriversFields() {
        String firstName = "Anna";
        String lastName = "Ovsyanka";
        LocalDate birthday = LocalDate.of(2001, 2, 17);
        LocalDate licenseUntil = LocalDate.of(2022, 12, 12);
        TrainDriver trainDriver = TrainDriver.of(firstName, lastName, birthday, licenseUntil);

        assertEquals(firstName, trainDriver.getFirstName());
        assertEquals(lastName, trainDriver.getLastName());
        assertEquals(birthday, trainDriver.getBirthday());
        assertEquals(licenseUntil, trainDriver.getLicense().getValidUntil());
    }

    @Test
    public void testSetFirstName() {
        String newFirstName = "Anya";
        TrainDriver trainDriver = TrainDriver.of("Anna", "Ovsyanka",
                LocalDate.of(2001, 2, 17),
                LocalDate.of(2022, 12, 12));
        trainDriver.setFirstName(newFirstName);

        assertEquals(newFirstName, trainDriver.getFirstName());
    }

    @Test
    public void testSetLastName() {
        String newLastName = "Anya";
        TrainDriver trainDriver = TrainDriver.of("Anna", "Ovsyanka",
                LocalDate.of(2001, 2, 17),
                LocalDate.of(2022, 12, 12));
        trainDriver.setLastName(newLastName);

        assertEquals(newLastName, trainDriver.getLastName());
    }

    @Test
    public void testInvalidBirthday() {
        LocalDate invalidBirthday = LocalDate.of(2015, 2, 17);

        assertThrows(IllegalArgumentException.class, () -> TrainDriver.of("Anya", "Ovsyanka",
                invalidBirthday,
                LocalDate.of(2022, 12, 12)));
    }

    @Test
    public void testValidBirthday() {
        LocalDate validBirthday = LocalDate.of(2001, 2, 17);

        assertDoesNotThrow(() -> TrainDriver.of("Anya", "Ovsyanka",
                validBirthday,
                LocalDate.of(2022, 12, 12)));
    }

    @Test
    public void testValidLicense() {
        LocalDate validLicense = LocalDate.of(2022, 12, 12);

        assertDoesNotThrow(() -> TrainDriver.of("Anya", "Ovsyanka",
                LocalDate.of(2001, 2, 17),
                validLicense));
    }

    @Test
    public void testInvalidLicense() {
        LocalDate invalidLicense = LocalDate.of(2000, 12, 12);

        assertThrows(IllegalArgumentException.class, () -> TrainDriver.of("Anya", "Ovsyanka",
                LocalDate.of(2001, 2, 17),
                invalidLicense));
    }

    @Test
    public void testGetValidLicense() {
        LocalDate validLicense = LocalDate.of(2022, 12, 12);

        TrainDriver trainDriver = TrainDriver.of("Anya", "Ovsyanka",
                LocalDate.of(2001, 2, 17),
                validLicense);

        assertEquals(LicenseType.VALID, trainDriver.getLicense().checkLicense());
    }
}
