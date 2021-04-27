package by.ovsyanka.domain.user;

import by.ovsyanka.domain.enums.TicketType;
import by.ovsyanka.domain.ticket.Ticket;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Slf4j
@Getter
@ToString
public class Passenger extends User {

    private Ticket ticket;

    public Passenger(String firstName, String lastName, LocalDate birthday) {
        super(firstName, lastName, birthday);

        log.info("Passenger {} created", toString());
    }

    public static Passenger of(String firstName, String lastName, LocalDate birthday) {
        return new Passenger(firstName, lastName, birthday);
    }

    public void buyTicket(Ticket ticket) {
        this.ticket = ticket;

        if (User.calculateAge(this.getBirthday(), LocalDate.now()) > 7) {
            ticket.setTicketType(TicketType.ADULT);
        } else {
            ticket.setTicketType(TicketType.CHILDLIKE);
        }

        log.info("Passenger {} buy ticket {}", toString(), ticket);
    }

    public void removeTicket() {
        log.info("Passenger {} remove ticket {}", toString(), ticket);

        ticket = null;
    }
}
