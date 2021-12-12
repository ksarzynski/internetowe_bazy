package pl.edu.pwr.bd2_cinema_app.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class UserDTO {
    private String userID;
    private String username;
    private String password;
    private String email;
}
