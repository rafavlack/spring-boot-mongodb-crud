package com.javadev.springbootmongodbcrud.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Document              // Maps Entity class objects to JSON formatted Documents
public class Book {

    @Id                 // making this variable as ID, will be auto-generated by MongoDB
    private String id;

    @NonNull
    private Integer bookId;
    @NonNull
    private String bookName;
    @NonNull
    private String bookAuthor;
    @NonNull
    private Double bookCost;
}