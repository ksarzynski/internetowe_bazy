package pl.edu.pwr.bd2_cinema_app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pl.edu.pwr.bd2_cinema_app.dto.SeatDTO;

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
    @ManyToMany(mappedBy = "reservationSeats", cascade = CascadeType.MERGE)
    @JsonIgnore
    private List<ReservationEntity> reservationsThatIncludeThisSeat;
    @ManyToMany(mappedBy = "ticketSeats")
    @JsonIgnore
    private List<TicketEntity> ticketsThatIncludeThisSeat;
    public SeatEntity(SeatDTO newSeat){
        this.seat_id = newSeat.getSeat_id();
        this.myRowNumber = newSeat.getMyRowNumber();
        this.myColumnNumber = newSeat.getMyColumnNumber();
        this.isPremium = newSeat.isPremium();
        this.seatFee = newSeat.getSeatFee();
    }
}
