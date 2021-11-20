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
    private int seatId;
    private String row;
    private String column;
    private Boolean isPremium;
    private Double seatFee;
    @ManyToMany(mappedBy = "seats")
    private List<ReservationEntity> reservationsThatIncludeThisSeat;
    @ManyToMany(mappedBy = "seats")
    private List<TicketEntity> ticketsThatIncludeThisSeat;
}
