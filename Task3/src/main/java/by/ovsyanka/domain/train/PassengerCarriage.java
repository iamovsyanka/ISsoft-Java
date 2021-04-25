package by.ovsyanka.domain.train;

import by.ovsyanka.domain.user.Passenger;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

@Getter
public class PassengerCarriage extends Carriage {

    private final int maxCountPlace;
    private Map<Integer, Boolean> places;

    public PassengerCarriage(int maxCountPlace) {
        checkArgument(maxCountPlace > 0, "maxCountPlace cannot be less than one");

        this.maxCountPlace = maxCountPlace;
        places = new HashMap<>();
        for (int i = 1; i <= maxCountPlace; i++) places.put(i, true);
    }

    public static PassengerCarriage of(int maxCountPlace) {
        return new PassengerCarriage(maxCountPlace);
    }

    public void addPassenger(Passenger passenger) {
        checkNotNull(passenger.getTicket(), "The hare!");
        checkArgument(passenger.getTicket().getPassengerCarriageId().equals(this.getId()),
                "The ticket is not for this carriage");
        checkArgument(passenger.getTicket().getPlace() < this.getMaxCountPlace(),
                "There is no place with this number in this carriage");

        places.put(passenger.getTicket().getPlace(), false);
    }

    public void removePassenger(Passenger passenger) {
        checkNotNull(passenger.getTicket(), "The hare!");
        checkArgument(passenger.getTicket().getPassengerCarriageId().equals(this.getId()),
                "The ticket is not for this carriage");
        checkArgument(passenger.getTicket().getPlace() < this.getMaxCountPlace(),
                "There is no place with this number in this carriage");

        places.put(passenger.getTicket().getPlace(), true);
    }
}