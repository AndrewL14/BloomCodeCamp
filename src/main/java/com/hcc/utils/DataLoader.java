package com.hcc.utils;

import com.hcc.entities.Assignment;
import com.hcc.entities.Authority;
import com.hcc.entities.User;
import com.hcc.enums.AuthorityEnum;
import com.hcc.repositories.AssignmentRepository;
import com.hcc.repositories.AuthorityRepository;
import com.hcc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthorityRepository authorityRepository;
    @Override
    public void run(String... args) throws Exception {
        loadUserData();
    }

    /**
     * Creates a new User and puts the user inside the DB if there are no users already in
     * the DB. (these methods is mainly used for testing and debugging purposes)
     */
    private void loadUserData() {
        if (userRepository.count() == 0) {
            PasswordEncoder encoder = new BCryptPasswordEncoder();
            String password = encoder.encode("password");
            User user = new User.Builder().withCohortStartDate(LocalDate.now())
                    .withUsername("jhon")
                    .withPassword(password)
                    .build();
            userRepository.save(user);
        }
    }
}
