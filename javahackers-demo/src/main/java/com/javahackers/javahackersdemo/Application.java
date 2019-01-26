package com.javahackers.javahackersdemo;

import com.javahackers.javahackersdemo.db.DaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

//@SpringBootApplication
//@EnableJpaAuditing
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
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

