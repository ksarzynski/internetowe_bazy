package pl.edu.pwr.bd2_cinema_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pwr.bd2_cinema_app.repository.ReservationRepository;

@RestController
@RequestMapping("/reservations")
@CrossOrigin
public class ReservationController {

    private final ReservationRepository reservationRepository;

    @Autowired
    ReservationController(ReservationRepository reservationRepository){
        this.reservationRepository = reservationRepository;
    }
}
