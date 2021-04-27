package by.ovsyanka.domain.cargo;

import by.ovsyanka.domain.enums.CargoType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

import static com.google.common.base.Preconditions.checkArgument;

@Slf4j
@Getter
@ToString
public class Cargo {

    private final UUID id;
    @Setter
    private String name;
    private double weight;
    private final CargoType cargoType;
    @Setter
    private String comment;

    public Cargo(String name, double weight, CargoType cargoType) {
        checkArgument(weight > 0, "Weight cannot be less than one");
        this.id = UUID.randomUUID();
        this.name = name;
        this.weight = weight;
        this.cargoType = cargoType;

        log.info("Cargo {} created", toString());
    }

    public static Cargo of(String name, double weight, CargoType cargoType) {
        return new Cargo(name, weight, cargoType);
    }

    public void setWeight(double weight) {
        checkArgument(weight > 0, "Weight cannot be less than one");
        this.weight = weight;
    }
}
