package pl.edu.pwr.bd2_cinema_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwr.bd2_cinema_app.dto.DirectorDTO;
import pl.edu.pwr.bd2_cinema_app.model.DirectorEntity;
import pl.edu.pwr.bd2_cinema_app.model.MovieEntity;
import pl.edu.pwr.bd2_cinema_app.repository.DirectorRepository;
import pl.edu.pwr.bd2_cinema_app.repository.MovieRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/directors")
@CrossOrigin
public class DirectorController {

    private final DirectorRepository directorRepository;
    private final MovieRepository movieRepository;

    @Autowired
    DirectorController(DirectorRepository directorRepository, MovieRepository movieRepository){
        this.directorRepository = directorRepository;
        this.movieRepository = movieRepository;
    }

    @GetMapping("/getDirector")
    public ResponseEntity<DirectorEntity> getDirector(@RequestParam int id){
        if(this.directorRepository.findById(id).isPresent())
            return new ResponseEntity<>(this.directorRepository.findById(id).get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getDirectors")
    public ResponseEntity<Iterable<DirectorEntity>> getDirectors(){
        if(this.directorRepository.count() > 0)
            return new ResponseEntity<>(this.directorRepository.findAll(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/addDirector")
    public ResponseEntity<String> addDirector(@RequestBody DirectorDTO director){
        if(this.checkIfDirectorAlreadyExists(director.getFirstname(), director.getSurname()))
            return new ResponseEntity<>("Director with given firstname and surname already exists.",
                    HttpStatus.BAD_REQUEST);
        this.directorRepository.save(new DirectorEntity(
                director.getDirector_id(),
                director.getFirstname(),
                director.getSurname(),
                director.getDescription(),
                this.getDirectedMovies(director)
        ));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteDirector")
    public ResponseEntity<String> deleteDirector(@RequestParam int id){
        if(this.directorRepository.findById(id).isPresent()){
            this.directorRepository.delete(this.directorRepository.findById(id).get());
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    private boolean checkIfDirectorAlreadyExists(String firstname, String surname){
        return this.directorRepository.existsByFirstnameAndSurname(firstname, surname);
    }

    private List<MovieEntity> getDirectedMovies(DirectorDTO director){
        ArrayList<MovieEntity> movies = new ArrayList<>();
        this.movieRepository.findAll().forEach(movie -> {
            for(Integer id: director.getDirectedMovies())
                if(movie.getMovie_id() == id)
                    movies.add(movie);
        });
        return movies;
    }
}
