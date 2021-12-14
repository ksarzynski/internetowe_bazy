package pl.edu.pwr.bd2_cinema_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwr.bd2_cinema_app.model.CinemaHallEntity;
import pl.edu.pwr.bd2_cinema_app.model.SeanceEntity;
import pl.edu.pwr.bd2_cinema_app.repository.SeanceRepository;

import java.util.Optional;
import java.util.function.Consumer;

@RestController
@RequestMapping("/seances")
@CrossOrigin
public class SeanceController {

    private final SeanceRepository seanceRepository;

    @Autowired
    SeanceController(SeanceRepository seanceRepository){
        this.seanceRepository = seanceRepository;
    }

    @GetMapping("/getHall")
    public ResponseEntity<CinemaHallEntity> getSeanceHall(@RequestParam int seanceId){
        SeanceEntity s = this.seanceRepository.findById(seanceId).get();
        //ResponseEntity<CinemaHallEntity> res = new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(s.getCinemaHall(), HttpStatus.OK);
    }
}
