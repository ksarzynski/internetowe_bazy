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
@Table(name = "CINEMA_BRANCHES")
public class CinemaBranchEntity {

    @Id
    @GeneratedValue
    private int cinema_branch_id;
    private String name;
    // address
    private String city;
    private String address;
    @OneToMany(targetEntity = CinemaHallEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "cinema_branch_cinema_hall_foreign_key", referencedColumnName = "cinema_branch_id")
    private List<CinemaHallEntity> cinemaHalls;
}
