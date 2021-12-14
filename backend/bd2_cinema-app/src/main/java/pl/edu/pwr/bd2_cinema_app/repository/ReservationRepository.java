package pl.edu.pwr.bd2_cinema_app.repository;

import org.springframework.data.repository.CrudRepository;
import pl.edu.pwr.bd2_cinema_app.model.ReservationEntity;
import pl.edu.pwr.bd2_cinema_app.model.SeanceEntity;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends CrudRepository<ReservationEntity, Integer> {
    List<ReservationEntity> getAllByReservationSeance(Optional<SeanceEntity> seance);
}
