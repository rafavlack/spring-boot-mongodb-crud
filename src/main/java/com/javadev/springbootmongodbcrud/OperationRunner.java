package com.javadev.springbootmongodbcrud;

import java.util.Arrays;
import java.util.List;

import com.javadev.springbootmongodbcrud.model.Book;
import com.javadev.springbootmongodbcrud.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class OperationRunner implements CommandLineRunner {

    private final BookRepository bookRepository;

    public OperationRunner(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // saveAll() operation : saveAll() inserts more than one records at a time

        bookRepository.saveAll(Arrays.asList(
                new Book(501, "Core Java", "Kathy Sierra", 1065.5),
                new Book(502, "Spring in Action", "Craig Walls", 940.75),
                new Book(503, "Hibernate in Action", "Gavin King", 889.25),
                new Book(504, "Practical MongoDB", "Shakuntala Gupta", 785.0)
        ));

        // save() operation : Updating ID(PK) manually (allowed) : It will create one new record

        Book book = bookRepository.save(new Book("ISBN10:1484240251", 504,"Practical MongoDB", "Shakuntala Gupta", 785.0));  // insert

        // save() operation : save() also updates record based on the PK

        bookRepository.save(new Book("ISBN10:1484240251", 505,"Practical MongoDB", "Shakuntala Gupta", 728.0));  // update
        bookRepository.save(new Book(book.getId(), 505,"Practical MongoDB", "Navin Sabharwal", 798.0));  // update

        // insert() operation : This method will also insert one new record

        bookRepository.insert(new Book(506,"Java Design Patterns", "Kathy Sierra", 924.0)); // insert

        System.out.println("All Data saved into MongoDB");
    }
}