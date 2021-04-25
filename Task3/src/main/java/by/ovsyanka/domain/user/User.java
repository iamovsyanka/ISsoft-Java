package by.ovsyanka.domain.user;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

import static com.google.common.base.Preconditions.checkArgument;

@Getter
@Setter
public abstract class User {

    private final UUID id;
    private String firstName;
    private String lastName;
    private final LocalDate birthday;

    protected User(String firstName, String lastName, LocalDate birthday) {
        checkArgument(birthday.getYear() <= LocalDate.now().getYear(), "Age must be positive");
        checkArgument(birthday.getYear() >= LocalDate.now().getYear() - 125, "Age must be <= 125");

        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    protected User(LocalDate birthday) {
        checkArgument(birthday.getYear() <= LocalDate.now().getYear(), "Age must be positive");
        checkArgument(birthday.getYear() >= LocalDate.now().getYear() - 125, "Age must be <= 125");

        this.birthday = birthday;
        this.id = UUID.randomUUID();
    }

    public static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }
}
