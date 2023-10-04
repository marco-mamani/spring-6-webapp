package com.duocode.spring6webapp.services;

import com.duocode.spring6webapp.domain.Book;

public interface BookService {

  Iterable<Book> findAll();

}
