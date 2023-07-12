package com.company.library.api;

import com.company.library.dto.BookListItemResponse;
import com.company.library.dto.BookResponse;
import com.company.library.dto.requests.BookSaveRequest;
import com.company.library.model.BookStatus;
import com.company.library.service.BookService;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/saveBook")
    public ResponseEntity<BookListItemResponse> save(@Valid @RequestBody BookSaveRequest bookSaveRequest){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(bookService.save(bookSaveRequest));
    }



    @GetMapping("/list")
    public ResponseEntity<List<BookResponse>> listBooks(
            @RequestParam Integer pageNo
            , @RequestParam Integer size
    ){
        return ResponseEntity.ok(bookService.listBooks(pageNo, size));
    }

    @GetMapping("/searchByCategoryName")
    public ResponseEntity<List<BookResponse>> searchByCategory(@RequestParam String categoryName){
        return ResponseEntity.ok(bookService.searchByCategory(categoryName));
    }


    @GetMapping("/searchByBookStatus")
    public ResponseEntity<List<BookResponse>> searchByBookStatus(@RequestBody BookStatus bookStatus){
        return ResponseEntity.ok(bookService.searchByBookStatus(bookStatus));
    }

    @GetMapping("/searchByTitle")
    public ResponseEntity<List<BookResponse>> searchByTitle(@RequestParam String title ){
        return ResponseEntity.ok(bookService.searchByTitle(title));
    }

}
