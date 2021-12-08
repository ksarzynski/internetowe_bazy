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
@Table(name = "MOVIES")
public class MovieEntity {

    @Id
    @GeneratedValue
    private int movie_id;
    private String name;
    private String category;
    private Integer duration;
    private String director;
    private String description;
    private Integer pg;
    private Double rating;
    private Double basePrice;
    @OneToMany(targetEntity = SeanceEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_seance_foreign_key", referencedColumnName = "movie_id")
    private List<SeanceEntity> seances;
    @OneToMany(targetEntity = ReviewEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_review_foreign_key", referencedColumnName = "movie_id")
    private List<ReviewEntity> reviews;
    @ManyToMany
    @JoinTable(
            name= "movie_actor",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private List<ActorEntity> actorsWhoPlayedInThisMovie;
}
