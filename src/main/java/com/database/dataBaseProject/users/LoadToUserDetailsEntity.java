package com.database.dataBaseProject.users;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LoadToUserDetailsEntity implements CommandLineRunner {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private UserDetailsRepository repository;

    public LoadToUserDetailsEntity(UserDetailsRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("PreLoading " + repository.save(new UserDetails("Baha","Admin")));
        logger.info("PreLoading " + repository.save(new UserDetails("Abood","Admin")));


        List<UserDetails> users = repository.findAll();
        users.forEach(user -> logger.info(user.toString()));
    }
}
