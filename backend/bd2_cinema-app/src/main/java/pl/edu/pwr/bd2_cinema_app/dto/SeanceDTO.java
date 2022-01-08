package pl.edu.pwr.bd2_cinema_app.dto;

import lombok.*;
import pl.edu.pwr.bd2_cinema_app.model.SeanceEntity;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class SeanceDTO {
    private String name;
    private int seance_id;
    private Date startDate;
    private Date endDate;
    private Integer noAvailableSeats;
    private Double price;
    private String imageUrl;
    private String movieName;
    private int cinemaHallId;

    public SeanceDTO(SeanceEntity seance, String name){
        this.name = name;
        this.seance_id = seance.getSeance_id();
        this.startDate = seance.getStartDate();
        this.endDate = seance.getEndDate();
        this.noAvailableSeats = seance.getNoAvailableSeats();
        this.price = seance.getPrice();
        this.imageUrl = seance.getImageUrl();
        this.cinemaHallId = seance.getCinemaHall().getCinema_hall_id();
    }
}
