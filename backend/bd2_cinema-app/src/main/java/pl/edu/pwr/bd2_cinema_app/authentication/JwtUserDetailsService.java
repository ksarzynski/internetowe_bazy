package pl.edu.pwr.bd2_cinema_app.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.edu.pwr.bd2_cinema_app.dto.UserDTO;
import pl.edu.pwr.bd2_cinema_app.model.UserEntity;
import pl.edu.pwr.bd2_cinema_app.repository.UserRepository;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Bad username: " + username);
        }
        return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }
    
    public int getUserIdByUsername(String userName) {
        return userRepository.findByUsername(userName).getUser_id();
    }

    public UserEntity save(UserDTO user) {
        UserEntity newUser = new UserEntity();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        newUser.setEmail(user.getEmail());
        return userRepository.save(newUser);
    }
}
















/*
// zmienneGlobalne.ts

export const user: User = new User();

updateUser(userZApi: User): void {
        user = userZApi
        
        // jak nie zadziala
        user.id = userZApi.id
}


        
        
        
///////////////////////////////
import {user} from 'zmienneGlobalne'


@Component(
        //dasd/as
)
export class FooComponent implements NgOnInit {

//    const myUser: User

    ngOnInit() {
//        this.myUser = user
    }

    constructor() {
    }

    zrobCos(): void {
        console.log(user.id)
    }
}

*/



