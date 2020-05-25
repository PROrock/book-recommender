package com.example.bookrecommender.controller;

import com.example.bookrecommender.domain.Author;
import com.example.bookrecommender.domain.Book;
import com.example.bookrecommender.service.BookService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static com.example.bookrecommender.controller.BookController.MAX_RECOMMENDATIONS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookControllerTest {

    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;


    @Test
    void getRecommendations_returnsLessThan10Recommendations_ifTheServiceReturnsLessThan10() {
        int nRecommendedBooks = 2;
        when(bookService.getRecommendations(anyString())).thenReturn(getBooks(nRecommendedBooks));

        List<Book> books = bookController.getRecommendations("Harry Potter");

        assertThat(books).hasSize(nRecommendedBooks);
    }

    @Test
    void getRecommendations_returns10Recommendations_ifTheServiceReturnsMore() {
        when(bookService.getRecommendations(anyString())).thenReturn(getBooks(MAX_RECOMMENDATIONS + 1));

        List<Book> books = bookController.getRecommendations("Harry Potter");

        assertThat(books).hasSize(MAX_RECOMMENDATIONS);
    }

    private List<Book> getBooks(int nBooks) {
        List<Book> books = new ArrayList<>(nBooks);
        for (long i = 0; i < nBooks; i++) {
            books.add(new Book(i, "Book " + i, new Author(i, "Author " + i)));
        }
        return books;
    }
}