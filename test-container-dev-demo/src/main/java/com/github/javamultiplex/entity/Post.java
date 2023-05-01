package com.github.javamultiplex.entity;


import org.springframework.data.annotation.Id;

/**
 * @author Rohit Agarwal on 01/05/23 9:24 pm
 * @copyright github.com/javamultiplex
 */

public record Post(@Id String uuid, String title, String author) {
}