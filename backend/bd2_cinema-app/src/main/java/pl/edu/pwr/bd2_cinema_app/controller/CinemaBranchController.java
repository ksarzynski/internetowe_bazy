package pl.edu.pwr.bd2_cinema_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwr.bd2_cinema_app.dto.CinemaBranchDTO;
import pl.edu.pwr.bd2_cinema_app.model.CinemaBranchEntity;
import pl.edu.pwr.bd2_cinema_app.model.CinemaHallEntity;
import pl.edu.pwr.bd2_cinema_app.model.SeanceEntity;
import pl.edu.pwr.bd2_cinema_app.repository.CinemaBranchRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/branches")
@CrossOrigin
public class CinemaBranchController {

    private final CinemaBranchRepository cinemaBranchRepository;

    @Autowired
    CinemaBranchController(CinemaBranchRepository cinemaBranchRepository){
        this.cinemaBranchRepository = cinemaBranchRepository;
    }

    @GetMapping("/cinemas")
    public List<CinemaBranchEntity> getCinemas() {
        return (List<CinemaBranchEntity>) cinemaBranchRepository.findAll();
    }

    @GetMapping("/seances/{cinemaId}")
    public List<SeanceEntity> getSeances(@PathVariable("cinemaId") int cinemaID) {

        Optional<CinemaBranchEntity> cinema = cinemaBranchRepository.findById(cinemaID);
        CinemaBranchEntity cinemaBranchEntity = cinema.get();
        List<SeanceEntity> resultList = new ArrayList<SeanceEntity>();
        List<CinemaHallEntity> cinemaHallEntityList = cinemaBranchEntity.getCinemaHalls();
        for (CinemaHallEntity cinemaHall: cinemaHallEntityList) {
            resultList.addAll(cinemaHall.getSeances());
        }
        return resultList;
    }
    @GetMapping("/seances/{cinemaId}/{seanceName}")
    public List<SeanceEntity> getSeances(@PathVariable("cinemaId") int cinemaID, @PathVariable("seanceName") String seanceName){
        Optional<CinemaBranchEntity> cinema = cinemaBranchRepository.findById(cinemaID);
        CinemaBranchEntity cinemaBranchEntity = cinema.get();
        List<SeanceEntity> resultList = new ArrayList<SeanceEntity>();
        List<CinemaHallEntity> cinemaHallEntityList = cinemaBranchEntity.getCinemaHalls();
        for (CinemaHallEntity cinemaHall: cinemaHallEntityList) {
            for (SeanceEntity seanceEntity: cinemaHall.getSeances()) {
                if(seanceEntity.equals(seanceName)){
                    resultList.add(seanceEntity);
                }
            }
            resultList.addAll(cinemaHall.getSeances());
        }
        return resultList;
    }
    @PostMapping("/addBranch")
    public ResponseEntity<String> addBranch(@RequestBody CinemaBranchDTO cinemaBranch){
        if(this.checkIfBranchAlreadyExist(cinemaBranch))
            return new ResponseEntity<>("cinema with this name already exists", HttpStatus.BAD_REQUEST);
        CinemaBranchEntity newCinemaBranch = new CinemaBranchEntity(0,
                cinemaBranch.getName(),
                cinemaBranch.getCity(),
                cinemaBranch.getAddress(),
                new ArrayList<>());
        this.cinemaBranchRepository.save(newCinemaBranch);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    private boolean checkIfBranchAlreadyExist(CinemaBranchDTO cinemaBranch){
        return this.cinemaBranchRepository.existsByName(cinemaBranch.getName());
    }
}
