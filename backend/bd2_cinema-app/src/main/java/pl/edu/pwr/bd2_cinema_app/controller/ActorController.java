package pl.edu.pwr.bd2_cinema_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pwr.bd2_cinema_app.repository.ActorRepository;

@RestController
@RequestMapping("/actors")
public class ActorController {

    private final ActorRepository actorRepository;

    @Autowired
    ActorController(ActorRepository actorRepository){
        this.actorRepository = actorRepository;
    }
}
