package pl.edu.pwr.bd2_cinema_app.repository;

import org.springframework.data.repository.CrudRepository;
import pl.edu.pwr.bd2_cinema_app.model.CinemaHallEntity;
import pl.edu.pwr.bd2_cinema_app.model.SeanceEntity;

import java.util.List;

public interface SeanceRepository extends CrudRepository<SeanceEntity, Integer> {
    List<SeanceEntity> findByCinemaHall(CinemaHallEntity cinemaHallEntity);
}
