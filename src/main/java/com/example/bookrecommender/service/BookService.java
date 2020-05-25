package com.example.bookrecommender.service;

import com.example.bookrecommender.dao.BookDao;
import com.example.bookrecommender.domain.Book;
import com.example.bookrecommender.model.BookRecommendationModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRecommendationModel bookRecommendationModel;
    private final BookDao bookDao;

    public BookService(BookRecommendationModel bookRecommendationModel, BookDao bookDao) {
        this.bookRecommendationModel = bookRecommendationModel;
        this.bookDao = bookDao;
    }

    public List<Book> getRecommendations(String bookName) {
        List<Long> recommendedBookIds = bookRecommendationModel.getRecommendations(bookName);
        List<Book> books = bookDao.materialize(recommendedBookIds);

        // around here maybe save input and the recommendations for logging purposes
        return bookRecommendationModel.sortByScoringFunction(books);
    }
}
