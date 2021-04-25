package by.ovsyanka.domain.train;

import by.ovsyanka.domain.cargo.Cargo;
import by.ovsyanka.domain.enums.CargoType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CargoCarriageTest {

    @Test
    public void testCreateCargoCarriage() {
        CargoCarriage cargoCarriage = CargoCarriage.of(20);

        assertNotNull(cargoCarriage);
    }

    @Test
    public void testInvalidMaxCapacity() {
        assertThrows(IllegalArgumentException.class, () -> CargoCarriage.of(-10));
    }

    @Test
    public void testGetMaxCapacity() {
        assertEquals(10, CargoCarriage.of(10).getMaxCapacity());
    }

    @Test
    public void testGetInvalidMaxCapacity() {
        assertNotEquals(11, CargoCarriage.of(10).getMaxCapacity());
    }

    @Test
    public void testAddCargo() {
        CargoCarriage cargoCarriage = CargoCarriage.of(20000);
        Cargo cargo = Cargo.of("Seed", 2500, CargoType.BULK_CARRIERS);

        cargoCarriage.addCargo(cargo);

        assertEquals(List.of(cargo), cargoCarriage.getCargos());
    }

    @Test
    public void testAddInvalidCargo() {
        CargoCarriage cargoCarriage = CargoCarriage.of(2000);
        Cargo cargo = Cargo.of("Seed", 2500, CargoType.BULK_CARRIERS);

        assertThrows(IllegalArgumentException.class, () -> cargoCarriage.addCargo(cargo));
    }

    @Test
    public void testGetValidCurrentCapacity() {
        CargoCarriage cargoCarriage = CargoCarriage.of(20000);
        Cargo cargo = Cargo.of("Seed", 2500, CargoType.BULK_CARRIERS);

        cargoCarriage.addCargo(cargo);

        assertEquals(2500, cargoCarriage.getCurrentCapacity());
    }

    @Test
    public void testGetInvalidCurrentCapacity() {
        CargoCarriage cargoCarriage = CargoCarriage.of(20000);
        Cargo cargo = Cargo.of("Seed", 2500, CargoType.BULK_CARRIERS);

        cargoCarriage.addCargo(cargo);

        assertNotEquals(2000, cargoCarriage.getCurrentCapacity());
    }

    @Test
    public void testGetCurrentCapacityNull() {
        CargoCarriage cargoCarriage = CargoCarriage.of(20000);

        assertEquals(0, cargoCarriage.getCurrentCapacity());
    }

    @Test
    public void testRemoveInvalidCargo() {
        CargoCarriage cargoCarriage = CargoCarriage.of(20000);
        Cargo cargo = Cargo.of("Seed", 2500, CargoType.BULK_CARRIERS);

        assertThrows(Exception.class, () -> cargoCarriage.removeCargo(cargo));
    }

    @Test
    public void testRemoveValidCargo() throws Exception {
        CargoCarriage cargoCarriage = CargoCarriage.of(20000);
        Cargo cargo = Cargo.of("Seed", 2500, CargoType.BULK_CARRIERS);

        cargoCarriage.addCargo(cargo);

        assertDoesNotThrow(() -> cargoCarriage.removeCargo(cargo));
    }

    @Test
    public void testCurrentCapacity() throws Exception {
        CargoCarriage cargoCarriage = CargoCarriage.of(20000);
        Cargo cargo = Cargo.of("Seed", 2500, CargoType.BULK_CARRIERS);
        Cargo cargo1 = Cargo.of("Seed", 5000, CargoType.BULK_CARRIERS);

        cargoCarriage.addCargo(cargo);

        assertEquals(2500, cargoCarriage.getCurrentCapacity());

        cargoCarriage.addCargo(cargo1);

        assertEquals(7500, cargoCarriage.getCurrentCapacity());

        cargoCarriage.removeCargo(cargo);

        assertEquals(5000, cargoCarriage.getCurrentCapacity());

        cargoCarriage.removeCargo(cargo1);

        assertEquals(0, cargoCarriage.getCurrentCapacity());
    }
}
