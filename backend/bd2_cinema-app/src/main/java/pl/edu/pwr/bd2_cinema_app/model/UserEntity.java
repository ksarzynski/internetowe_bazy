package pl.edu.pwr.bd2_cinema_app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "USERS")
public class UserEntity {

    @Id
    @GeneratedValue
    private int user_id;
    private String username;
    private String password;
    private String email;
    private Integer noReviews;
    private Double averageReview;
    private Integer noBoughtTickets;
    @OneToMany(targetEntity = ReservationEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_reservation_foreign_key", referencedColumnName = "user_id")
    private List<ReservationEntity> reservations;
    @OneToMany(targetEntity = ReviewEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_review_foreign_key", referencedColumnName = "user_id")
    private List<ReviewEntity> reviews;
    @OneToMany(targetEntity = TicketEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_ticket_foreign_key", referencedColumnName = "user_id")
    private List<TicketEntity> tickets;
}
