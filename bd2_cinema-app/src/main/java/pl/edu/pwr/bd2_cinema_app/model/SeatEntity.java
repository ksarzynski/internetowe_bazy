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
@Table(name = "SEATS")
public class SeatEntity {

    @Id
    @GeneratedValue
    private int seat_id;
    private String myRowNumber;
    private String myColumnNumber;
    private boolean isPremium;
    private float seatFee;
    @ManyToMany(mappedBy = "reservationSeats")
    private List<ReservationEntity> reservationsThatIncludeThisSeat;
    @ManyToMany(mappedBy = "ticketSeats")
    private List<TicketEntity> ticketsThatIncludeThisSeat;
}
