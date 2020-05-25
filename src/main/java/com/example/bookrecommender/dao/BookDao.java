package com.example.bookrecommender.dao;

import com.example.bookrecommender.domain.Author;
import com.example.bookrecommender.domain.Book;
import com.google.common.collect.ImmutableMap;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class BookDao {

    public static final long BOOK_1_ID = 1L;
    public static final long BOOK_2_ID = 2L;

    private static final Book BOOK_1 = new Book(BOOK_1_ID, "The Last Wish", new Author(1L, "Andrzej Sapkowski"));
    private static final Book BOOK_2 = new Book(BOOK_2_ID, "A Game of Thrones", new Author(2L, "George R. R. Martin"));
    private static final Map<Long, Book> FAKE_DB = ImmutableMap.of(BOOK_1_ID, BOOK_1,
                                                                   BOOK_2_ID, BOOK_2);

    public Book getBook(Long id) {
        return FAKE_DB.get(id);
    }

    public List<Book> materialize(List<Long> recommendedBookIds) {
        return recommendedBookIds.stream().map(this::getBook).filter(Objects::nonNull).collect(Collectors.toList());
    }
}
