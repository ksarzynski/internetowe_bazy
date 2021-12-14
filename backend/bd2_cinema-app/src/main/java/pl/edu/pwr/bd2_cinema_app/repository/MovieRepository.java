package pl.edu.pwr.bd2_cinema_app.repository;

import org.springframework.data.repository.CrudRepository;
import pl.edu.pwr.bd2_cinema_app.model.MovieEntity;

import java.util.Optional;

public interface MovieRepository extends CrudRepository<MovieEntity, Integer> {
    boolean existsByName(String name);
    Optional<MovieEntity> findByName(String name);
}
