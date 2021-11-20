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
@Table(name = "DIRECTORS")
public class DirectorEntity {

    @Id
    @GeneratedValue
    private int directorId;
    private String firstname;
    private String surname;
    private String description;
    @OneToMany(targetEntity = MovieEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "director_seance_foreign_key", referencedColumnName = "directorId")
    private List<MovieEntity> directedMovies;
}