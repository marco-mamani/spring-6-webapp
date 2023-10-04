package com.duocode.spring6webapp.respositories;

import com.duocode.spring6webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRespository extends CrudRepository<Author, Long> {

}
