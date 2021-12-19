package pl.edu.pwr.bd2_cinema_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwr.bd2_cinema_app.dto.ActorDTO;
import pl.edu.pwr.bd2_cinema_app.model.ActorEntity;
import pl.edu.pwr.bd2_cinema_app.model.MovieEntity;
import pl.edu.pwr.bd2_cinema_app.repository.ActorRepository;
import pl.edu.pwr.bd2_cinema_app.repository.MovieRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/actors")
@CrossOrigin
public class ActorController {

    private final ActorRepository actorRepository;
    private final MovieRepository movieRepository;

    @Autowired
    ActorController(ActorRepository actorRepository, MovieRepository movieRepository){
        this.actorRepository = actorRepository;
        this.movieRepository = movieRepository;
    }

    @GetMapping("/getActor")
    public ResponseEntity<ActorEntity> getActor(@RequestParam int id){
        if(this.actorRepository.findById(id).isPresent())
            return new ResponseEntity<>(this.actorRepository.findById(id).get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getActors")
    public ResponseEntity<Iterable<ActorEntity>> getActors(){
        if(this.actorRepository.count() > 0)
            return new ResponseEntity<>(this.actorRepository.findAll(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/addActor")
    public ResponseEntity<String> addActor(@RequestBody ActorDTO actor){
        if(this.checkIfActorAlreadyExists(actor.getFirstname(), actor.getSurname()))
            return new ResponseEntity<>("Actor with given firstname and surname already exists.",
                    HttpStatus.BAD_REQUEST);
        //TODO: handle urls properly
        String url = actor.getImageUrl();
        if(url.length() > 250)
            System.out.println("image url too long");

        url = url.length() > 250 ? " " : url;
        ActorEntity newActor = new ActorEntity(
                0,
                actor.getFirstname(),
                actor.getSurname(),
                actor.getDescription(),
                new ArrayList<>(),
                url
        );
        //this.addActorToMovies(newActor);
        this.actorRepository.save(newActor);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteActor")
    public ResponseEntity<String> deleteActor(@RequestParam int id){
        if(this.actorRepository.findById(id).isPresent()){
            this.actorRepository.delete(this.actorRepository.findById(id).get());
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    private boolean checkIfActorAlreadyExists(String firstname, String surname){
        return this.actorRepository.existsByFirstnameAndSurname(firstname, surname);
    }

    private List<MovieEntity> getMoviesInWhichTheActorPlayed(ActorDTO actor){
        ArrayList<MovieEntity> movies = new ArrayList<>();
        this.movieRepository.findAll().forEach(movie -> {
            for(Integer id: actor.getMoviesInWhichTheActorPlayed())
                if(movie.getMovie_id() == id)
                    movies.add(movie);
        });
        return movies;
    }

    private void addActorToMovies(ActorEntity actor){
        for(MovieEntity movie: actor.getMoviesInWhichTheActorPlayed())
            if(!movie.getActorsWhoPlayedInThisMovie().contains(actor))
                movie.getActorsWhoPlayedInThisMovie().add(actor);
    }

    @GetMapping("/actorsFromMovie")
    private ResponseEntity<List<ActorEntity>> getActorsFromMovie(@RequestParam int movieId){
        MovieEntity movie = movieRepository.findById(movieId).get();
        return new ResponseEntity<>(movie.getActorsWhoPlayedInThisMovie(), HttpStatus.OK);
    }
}
