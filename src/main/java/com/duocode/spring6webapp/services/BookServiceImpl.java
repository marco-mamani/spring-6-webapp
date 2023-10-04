package com.duocode.spring6webapp.services;

import com.duocode.spring6webapp.domain.Book;
import com.duocode.spring6webapp.respositories.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

  private final BookRepository bookRepository;

  public BookServiceImpl(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @Override
  public Iterable<Book> findAll() {
    return bookRepository.findAll();
  }
}
