package pl.edu.pwr.bd2_cinema_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pwr.bd2_cinema_app.repository.CinemaHallRepository;

@RestController
@RequestMapping("/halls")
@CrossOrigin
public class CinemaHallController {

    private final CinemaHallRepository cinemaHallRepository;

    @Autowired
    CinemaHallController(CinemaHallRepository cinemaHallRepository){
        this.cinemaHallRepository = cinemaHallRepository;
    }
}
