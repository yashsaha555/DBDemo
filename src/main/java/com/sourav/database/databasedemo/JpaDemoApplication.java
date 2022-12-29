package com.sourav.database.databasedemo;

import com.sourav.database.databasedemo.entity.Person;
import com.sourav.database.databasedemo.jpa.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

    @Autowired
    PersonJpaRepository personJpaRepository;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        SpringApplication.run(JpaDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("All users -> {}", personJpaRepository.findAll());
        logger.info("User ID 10001 -> {}", personJpaRepository.findById(10001));
//        logger.info("User Location -> {}", personJdbcDao.findByLocation("Kolkata"));
//        logger.info("User Name -> {}", personJdbcDao.findByName("Sourav"));
        personJpaRepository.deleteById(10002);
        logger.info("Inserting 10004 -> No. of rows modified is: {}", personJpaRepository.insert(new Person(10004,
                "Tara", "Berlin", new Date())));
        logger.info("Updating 10003 -> No. of rows modified is: {}", personJpaRepository.update(new Person(10003, "Peter", "New Jersey", new Date())));

    }
}
