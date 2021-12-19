package pl.edu.pwr.bd2_cinema_app.dto;

import lombok.*;

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
}
