package by.ovsyanka.domain.train;

import by.ovsyanka.domain.user.TrainDriver;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class LocomotiveTest {

    @Test
    public void testCreateLocomotive() {
        TrainDriver trainDriver = TrainDriver.of("Anna", "Ovsyanka",
                LocalDate.of(2001, 2, 17),
                LocalDate.of(2022, 12, 12));
        Locomotive locomotive = Locomotive.of(trainDriver);

        assertNotNull(locomotive);
    }

    @Test
    public void testNullTrainDriver() {
        TrainDriver trainDriver = null;

        assertThrows(NullPointerException.class, () -> Locomotive.of(trainDriver));
    }

    @Test
    public void testSetNullTrainDriver() {
        TrainDriver trainDriver = TrainDriver.of("Anna", "Ovsyanka",
                LocalDate.of(2001, 2, 17),
                LocalDate.of(2022, 12, 12));
        Locomotive locomotive = Locomotive.of(trainDriver);

        assertThrows(NullPointerException.class, () -> locomotive.setTrainDriver(null));
    }

    @Test
    public void testSetTrainDriver() {
        TrainDriver trainDriver = TrainDriver.of("Anna", "Ovsyanka",
                LocalDate.of(2001, 2, 17),
                LocalDate.of(2022, 12, 12));
        TrainDriver trainDriver1 = TrainDriver.of("Anna", "Ovsyanka",
                LocalDate.of(2001, 2, 17),
                LocalDate.of(2022, 12, 12));
        Locomotive locomotive = Locomotive.of(trainDriver);

        assertDoesNotThrow(() -> locomotive.setTrainDriver(trainDriver1));
    }

    @Test
    public void testGetTrainDriver() {
        TrainDriver trainDriver = TrainDriver.of("Anna", "Ovsyanka",
                LocalDate.of(2001, 2, 17),
                LocalDate.of(2022, 12, 12));
        Locomotive locomotive = Locomotive.of(trainDriver);

        assertEquals(trainDriver, locomotive.getTrainDriver());
    }
}
