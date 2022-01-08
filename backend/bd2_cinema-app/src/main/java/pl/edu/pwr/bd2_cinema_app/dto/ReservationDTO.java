package pl.edu.pwr.bd2_cinema_app.dto;

import lombok.*;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ReservationDTO {
    public Integer seanceId;
    public Integer userId;
    public ArrayList<Integer> seatIds;
}
