package by.ovsyanka.domain.user;

import by.ovsyanka.domain.enums.TicketType;
import by.ovsyanka.domain.ticket.Ticket;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Passenger extends User {

    private Ticket ticket;

    public Passenger(String firstName, String lastName, LocalDate birthday) {
        super(firstName, lastName, birthday);
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

        return this.getTicket();
    }

    public void removeTicket() {
        ticket = null;
    }
}
