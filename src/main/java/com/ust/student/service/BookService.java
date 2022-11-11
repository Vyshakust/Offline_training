package com.ust.student.service;

import com.ust.student.entity.Book;
import com.ust.student.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    public void saveBook(Book book) {
        book.setModifiedDate(LocalDateTime.now());
        book.setDate(LocalDateTime.now());
        bookRepository.save(book);

    }

    public Book getBookById(int bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }


    public List<Book> getBookAll() {
        return bookRepository.findAll();
    }

    public void deleteBook(Integer bookId) {
        bookRepository.deleteById(bookId);
    }

    public Book updateBook(Book book) {
        Book updateBook=bookRepository.findById(book.getBookId()).orElseThrow(()->new NoSuchElementException());
        updateBook.setBookAuthorName(book.getBookAuthorName());
        updateBook.setBookIsp(book.getBookIsp());
        updateBook.setBookName(book.getBookName());
        updateBook.setModifiedDate(LocalDateTime.now());
        bookRepository.save(updateBook);
        return updateBook;
    }
}


