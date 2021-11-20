package pl.edu.pwr.bd2_cinema_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pwr.bd2_cinema_app.repository.DirectorRepository;

@RestController
@RequestMapping("/directors")
public class DirectorController {

    private final DirectorRepository directorRepository;

    @Autowired
    DirectorController(DirectorRepository directorRepository){
        this.directorRepository = directorRepository;
    }
}
