package uz.pdp.b6cinemarestservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.pdp.b6cinemarestservice.model.User;
import uz.pdp.b6cinemarestservice.repository.UserRepository;


@Service
public class AuthService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() ->
                new IllegalStateException(String.format("Username with %s not found!!", username)));
        return user;
    }
}
