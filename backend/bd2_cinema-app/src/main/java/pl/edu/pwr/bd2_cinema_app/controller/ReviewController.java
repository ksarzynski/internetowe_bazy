package pl.edu.pwr.bd2_cinema_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwr.bd2_cinema_app.model.MovieEntity;
import pl.edu.pwr.bd2_cinema_app.model.ReviewEntity;
import pl.edu.pwr.bd2_cinema_app.repository.MovieRepository;
import pl.edu.pwr.bd2_cinema_app.repository.ReviewRepository;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@CrossOrigin
public class ReviewController {

    private final ReviewRepository reviewRepository;
    private final MovieRepository movieRepository;

    @Autowired
    ReviewController(ReviewRepository reviewRepository,
                     MovieRepository movieRepository){
        this.reviewRepository = reviewRepository;
        this.movieRepository = movieRepository;
    }

    @GetMapping("/getMovieReviews")
    public ResponseEntity<List<ReviewEntity>> getMovieReviews(@RequestParam int movieId){
        if(this.movieRepository.findById(movieId).isPresent()){
            MovieEntity movie = this.movieRepository.findById(movieId).get();
            List<ReviewEntity> reviews = movie.getReviews();
            return new ResponseEntity<>(reviews, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/addReview")
    public ResponseEntity<String> addReview(@RequestBody ReviewEntity review, @RequestParam int movieId){
        if(this.movieRepository.findById(movieId).isPresent()){
            this.movieRepository.findById(movieId).get().getReviews().add(review);
            this.reviewRepository.save(review);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
