package com.github.javamultiplex;

import com.github.javamultiplex.entity.Post;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner(MongoTemplate mongoTemplate) {
        return args -> {
            mongoTemplate.save(new Post(null, "Java17 new features", "Rohit"));
            mongoTemplate.save(new Post(null, "AWS features", "Rahul"));
        };
    }
}
