package com.duocode.spring6webapp.bootstrap;

import com.duocode.spring6webapp.domain.Author;
import com.duocode.spring6webapp.domain.Book;
import com.duocode.spring6webapp.domain.Publisher;
import com.duocode.spring6webapp.respositories.AuthorRespository;
import com.duocode.spring6webapp.respositories.BookRepository;
import com.duocode.spring6webapp.respositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

  private final AuthorRespository authorRespository;
  private final BookRepository bookRepository;
  private final PublisherRepository publisherRepository;

  public BootstrapData(AuthorRespository authorRespository,
      BookRepository bookRepository,
      PublisherRepository publisherRepository) {
    this.authorRespository = authorRespository;
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    Author eric = new Author();
    eric.setFirstName("Eric");
    eric.setLastName("Evans");

    Book ddd = new Book();
    ddd.setTitle("Domain Driven Desing");
    ddd.setIsbn("12345");

    Author ericSaved = authorRespository.save(eric);
    Book dddSaved = bookRepository.save(ddd);

    Author rod = new Author();
    rod.setFirstName("Rod");
    rod.setLastName("Johnson");

    Book noEJB = new Book();
    noEJB.setTitle("J2EE Development without EJB");
    noEJB.setIsbn("546123");

    Author rodSaved = authorRespository.save(rod);
    Book noEJBSaved = bookRepository.save(noEJB);

    ericSaved.getBooks().add(dddSaved);
    rodSaved.getBooks().add(noEJBSaved);
    dddSaved.getAuthors().add(ericSaved);
    noEJBSaved.getAuthors().add(rodSaved);

    Publisher publisher = new Publisher();
    publisher.setPublisherName("My Publisher");
    publisher.setAddress("123 Main");
    Publisher savedPublisher = publisherRepository.save(publisher);

    dddSaved.setPublisher(savedPublisher);
    noEJBSaved.setPublisher(savedPublisher);

    authorRespository.save(ericSaved);
    authorRespository.save(rodSaved);
    bookRepository.save(dddSaved);
    bookRepository.save(noEJBSaved);

    System.out.println("In Bootstrap");
    System.out.println("Author Count: " + authorRespository.count());
    System.out.println("Book Count: " + bookRepository.count());
    System.out.println("Publisher count: " + publisherRepository.count());
  }
}
