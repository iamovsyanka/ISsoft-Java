package by.ovsyanka.domain.cargo;

import by.ovsyanka.domain.enums.CargoType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CargoTest {

    @Test
    public void testCreateCargo() {
        Cargo cargo = Cargo.of("Seed", 2500, CargoType.BULK_CARRIERS);

        assertNotNull(cargo);
    }

    @Test
    public void testGetCargoFields() {
        String name = "Seed";
        double weight = 2500;
        Cargo cargo = Cargo.of(name, weight, CargoType.BULK_CARRIERS);

        assertEquals(name, cargo.getName());
        assertEquals(weight, cargo.getWeight());
        assertEquals(CargoType.BULK_CARRIERS, cargo.getCargoType());
    }

    @Test
    public void testValidWeight() {
        double weight = 2500;
        Cargo cargo = Cargo.of("Seed", weight, CargoType.BULK_CARRIERS);

        assertEquals(weight, cargo.getWeight());
    }

    @Test
    public void testInvalidWeight() {
        double weight = -2500;

        assertThrows(IllegalArgumentException.class, () -> Cargo.of("Seed", weight, CargoType.BULK_CARRIERS));
    }

    @Test
    public void testSetValidWeight() {
        double weight = 2500;
        Cargo cargo = Cargo.of("Seed", 2500, CargoType.BULK_CARRIERS);

        assertDoesNotThrow(() -> cargo.setWeight(weight));
    }

    @Test
    public void testSetInvalidWeight() {
        double weight = -2500;
        Cargo cargo = Cargo.of("Seed", 2500, CargoType.BULK_CARRIERS);

        assertThrows(IllegalArgumentException.class, () -> cargo.setWeight(weight));
    }

    @Test
    public void testSetName() {
        String newName = "Seed1";
        Cargo cargo = Cargo.of("Seed", 2500, CargoType.BULK_CARRIERS);
        cargo.setName(newName);

        assertEquals(newName, cargo.getName());
    }

    @Test
    public void testSetComment() {
        String comment = "The best seed";
        Cargo cargo = Cargo.of("Seed", 2500, CargoType.BULK_CARRIERS);
        cargo.setComment(comment);

        assertEquals(comment, cargo.getComment());
    }
}
