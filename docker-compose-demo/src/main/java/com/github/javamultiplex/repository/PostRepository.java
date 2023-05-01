package com.github.javamultiplex.repository;

import com.github.javamultiplex.entity.Post;
import org.springframework.data.repository.ListCrudRepository;

/**
 * @author Rohit Agarwal on 01/05/23 5:58 pm
 * @copyright github.com/javamultiplex
 */

public interface PostRepository extends ListCrudRepository<Post, Integer> {
}
