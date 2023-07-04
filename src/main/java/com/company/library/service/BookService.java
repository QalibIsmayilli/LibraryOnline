package com.company.library.service;

import com.company.library.dto.BookListItemResponse;
import com.company.library.dto.BookResponse;
import com.company.library.dto.requests.BookSaveRequest;
import com.company.library.model.Book;
import com.company.library.model.Category;
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

        Book book = new Book.Builder().title(bookSaveRequest.getTitle()).authorName(bookSaveRequest.getAuthorName())
                .bookStatus(bookSaveRequest.getBookStatus()).publisher(bookSaveRequest.getPublisher())
                .lastPageNumber(bookSaveRequest.getLastPageNumber()).totalPage(bookSaveRequest.getTotalPage())
                .category(categoryService.getCategoryById(bookSaveRequest.getCategoryId())).build();

        final Book fromDb = bookRepository.save(book);

        return new BookListItemResponse.Builder().id(fromDb.getId()).title(fromDb.getTitle())
                .authorName(fromDb.getAuthorName()).bookStatus(fromDb.getBookStatus())
                .publisher(fromDb.getPublisher()).lastPageNumber(fromDb.getLastPageNumber())
                .totalPage(fromDb.getTotalPage()).categoryName(fromDb.getCategory().getName()).build();

    }

    public List<BookResponse> listBooks(int pageNo, int size) {
        List<Book> books = bookRepository.findAll(PageRequest.of(pageNo - 1, size)).getContent();


        List<BookResponse> result = books.stream().map(b -> new BookResponse.Builder().title(b.getTitle())
                        .authorName(b.getAuthorName()).imageUrl(b.getImage().getImageUrl()).build())
                .collect(Collectors.toList());

        return result;
    }

    public List<BookResponse> searchByCategory(String categoryName) {
        Category category = categoryService.getCategoryByName(categoryName);

        List<Book> books = category.getBooks();

        List<BookResponse> result = books.stream().map(b -> new BookResponse.Builder().id(b.getId())
                .title(b.getTitle()).authorName(b.getAuthorName()).imageUrl(b.getImage().getImageUrl()).build())
                .collect(Collectors.toList());
        return result;
    }
}
