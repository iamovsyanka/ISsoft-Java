package by.ovsyanka.domain.user;

import by.ovsyanka.domain.enums.TicketType;
import by.ovsyanka.domain.ticket.Ticket;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Slf4j
@Getter
public class Passenger extends User {

    private Ticket ticket;

    public Passenger(String firstName, String lastName, LocalDate birthday) {
        super(firstName, lastName, birthday);

        log.info("Passenger {} created", toString());
    }

    public static Passenger of(String firstName, String lastName, LocalDate birthday) {
        return new Passenger(firstName, lastName, birthday);
    }

    public Ticket buyTicket(Ticket ticket) {
        this.ticket = ticket;

        if (User.calculateAge(this.getBirthday(), LocalDate.now()) > 7) {
            ticket.setTicketType(TicketType.ADULT);
        } else {
            ticket.setTicketType(TicketType.CHILDLIKE);
        }

        log.info("Passenger {} buy ticket {}", toString(), ticket.toString());

        return this.getTicket();
    }

    public void removeTicket() {
        log.info("Passenger {} remove ticket {}", toString(), ticket.toString());

        ticket = null;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "ticket=" + ticket +
                '}';
    }
}
