package by.ovsyanka.domain.train;

import by.ovsyanka.domain.cargo.Cargo;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;

@Slf4j
@Getter
@ToString
public class CargoCarriage extends Carriage {

    private final int maxCapacity;
    private List<Cargo> cargos;

    public CargoCarriage(int maxCapacity) {
        checkArgument(maxCapacity > 0, "Max capacity cannot be less than one");

        this.maxCapacity = maxCapacity;
        this.cargos = new ArrayList<>();

        log.info("CargoCarriage {} created", toString());
    }

    public static CargoCarriage of(int maxCapacity) {
        return new CargoCarriage(maxCapacity);
    }

    public void addCargo(Cargo cargo) {
        checkArgument(maxCapacity - getCurrentCapacity() > cargo.getWeight(), "Cargo weight is too big");

        cargos.add(cargo);

        log.info("add cargo {}", cargo);
    }

    public void removeCargo(Cargo cargo) throws Exception {
        int removeCargoIndex = cargos.indexOf(cargo);
        if (removeCargoIndex != -1) {
            cargos.remove(removeCargoIndex);
            log.info("remove cargo {}", cargo);
        } else {
            throw new Exception("Cargo not found");
        }
    }

    public int getCurrentCapacity() {
        return cargos.stream().mapToInt(cargo -> (int) cargo.getWeight()).sum();
    }
}
