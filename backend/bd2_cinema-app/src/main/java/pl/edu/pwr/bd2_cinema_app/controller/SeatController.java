package pl.edu.pwr.bd2_cinema_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwr.bd2_cinema_app.dto.SeatDTO;
import pl.edu.pwr.bd2_cinema_app.model.ReviewEntity;
import pl.edu.pwr.bd2_cinema_app.model.SeatEntity;
import pl.edu.pwr.bd2_cinema_app.repository.CinemaHallRepository;
import pl.edu.pwr.bd2_cinema_app.repository.SeatRepository;

@RestController
@RequestMapping("/seats")
@CrossOrigin
public class SeatController {

    private final SeatRepository seatRepository;
    private final CinemaHallRepository cinemaHallRepository;

    @Autowired
    SeatController(SeatRepository seatRepository, CinemaHallRepository cinemaHallRepository){
        this.seatRepository = seatRepository;
        this.cinemaHallRepository = cinemaHallRepository;
    }

    @PostMapping("/addSeat")
    public ResponseEntity<String> addSeat(@RequestBody SeatDTO newSeat){
        SeatEntity seat = new SeatEntity(newSeat);
        this.cinemaHallRepository.findById(newSeat.getCinemaHallId()).get().getSeats().add(seat);
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }
}
