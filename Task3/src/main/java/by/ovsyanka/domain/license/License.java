package by.ovsyanka.domain.license;

import by.ovsyanka.domain.enums.LicenseType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
public class License {

    private LicenseType licenseType;
    @Setter
    private LocalDate validUntil;

    public License(LocalDate validUntil) {
        this.validUntil = validUntil;
        if (LocalDate.now().isBefore(validUntil)) {
            licenseType = LicenseType.VALID;
        } else {
            licenseType = LicenseType.INVALID;
        }
    }

    public static License of(LocalDate validUntil) {
        return new License(validUntil);
    }

    public LicenseType checkLicense() {
        if (LocalDate.now().isBefore(validUntil)) {
            licenseType = LicenseType.VALID;
        } else {
            licenseType = LicenseType.INVALID;
        }

        return licenseType;
    }
}
