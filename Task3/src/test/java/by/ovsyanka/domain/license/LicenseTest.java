package by.ovsyanka.domain.license;

import by.ovsyanka.domain.enums.LicenseType;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LicenseTest {

    @Test
    public void testCreateLicense() {
        License license = License.of(LocalDate.of(2022, 12, 12));

        assertNotNull(license);
    }

    @Test
    public void testCheckValidLicense() {
        License license = License.of(LocalDate.of(2022, 12, 12));

        assertEquals(LicenseType.VALID, license.checkLicense());
    }

    @Test
    public void testCheckInvalidLicense() {
        License license = License.of(LocalDate.of(2012, 12, 12));

        assertEquals(LicenseType.INVALID, license.checkLicense());
    }

    @Test
    public void testValidLicense() {
        License license = License.of(LocalDate.of(2022, 12, 12));

        assertEquals(LicenseType.VALID, license.getLicenseType());
    }

    @Test
    public void testInvalidLicense() {
        License license = License.of(LocalDate.of(2012, 12, 12));

        assertEquals(LicenseType.INVALID, license.getLicenseType());
    }
}