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
@Table(name = "CINEMA_HALLS")
public class CinemaHallEntity {

    @Id
    @GeneratedValue
    private int cinema_hall_id;
    private String name;
    private Integer size;
    private boolean is3d;
    @OneToMany(targetEntity = SeanceEntity.class, cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "cinema_hall_seance_foreign_key", referencedColumnName = "cinema_hall_id")
    private List<SeanceEntity> seances;

    @OneToMany(targetEntity = SeatEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "cinema_hall_seat_foreign_key", referencedColumnName = "cinema_hall_id")
    private List<SeatEntity> seats;
    @ManyToOne(targetEntity = SeanceEntity.class, cascade = CascadeType.MERGE)
    @JsonIgnore
    @JoinColumn(name = "seance_reservation_foreign_key", referencedColumnName = "seance_id")
    private List<CinemaBranchEntity> branches;
}
