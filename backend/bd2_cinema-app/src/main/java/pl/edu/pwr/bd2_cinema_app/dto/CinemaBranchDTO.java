package pl.edu.pwr.bd2_cinema_app.dto;

import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CinemaBranchDTO {

    private int cinema_branch_id;
    private String name;
    private String city;
    private String address;
    private List<Integer> cinemaHalls;
}