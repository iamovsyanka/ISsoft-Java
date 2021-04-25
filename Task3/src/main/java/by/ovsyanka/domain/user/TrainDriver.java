package by.ovsyanka.domain.user;

import java.time.LocalDate;

import static com.google.common.base.Preconditions.checkArgument;

public class TrainDriver extends User {

    public TrainDriver(String firstName, String lastName, LocalDate birthday) {
        super(birthday);
        checkArgument(birthday.getYear() <= LocalDate.now().getYear() - 18, "Age must be > 18");

        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    public static TrainDriver of(String firstName, String lastName, LocalDate birthday) {
        return new TrainDriver(firstName, lastName, birthday);
    }
}
