package com.github.javamultiplex;

import com.github.javamultiplex.entity.Post;
import com.github.javamultiplex.repository.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DockerComposeDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DockerComposeDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(PostRepository postRepository) {
        return args -> {
            postRepository.saveAll(List.of(
                    new Post(null, "Java17 new features", "Rohit"),
                    new Post(null, "AWS Lambda", "Dhoni")
            ));
        };
    }
}
