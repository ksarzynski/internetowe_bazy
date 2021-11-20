package pl.edu.pwr.bd2_cinema_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pwr.bd2_cinema_app.repository.CinemaBranchRepository;

@RestController
@RequestMapping("/branches")
public class CinemaBranchController {

    private final CinemaBranchRepository cinemaBranchRepository;

    @Autowired
    CinemaBranchController(CinemaBranchRepository cinemaBranchRepository){
        this.cinemaBranchRepository = cinemaBranchRepository;
    }
}
