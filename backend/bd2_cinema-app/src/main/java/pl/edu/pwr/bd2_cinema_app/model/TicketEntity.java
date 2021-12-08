package pl.edu.pwr.bd2_cinema_app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "TICKETS")
public class TicketEntity {

    @Id
    @GeneratedValue
    private int ticket_id;
    private Double price;
    @ManyToMany
    @JoinTable(
            name= "ticket_seat",
            joinColumns = @JoinColumn(name = "ticket_id"),
            inverseJoinColumns = @JoinColumn(name = "seat_id")
    )
    private List<SeatEntity> ticketSeats;
}
