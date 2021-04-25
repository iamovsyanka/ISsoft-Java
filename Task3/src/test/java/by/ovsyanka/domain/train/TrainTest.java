package by.ovsyanka.domain.train;

import by.ovsyanka.domain.user.TrainDriver;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TrainTest {

    @Test
    public void testCreateTrain() {
        TrainDriver trainDriver = TrainDriver.of("Anna", "Ovsyanka", LocalDate.of(2001, 2, 17));
        Locomotive locomotive = Locomotive.of(trainDriver);

        assertNotNull(locomotive);

        Train train = Train.of(8, locomotive);

        assertNotNull(train);
    }


    @Test
    public void testInvalidMaxTrainLength() {
        TrainDriver trainDriver = TrainDriver.of("Anna", "Ovsyanka", LocalDate.of(2001, 2, 17));
        Locomotive locomotive = Locomotive.of(trainDriver);

        assertNotNull(locomotive);

        assertThrows(IllegalArgumentException.class, () -> Train.of(-1, locomotive));
    }

    @Test
    public void testInvalidLocomotive() {
        assertThrows(NullPointerException.class, () -> Train.of(10, null));
    }

    @Test
    public void testGetCurrentTrainLength() {
        TrainDriver trainDriver = TrainDriver.of("Anna", "Ovsyanka", LocalDate.of(2001, 2, 17));
        Locomotive locomotive = Locomotive.of(trainDriver);

        assertNotNull(locomotive);

        Train train = Train.of(8, locomotive);

        assertEquals(1, train.getCurrentTrainLength());
    }

    @Test
    public void testAddCarriage() {
        TrainDriver trainDriver = TrainDriver.of("Anna", "Ovsyanka", LocalDate.of(2001, 2, 17));
        Locomotive locomotive = Locomotive.of(trainDriver);

        assertNotNull(locomotive);

        Train train = Train.of(8, locomotive);
        CargoCarriage cargoCarriage = CargoCarriage.of(20000);
        train.addCarriage(cargoCarriage);

        assertEquals(2, train.getCurrentTrainLength());
    }

    @Test
    public void testAddLocomotive() {
        TrainDriver trainDriver = TrainDriver.of("Anna", "Ovsyanka", LocalDate.of(2001, 2, 17));
        Locomotive locomotive = Locomotive.of(trainDriver);
        Locomotive locomotive1 = Locomotive.of(trainDriver);

        assertNotNull(locomotive);

        Train train = Train.of(8, locomotive);

        assertThrows(IllegalArgumentException.class, () -> train.addCarriage(locomotive1));
    }
}
