package pl.edu.pwr.bd2_cinema_app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "REVIEWS")
public class ReviewEntity {

    @Id
    @GeneratedValue
    private int review_id;
    private Integer value;
    private String description;
}
