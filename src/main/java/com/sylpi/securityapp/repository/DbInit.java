package com.sylpi.securityapp.repository;

import com.sylpi.securityapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public DbInit(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        //delete all
        this.userRepository.deleteAll();

        // create some users
        User syl = new User("syl", passwordEncoder.encode("sylpi"), "USER", "");
        User admin = new User("admin", passwordEncoder.encode("admin"), "ADMIN", "ACCESS_TEST1, ACCESS_TEST2");
        User manager = new User("manager", passwordEncoder.encode("manager"), "MANAGER", "ACCESS_TEST1");

        List<User> users = Arrays.asList(syl, admin, manager);

        this.userRepository.saveAll(users);
    }
}
