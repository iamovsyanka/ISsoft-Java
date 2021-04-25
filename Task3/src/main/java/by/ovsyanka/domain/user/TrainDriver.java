package by.ovsyanka.domain.user;

import by.ovsyanka.domain.license.License;
import lombok.Getter;

import java.time.LocalDate;

import static com.google.common.base.Preconditions.checkArgument;

@Getter
public class TrainDriver extends User {

    private License license;

    public TrainDriver(String firstName, String lastName, LocalDate birthday, LocalDate validUntil) {
        super(birthday);
        checkArgument(birthday.getYear() <= LocalDate.now().getYear() - 18, "Age must be > 18");
        checkArgument(validUntil.isAfter(LocalDate.now()), "The driver must have a valid license");

        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.license = License.of(validUntil);
    }

    public static TrainDriver of(String firstName, String lastName, LocalDate birthday, LocalDate validUntil) {
        return new TrainDriver(firstName, lastName, birthday, validUntil);
    }
}
