package com.hcc.services;

 import com.hcc.entities.User;
 import com.hcc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.security.core.userdetails.UserDetails;
 import org.springframework.security.core.userdetails.UserDetailsService;
 import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
     UserRepository userRepo;

    /**
     *  Fetches a User with a given username if the user is not found throws
     *  A UsernameNotFoundException.
     * @param username the username identifying the user whose data is required.
     * @return A UserDetails with a valid user
     * @throws UsernameNotFoundException If user was not found.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOpt = userRepo.findByUsername(username);
//        userOpt.get().setUsername(username);
//        userOpt.get().setPassword(passwordEncoder.getPasswordEncoder().encode("asdfasdf"));
        return userOpt.orElseThrow(() -> new UsernameNotFoundException("Invalid Credentials"));
    }
}
