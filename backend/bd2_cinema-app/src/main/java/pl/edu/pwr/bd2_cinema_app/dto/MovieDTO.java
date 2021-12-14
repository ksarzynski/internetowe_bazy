package pl.edu.pwr.bd2_cinema_app.dto;

import lombok.*;
import pl.edu.pwr.bd2_cinema_app.model.ActorEntity;
import pl.edu.pwr.bd2_cinema_app.model.MovieEntity;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class MovieDTO {
    private int movie_id;
    private String name;
    private String category;
    private Integer duration;
    private String description;
    private Integer pg;
    private Double basePrice;
    private List<Integer> actorsWhoPlayedInThisMovie;
    private String imageUrl;

    public MovieDTO(MovieEntity movie){
        this.movie_id = movie.getMovie_id();
        this.name = movie.getName();
        this.category = movie.getCategory();
        this.duration = movie.getDuration();
        this.description = movie.getDescription();
        this.pg = movie.getPg();
        this.basePrice = movie.getBasePrice();
        this.actorsWhoPlayedInThisMovie = new ArrayList<>();
        for(ActorEntity actor : movie.getActorsWhoPlayedInThisMovie())
            this.actorsWhoPlayedInThisMovie.add(actor.getActor_id());
        this.imageUrl = movie.getImageUrl();
    }
}
