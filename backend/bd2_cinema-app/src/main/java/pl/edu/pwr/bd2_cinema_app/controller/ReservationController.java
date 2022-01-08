package pl.edu.pwr.bd2_cinema_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwr.bd2_cinema_app.dto.ReservationDTO;
import pl.edu.pwr.bd2_cinema_app.model.ReservationEntity;
import pl.edu.pwr.bd2_cinema_app.model.SeanceEntity;
import pl.edu.pwr.bd2_cinema_app.model.SeatEntity;
import pl.edu.pwr.bd2_cinema_app.model.UserEntity;
import pl.edu.pwr.bd2_cinema_app.repository.ReservationRepository;
import pl.edu.pwr.bd2_cinema_app.repository.SeanceRepository;
import pl.edu.pwr.bd2_cinema_app.repository.SeatRepository;
import pl.edu.pwr.bd2_cinema_app.repository.UserRepository;

import java.util.*;

@RestController
@RequestMapping("/reservations")
@CrossOrigin
public class ReservationController {

    private final ReservationRepository reservationRepository;
    private final SeanceRepository seanceRepository;
    private final SeatRepository seatRepository;
    private final UserRepository userRepository;
    @Autowired
    ReservationController(ReservationRepository reservationRepository, SeanceRepository seanceRepository, SeatRepository seatRepository, UserRepository userRepository){
        this.reservationRepository = reservationRepository;
        this.seanceRepository = seanceRepository;
        this.seatRepository = seatRepository;
        this.userRepository = userRepository;
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

    @PostMapping("/makeReservation")
    public ResponseEntity<Integer> makeReservation(@RequestBody ReservationDTO body){
        ReservationEntity reservation = new ReservationEntity();
        //add reservation
        reservation = this.reservationRepository.save(reservation);
        //add relationships
        SeanceEntity seance = this.seanceRepository.findById(body.seanceId).get();
        seance.getReservations().add(reservation);
        this.seanceRepository.save(seance);
        UserEntity user = this.userRepository.findById(body.userId).get();
        user.getReservations().add(reservation);
        this.userRepository.save(user);

        //reserve seats
        reservation.setReservationSeats(new ArrayList<>());
        for(int i : body.seatIds){
            if(this.seatRepository.findById(i).isPresent()){
                reservation.getReservationSeats().add(this.seatRepository.findById(i).get());
                this.reservationRepository.save(reservation);
            }
        }
      return new ResponseEntity<>(1, HttpStatus.OK);
    }
}
