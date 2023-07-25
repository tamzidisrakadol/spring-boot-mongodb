package com.example.springbootmongodb.repo;

import com.example.springbootmongodb.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends MongoRepository<Book,Integer> {

}
