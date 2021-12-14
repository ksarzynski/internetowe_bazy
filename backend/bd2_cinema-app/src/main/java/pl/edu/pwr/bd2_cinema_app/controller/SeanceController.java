package pl.edu.pwr.bd2_cinema_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwr.bd2_cinema_app.dto.MovieDTO;
import pl.edu.pwr.bd2_cinema_app.dto.SeanceDTO;
import pl.edu.pwr.bd2_cinema_app.model.MovieEntity;
import pl.edu.pwr.bd2_cinema_app.model.SeanceEntity;
import pl.edu.pwr.bd2_cinema_app.repository.MovieRepository;
import pl.edu.pwr.bd2_cinema_app.repository.SeanceRepository;

import java.util.ArrayList;

@RestController
@RequestMapping("/seances")
@CrossOrigin
public class SeanceController {

    private final SeanceRepository seanceRepository;
    private final MovieRepository movieRepository;

    @Autowired
    SeanceController(SeanceRepository seanceRepository, MovieRepository movieRepository){
        this.seanceRepository = seanceRepository;
        this.movieRepository = movieRepository;
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
}
