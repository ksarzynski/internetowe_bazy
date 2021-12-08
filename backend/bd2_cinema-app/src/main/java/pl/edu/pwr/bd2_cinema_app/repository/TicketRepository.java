package pl.edu.pwr.bd2_cinema_app.repository;

import org.springframework.data.repository.CrudRepository;
import pl.edu.pwr.bd2_cinema_app.model.TicketEntity;

public interface TicketRepository extends CrudRepository<TicketEntity, Integer> {
}
