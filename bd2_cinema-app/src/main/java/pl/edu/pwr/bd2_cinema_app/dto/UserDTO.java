package pl.edu.pwr.bd2_cinema_app.dto;

import pl.edu.pwr.bd2_cinema_app.model.ReservationEntity;
import pl.edu.pwr.bd2_cinema_app.model.ReviewEntity;
import pl.edu.pwr.bd2_cinema_app.model.TicketEntity;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

public class UserDTO {
    private String username;
    private String password;
    private String email;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}