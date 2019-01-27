package com.javahackers.javahackersdemo;

import com.javahackers.javahackersdemo.repositories.DaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.javahackers.javahackersdemo.entities"})
@EnableJpaRepositories(basePackages = {"com.javahackers.javahackersdemo.repositories"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}


//@Component
//class DaysCommandLineRunner implements CommandLineRunner {
//
//    @Autowired
//    public DaysCommandLineRunner(DaysRepository daysRepository) {
//        this.daysRepository = daysRepository;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//
//    }
//
//    private final DaysRepository daysRepository;
//}
//
