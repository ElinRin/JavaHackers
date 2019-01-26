package com.javahackers.javahackersdemo;

import com.javahackers.javahackersdemo.db.DaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
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

