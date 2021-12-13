package pl.edu.pwr.bd2_cinema_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwr.bd2_cinema_app.model.SeatEntity;
import pl.edu.pwr.bd2_cinema_app.repository.CinemaHallRepository;
import pl.edu.pwr.bd2_cinema_app.repository.SeatRepository;

import java.util.List;

@RestController
@RequestMapping("/seats")
@CrossOrigin
public class SeatController {

    private final SeatRepository seatRepository;
    private final CinemaHallRepository hallRepository;

    @Autowired
    SeatController(SeatRepository seatRepository, CinemaHallRepository hallRepository){
        this.seatRepository = seatRepository;
        this.hallRepository = hallRepository;
    }

    @GetMapping("/seance")
    public ResponseEntity<List<SeatEntity>> getMovie(@RequestParam int id) {
        System.out.println(this.hallRepository.findById(id).get().getSeats());
        return new ResponseEntity<>(this.hallRepository.findById(id).get().getSeats(), HttpStatus.OK);
    }
}
