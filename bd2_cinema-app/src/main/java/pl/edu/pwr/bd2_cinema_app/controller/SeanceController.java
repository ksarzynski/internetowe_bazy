package pl.edu.pwr.bd2_cinema_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pwr.bd2_cinema_app.model.SeanceEntity;
import pl.edu.pwr.bd2_cinema_app.repository.SeanceRepository;

import java.util.List;

@RestController
@RequestMapping("/seances")
public class SeanceController {

    private final SeanceRepository seanceRepository;

    @Autowired
    SeanceController(SeanceRepository seanceRepository){
        this.seanceRepository = seanceRepository;
    }

}
