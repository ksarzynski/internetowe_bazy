package pl.edu.pwr.bd2_cinema_app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Parameter;
import pl.edu.pwr.bd2_cinema_app.model.SeatEntity;

import java.util.List;

public interface SeatRepository extends CrudRepository<SeatEntity, Integer> {
    public List<SeatEntity> findAllByCinemaHallSeatForeignKey(int fk);
    public SeatEntity findByCinemaHallSeatForeignKey(int fk);
    public SeatEntity findByCinemaHallSeatForeignKeyIsNotNull();
}
