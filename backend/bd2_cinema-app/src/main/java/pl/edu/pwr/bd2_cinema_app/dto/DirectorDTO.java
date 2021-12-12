package pl.edu.pwr.bd2_cinema_app.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class DirectorDTO {
    private int director_id;
    private String firstname;
    private String surname;
    private String description;
    private List<Integer> directedMovies;
}
