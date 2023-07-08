package com.company.library.repository;

import com.company.library.model.Book;
import com.company.library.model.BookStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,String> , JpaSpecificationExecutor<Book> {
    List<Book> getBooksByBookStatus(BookStatus bookStatus);

    List<Book> getBooksByTitle(String title);

}
