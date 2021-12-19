package pl.edu.pwr.bd2_cinema_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwr.bd2_cinema_app.dto.MovieDTO;
import pl.edu.pwr.bd2_cinema_app.model.*;
import pl.edu.pwr.bd2_cinema_app.repository.ActorRepository;
import pl.edu.pwr.bd2_cinema_app.repository.MovieRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
@CrossOrigin()
public class MovieController {

    private final MovieRepository movieRepository;
    private final ActorRepository actorRepository;

    @Autowired
    MovieController(MovieRepository movieRepository, ActorRepository actorRepository){
        this.movieRepository = movieRepository;
        this.actorRepository = actorRepository;
    }

    @GetMapping("/getMovie")
    public ResponseEntity<MovieEntity> getMovie(@RequestParam int id){
        if(this.movieRepository.findById(id).isPresent())
            return new ResponseEntity<>(this.movieRepository.findById(id).get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getMovieByName")
    public ResponseEntity<MovieEntity> getMovieByName(@RequestParam String name){
        if(this.movieRepository.findByName(name).isPresent())
            return new ResponseEntity<>(this.movieRepository.findByName(name).get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/all_movies")
    public ResponseEntity<Iterable<MovieEntity>> getMovies(){
        if(this.movieRepository.count() > 0)
            return new ResponseEntity<>(this.movieRepository.findAll(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/addMovie")
    public ResponseEntity<String> addMovie(@RequestBody MovieDTO movie){
        if(this.checkIfMovieAlreadyExists(movie.getName()))
            return new ResponseEntity<>("Movie with given name already exists.",
                    HttpStatus.BAD_REQUEST);
        this.movieRepository.save(new MovieEntity(
            movie.getMovie_id(),
                movie.getName(),
                movie.getCategory(),
                movie.getDuration(),
                movie.getDescription(),
                movie.getPg(),
                0.0,
                movie.getBasePrice(),
                new ArrayList<>(),
                new ArrayList<>(),
                this.getActorsWhoPlayedInThisMovie(movie),
                movie.getImageUrl()
            ));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteMovie")
    public ResponseEntity<String> deleteMovie(@RequestParam int id){
        if(this.movieRepository.findById(id).isPresent()){
            this.movieRepository.delete(this.movieRepository.findById(id).get());
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    private boolean checkIfMovieAlreadyExists(String name){
        return this.movieRepository.existsByName(name);
    }

    private List<ActorEntity> getActorsWhoPlayedInThisMovie(MovieDTO movie){
        ArrayList<ActorEntity> actors = new ArrayList<>();
        for(ActorEntity actor: this.actorRepository.findAll()){
            for(MovieEntity actorsMovie: actor.getMoviesInWhichTheActorPlayed())
                if(actorsMovie.getName().equals(movie.getName()))
                    actors.add(actor);
        }
        return actors;
    }
}
