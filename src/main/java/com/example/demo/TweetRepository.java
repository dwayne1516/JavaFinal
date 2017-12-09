package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface TweetRepository extends CrudRepository<Tweet, Long> {
}