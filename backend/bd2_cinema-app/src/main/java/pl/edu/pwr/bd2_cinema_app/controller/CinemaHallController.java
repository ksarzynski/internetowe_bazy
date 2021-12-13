package pl.edu.pwr.bd2_cinema_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwr.bd2_cinema_app.model.MovieEntity;
import pl.edu.pwr.bd2_cinema_app.model.SeatEntity;
import pl.edu.pwr.bd2_cinema_app.repository.CinemaHallRepository;

import java.util.List;

@RestController
@RequestMapping("/halls")
@CrossOrigin
public class CinemaHallController {

    private final CinemaHallRepository cinemaHallRepository;

    @Autowired
    CinemaHallController(CinemaHallRepository cinemaHallRepository){
        this.cinemaHallRepository = cinemaHallRepository;
    }

    @GetMapping("/getSeats")
    public ResponseEntity<List<SeatEntity>> getSeats(@RequestParam int id){
        List<SeatEntity> r = this.cinemaHallRepository.findById(id).get().getSeats();
        return new ResponseEntity<>(r, HttpStatus.OK);
    }
}
