package pl.edu.pwr.bd2_cinema_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pwr.bd2_cinema_app.repository.SeanceRepository;

@RestController
@RequestMapping("/seances")
@CrossOrigin
public class SeanceController {

    private final SeanceRepository seanceRepository;

    @Autowired
    SeanceController(SeanceRepository seanceRepository){
        this.seanceRepository = seanceRepository;
    }
}
