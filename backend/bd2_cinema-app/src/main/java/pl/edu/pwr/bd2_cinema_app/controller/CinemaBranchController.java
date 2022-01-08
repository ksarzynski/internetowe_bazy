package pl.edu.pwr.bd2_cinema_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwr.bd2_cinema_app.dto.ActorDTO;
import pl.edu.pwr.bd2_cinema_app.dto.CinemaBranchDTO;
import pl.edu.pwr.bd2_cinema_app.model.CinemaBranchEntity;
import pl.edu.pwr.bd2_cinema_app.model.CinemaHallEntity;
import pl.edu.pwr.bd2_cinema_app.model.SeanceEntity;
import pl.edu.pwr.bd2_cinema_app.repository.CinemaBranchRepository;
import pl.edu.pwr.bd2_cinema_app.repository.CinemaHallRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/branches")
@CrossOrigin
public class CinemaBranchController {

    private final CinemaBranchRepository cinemaBranchRepository;
    private final CinemaHallRepository cinemaHallRepository;

    @Autowired
    CinemaBranchController(CinemaBranchRepository cinemaBranchRepository,
                           CinemaHallRepository cinemaHallRepository){
        this.cinemaBranchRepository = cinemaBranchRepository;
        this.cinemaHallRepository = cinemaHallRepository;
    }

    @GetMapping("/cinemas")
    public List<CinemaBranchEntity> getCinemas() {
        return (List<CinemaBranchEntity>) cinemaBranchRepository.findAll();
    }

    @PostMapping("/addBranch")
    public ResponseEntity<String> addCinemaBranch(@RequestBody CinemaBranchDTO cinemaBranch){
        CinemaBranchEntity newCinemaBranch = new CinemaBranchEntity(cinemaBranch);
        for(Integer cinemaHallId : cinemaBranch.getCinemaHalls())
            newCinemaBranch.getCinemaHalls().add(this.cinemaHallRepository.findById(cinemaHallId).get());
        cinemaBranchRepository.save(newCinemaBranch);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    private void addSeats(){

    }
}
