package com.sylpi.securityapp.repository;

import com.sylpi.securityapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        User syl = new User("syl", "sylpi", "USER", "");
        User admin = new User("admin", "admin", "ADMIN", "ACCESS_TEST1, ACCESS_TEST2");
        User manager = new User("manager", "manager", "MANAGER", "ACCESS_TEST1");

        List<User> users = Arrays.asList(syl, admin, manager);

        this.userRepository.saveAll(users);
    }
}
