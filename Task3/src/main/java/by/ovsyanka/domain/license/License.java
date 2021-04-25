package by.ovsyanka.domain.license;

import by.ovsyanka.domain.enums.LicenseType;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Slf4j
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

        log.info("License {} created", toString());
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

        log.info("License type is {}", licenseType);
        return licenseType;
    }

    @Override
    public String toString() {
        return "License{" +
                "licenseType=" + licenseType +
                ", validUntil=" + validUntil +
                '}';
    }
}
