package com.example.bookrecommender.controller;

import com.example.bookrecommender.domain.Book;
import com.example.bookrecommender.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    static final int MAX_RECOMMENDATIONS = 10;

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/book/recommend")
    public List<Book> getRecommendations(@RequestParam(value = "bookName") String bookName) {
        List<Book> recommendations = bookService.getRecommendations(bookName);

        // maybe display just top 10 recommendations to the user
        return recommendations.subList(0, Math.min(MAX_RECOMMENDATIONS, recommendations.size()));
    }

}
