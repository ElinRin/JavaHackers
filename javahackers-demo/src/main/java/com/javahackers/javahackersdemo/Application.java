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

//@SpringBootApplication
//@EnableJpaAuditing
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.javahackers.javahackersdemo.entities"})
@EnableJpaRepositories(basePackages = {"com.javahackers.javahackersdemo.entities"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}


@Component
class DaysCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

    }

    @Autowired
    DaysRepository daysRepository;
}

