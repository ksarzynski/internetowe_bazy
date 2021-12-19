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
@Table(name = "ACTORS")
public class ActorEntity {
    @Id
    @GeneratedValue
    private int actor_id;
    private String firstname;
    private String surname;
    private String description;
    @JsonIgnore
    @ManyToMany(mappedBy = "actorsWhoPlayedInThisMovie")
    private List<MovieEntity> moviesInWhichTheActorPlayed;
    private String imageUrl;
}
