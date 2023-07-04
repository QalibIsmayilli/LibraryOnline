package com.company.library.service;

import com.company.library.dto.BookListItemResponse;
import com.company.library.dto.BookResponse;
import com.company.library.dto.requests.BookSaveRequest;
import com.company.library.model.Book;
import com.company.library.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final CategoryService categoryService;

    public BookService(BookRepository bookRepository, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.categoryService = categoryService;
    }

    @Transactional
    public BookListItemResponse save(BookSaveRequest bookSaveRequest) throws IOException {

            Book book = new Book(bookSaveRequest.getTitle(), bookSaveRequest.getAuthorName()
                    , bookSaveRequest.getBookStatus(), bookSaveRequest.getPublisher()
                    , bookSaveRequest.getLastPageNumber()
                    ,bookSaveRequest.getTotalPage()
                    , categoryService.getCategoryById(bookSaveRequest.getCategoryId()));

            final Book fromDb = bookRepository.save(book);

            return new BookListItemResponse(fromDb.getId(),fromDb.getTitle()
                    ,fromDb.getAuthorName(),fromDb.getBookStatus()
                    ,fromDb.getPublisher(), fromDb.getLastPageNumber()
                    , fromDb.getTotalPage(), fromDb.getCategory().getName());

    }

    public List<BookResponse> listBooks(int pageNo, int size){
        List<Book> books = bookRepository.findAll(PageRequest.of(pageNo-1, size)).getContent();

        List<BookResponse> result = books.stream().map(b -> new BookResponse(b.getTitle()
                ,b.getAuthorName()
                ,b.getImage().getImageUrl()))
                .collect(Collectors.toList());

        return result;
    }
}
