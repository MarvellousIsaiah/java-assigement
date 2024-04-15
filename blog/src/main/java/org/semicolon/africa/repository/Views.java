package org.semicolon.africa.repository;


import org.semicolon.africa.data.models.View;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Views extends MongoRepository<View,String> {
}
