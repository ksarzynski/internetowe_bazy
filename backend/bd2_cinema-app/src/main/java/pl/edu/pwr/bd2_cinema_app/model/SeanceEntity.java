package pl.edu.pwr.bd2_cinema_app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pl.edu.pwr.bd2_cinema_app.dto.SeanceDTO;

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
    private int seance_id;
    private Date startDate;
    private Date endDate;
    private Integer noAvailableSeats;
    private Double price;
    @ManyToOne(targetEntity = MovieEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_seance_foreign_key", referencedColumnName = "movie_id")
    private MovieEntity movie;
    @ManyToOne(targetEntity = CinemaHallEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "cinema_hall_seance_foreign_key", referencedColumnName = "cinema_hall_id")
    private CinemaHallEntity cinemaHall;
    @JsonIgnore
    @OneToMany(targetEntity = ReservationEntity.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "seance_reservation_foreign_key", referencedColumnName = "seance_id")
    private List<ReservationEntity> reservations;
    @JsonIgnore
    @OneToMany(targetEntity = TicketEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "seance_ticket_foreign_key", referencedColumnName = "seance_id")
    private List<TicketEntity> tickets;
    private String imageUrl;

    public SeanceEntity(SeanceDTO seanceDTO){
        this.seance_id = seanceDTO.getSeance_id();
        this.startDate = seanceDTO.getStartDate();
        this.endDate = seanceDTO.getEndDate();
        this.noAvailableSeats = seanceDTO.getNoAvailableSeats();
        this.price = seanceDTO.getPrice();
        this.imageUrl = seanceDTO.getImageUrl();
    }
}
