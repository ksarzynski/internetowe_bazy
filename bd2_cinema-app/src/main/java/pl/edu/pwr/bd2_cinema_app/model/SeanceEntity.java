package pl.edu.pwr.bd2_cinema_app.model;

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
@Table(name = "SEANCES")
public class SeanceEntity {

    @Id
    @GeneratedValue
    private int seanceId;
    // We assume that its proper class to store date and time. It may be changed in the future
    private Date startDate;
    private Date endDate;
    private Integer noAvailableSeats;
    private Double price;
    @OneToMany(targetEntity = ReservationEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "seance_reservation_foreign_key", referencedColumnName = "seanceId")
    private List<ReservationEntity> reservations;
    @OneToMany(targetEntity = TicketEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "seance_ticket_foreign_key", referencedColumnName = "seanceId")
    private List<TicketEntity> tickets;
}
