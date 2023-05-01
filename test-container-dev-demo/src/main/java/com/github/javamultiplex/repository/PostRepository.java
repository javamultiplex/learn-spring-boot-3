package com.github.javamultiplex.repository;

import com.github.javamultiplex.entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Rohit Agarwal on 01/05/23 9:55 pm
 * @copyright github.com/javamultiplex
 */
public interface PostRepository extends MongoRepository<Post, String> {
}
