package pl.edu.pwr.bd2_cinema_app.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class SeatDTO {
    private int seat_id;
    private String myRowNumber;
    private String myColumnNumber;
    private boolean isPremium;
    private float seatFee;
    private int cinemaHallId;
}

