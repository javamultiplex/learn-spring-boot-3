package com.github.javamultiplex;

import org.springframework.boot.SpringApplication;

/**
 * @author Rohit Agarwal on 01/05/23 6:28 pm
 * @copyright github.com/javamultiplex
 */
public class TestMainApplication {

    public static void main(String[] args) {
        SpringApplication
                .from(MainApplication::main)
                .with(MongoDBConfiguration.class)
                .run(args);
    }
}


