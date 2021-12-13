package pl.edu.pwr.bd2_cinema_app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Integer seat_id;
    private String myRowNumber;
    private String myColumnNumber;
    private boolean isPremium;
    private float seatFee;

    @ManyToOne(targetEntity = CinemaHallEntity.class, cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "cinema_hall_seat_foreign_key", referencedColumnName = "cinema_hall_id")
    private Integer cinemaHallSeatForeignKey;

    @ManyToMany(mappedBy = "reservationSeats")
    @JsonIgnore
    private List<ReservationEntity> reservationsThatIncludeThisSeat;
    @ManyToMany(mappedBy = "ticketSeats")
    @JsonIgnore
    private List<TicketEntity> ticketsThatIncludeThisSeat;
}
