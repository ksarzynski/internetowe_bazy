package pl.edu.pwr.bd2_cinema_app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "RESERVATIONS")
public class ReservationEntity {

    @Id
    @GeneratedValue
    private int reservation_id;
    private Date date;
    private Double ticketPrice;
    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name= "reservation_seat",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "seat_id")
    )
    private List<SeatEntity> reservationSeats;

    @ManyToOne(targetEntity = SeanceEntity.class, cascade = CascadeType.MERGE)
    @JsonIgnore
    @JoinColumn(name = "seance_reservation_foreign_key", referencedColumnName = "seance_id")
    private SeanceEntity reservationSeance;

}
