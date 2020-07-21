package com.example.datasource.datasource.repository.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.datasource.datasource.model.book.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
