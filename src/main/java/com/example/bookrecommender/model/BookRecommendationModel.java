package com.example.bookrecommender.model;

import com.example.bookrecommender.dao.BookDao;
import com.example.bookrecommender.domain.Book;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
public class BookRecommendationModel {

    public List<Long> getRecommendations(String bookName) {
        // fake implementation - here would be the ML recommendation model algorithm called
        return Arrays.asList(BookDao.BOOK_1_ID, BookDao.BOOK_2_ID);
    }

    public List<Book> sortByScoringFunction(List<Book> books) {
        // "mock" implementation of sorting by scoring function
        books.sort(Comparator.comparing(Book::getName));
        return books;
    }

}
