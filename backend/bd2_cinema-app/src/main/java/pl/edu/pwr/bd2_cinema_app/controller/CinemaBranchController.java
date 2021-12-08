package pl.edu.pwr.bd2_cinema_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pwr.bd2_cinema_app.model.CinemaBranchEntity;
import pl.edu.pwr.bd2_cinema_app.model.CinemaHallEntity;
import pl.edu.pwr.bd2_cinema_app.model.SeanceEntity;
import pl.edu.pwr.bd2_cinema_app.repository.CinemaBranchRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/branches")
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
}
