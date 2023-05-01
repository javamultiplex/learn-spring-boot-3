package com.github.javamultiplex.controller;

import com.github.javamultiplex.entity.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Rohit Agarwal on 01/05/23 10:00 pm
 * @copyright github.com/javamultiplex
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
public class PostControllerTest {

    @Container
    @ServiceConnection
    private static final MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.0.10");

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    //@DynamicPropertySource
    public static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry) {
        dynamicPropertyRegistry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
    }

    @Test
    public void shouldGetAllPost() {
        String url = String.format("http://localhost:%s/api/v1/posts", port);
        ResponseEntity<List<Post>> response = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Post>>() {
        });
        List<Post> posts = response.getBody();
        assertNotNull(posts);
        assertEquals(2, posts.size());
        assertEquals("Rohit", posts.get(0).author());
        assertEquals("Rahul", posts.get(1).author());
    }
}
