package pl.edu.pwr.bd2_cinema_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwr.bd2_cinema_app.dto.SeanceDTO;
import pl.edu.pwr.bd2_cinema_app.model.CinemaBranchEntity;
import pl.edu.pwr.bd2_cinema_app.model.MovieEntity;
import pl.edu.pwr.bd2_cinema_app.model.SeanceEntity;
import pl.edu.pwr.bd2_cinema_app.repository.CinemaBranchRepository;
import pl.edu.pwr.bd2_cinema_app.repository.CinemaHallRepository;
import pl.edu.pwr.bd2_cinema_app.repository.MovieRepository;
import pl.edu.pwr.bd2_cinema_app.model.CinemaHallEntity;
import pl.edu.pwr.bd2_cinema_app.repository.SeanceRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/seances")
@CrossOrigin
public class SeanceController {

    private final SeanceRepository seanceRepository;
    private final MovieRepository movieRepository;
    private final CinemaHallRepository cinemaHallRepository;
    private final CinemaBranchRepository cinemaBranchRepository;

    @Autowired
    SeanceController(SeanceRepository seanceRepository,
                     MovieRepository movieRepository,
                     CinemaHallRepository cinemaHallRepository,
                     CinemaBranchRepository cinemaBranchRepository){
        this.seanceRepository = seanceRepository;
        this.movieRepository = movieRepository;
        this.cinemaHallRepository = cinemaHallRepository;
        this.cinemaBranchRepository = cinemaBranchRepository;
    }

    @GetMapping("/getSeances")
    public ResponseEntity<Iterable<SeanceDTO>> getSeances(){
        Iterable<SeanceEntity> seances = this.seanceRepository.findAll();
        ArrayList<SeanceDTO> seancesDTO = new ArrayList<>();
        for(SeanceEntity seance : seances){
            String name = this.getSeanceMovieName(seance.getSeance_id());
            seancesDTO.add(new SeanceDTO(seance, name));
        }
        if(seancesDTO.size() > 0)
            return new ResponseEntity<>(seancesDTO, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    private String getSeanceMovieName(int id){
        for(MovieEntity movie : this.movieRepository.findAll())
            for(SeanceEntity seance: movie.getSeances())
                if(seance.getSeance_id() == id){
                    return movie.getName();
                }
        return "NO NAME";
    }

    @GetMapping("/getHall")
    public ResponseEntity<CinemaHallEntity> getSeanceHall(@RequestParam int seanceId){
        SeanceEntity s = this.seanceRepository.findById(seanceId).get();
        return new ResponseEntity<>(s.getCinemaHall(), HttpStatus.OK);
    }

    @PostMapping("/addSeance")
    public ResponseEntity<String> addSeance(@RequestBody SeanceDTO seance){
        if(checkIfSeanceOverlaps(seance))
            return new ResponseEntity<>("there is another seance at this time in this hall", HttpStatus.BAD_REQUEST);
        SeanceEntity newSeance = new SeanceEntity(seance);
        newSeance.setMovie(this.movieRepository.findByName(seance.getMovieName()).get());
        newSeance.setCinemaHall(this.cinemaHallRepository.findById(seance.getCinemaHallId()).get());
        newSeance.setReservations(new ArrayList<>());
        newSeance.setTickets(new ArrayList<>());
        this.seanceRepository.save(newSeance);
        return new ResponseEntity<>("seance added", HttpStatus.OK);
    }

    private boolean checkIfSeanceOverlaps(SeanceDTO seance){
        List<SeanceEntity> seances = this.seanceRepository.findByCinemaHall(this.cinemaHallRepository.findById(seance.getCinemaHallId()).get());
        for(SeanceEntity seanceEntity : seances){
            if((seance.getStartDate().after(seanceEntity.getStartDate()) &&
                    seance.getStartDate().before(seanceEntity.getEndDate()))
                    || (seance.getEndDate().after(seanceEntity.getStartDate())) &&
                    seance.getEndDate().before(seanceEntity.getEndDate()))
                return true;
        }
        return false;
    }

    @GetMapping("/seances/{cinemaId}")
    public List<SeanceEntity> getSeances(@PathVariable("cinemaId") int cinemaID) {

        Optional<CinemaBranchEntity> cinema = cinemaBranchRepository.findById(cinemaID);
        CinemaBranchEntity cinemaBranchEntity = cinema.get();
        List<SeanceEntity> resultList = new ArrayList<>();
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
        List<SeanceEntity> resultList = new ArrayList<>();
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
