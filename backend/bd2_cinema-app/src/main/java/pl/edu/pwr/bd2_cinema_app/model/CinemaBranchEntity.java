package pl.edu.pwr.bd2_cinema_app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pl.edu.pwr.bd2_cinema_app.dto.CinemaBranchDTO;

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
    private String city;
    private String address;
    @OneToMany(targetEntity = CinemaHallEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "cinema_branch_cinema_hall_foreign_key", referencedColumnName = "cinema_branch_id")
    private List<CinemaHallEntity> cinemaHalls;

    public CinemaBranchEntity(CinemaBranchDTO cinemaBranch){
        this.cinema_branch_id = cinemaBranch.getCinema_branch_id();
        this.name = cinemaBranch.getName();
        this.city = cinemaBranch.getCity();
        this.address = cinemaBranch.getAddress();
    }
}
