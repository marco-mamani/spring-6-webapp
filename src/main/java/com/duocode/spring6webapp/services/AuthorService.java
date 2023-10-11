package com.duocode.spring6webapp.services;

import com.duocode.spring6webapp.domain.Author;

public interface AuthorService {

  Iterable<Author> findAll();

}
