package pl.edu.pwr.bd2_cinema_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pwr.bd2_cinema_app.repository.SeatRepository;

@RestController
@RequestMapping("/seats")
public class SeatController {

    private final SeatRepository seatRepository;

    @Autowired
    SeatController(SeatRepository seatRepository){
        this.seatRepository = seatRepository;
    }
}
