package com.javadev.springbootmongodbcrud.repository;

import com.javadev.springbootmongodbcrud.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BookRepository extends MongoRepository<Book, String> {

    Optional<Book> getBookById(String idBook);
}
