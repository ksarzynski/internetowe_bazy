package pl.edu.pwr.bd2_cinema_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwr.bd2_cinema_app.model.ReservationEntity;
import pl.edu.pwr.bd2_cinema_app.model.SeanceEntity;
import pl.edu.pwr.bd2_cinema_app.model.SeatEntity;
import pl.edu.pwr.bd2_cinema_app.repository.ReservationRepository;
import pl.edu.pwr.bd2_cinema_app.repository.SeanceRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservations")
@CrossOrigin
public class ReservationController {

    private final ReservationRepository reservationRepository;
    private final SeanceRepository seanceRepository;
    @Autowired
    ReservationController(ReservationRepository reservationRepository, SeanceRepository seanceRepository){
        this.reservationRepository = reservationRepository;
        this.seanceRepository = seanceRepository;
    }

    @GetMapping("/seatsForSeance")
    public ResponseEntity<List<SeatEntity>> getSeatsForSeance(@RequestParam int seanceId){

        Optional<SeanceEntity> s = this.seanceRepository.findById(seanceId);
        List<ReservationEntity> reservations = this.reservationRepository.getAllByReservationSeance(s);
        List<SeatEntity> seats = new ArrayList<>();
        for(ReservationEntity r : reservations){
            List<SeatEntity> temp = r.getReservationSeats();
            seats.addAll(temp);
        }
        return new ResponseEntity<>(seats, HttpStatus.OK);

    }
}
