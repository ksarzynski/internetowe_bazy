package pl.edu.pwr.bd2_cinema_app.dto;

import lombok.*;

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
}
