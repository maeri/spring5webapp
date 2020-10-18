package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(BootstrapData.class);

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;

	public BootstrapData(AuthorRepository authorRepository,
						 BookRepository bookRepository,
						 PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	public void run(String... args) throws Exception {
		Book book = new Book("first Book", "123");
		Author author = new Author("firstName", "lastName");
		Publisher publisher = new Publisher("publisher", "address", "city", "state", "zip");

		author.getBooks().add(book);
		book.getAuthors().add(author);
		publisherRepository.save(publisher);

		book.setPublisher(publisher);
		publisher.getBooks().add(book);

		authorRepository.save(author);
		bookRepository.save(book);
		publisherRepository.save(publisher);

		logger.info("Count number of records (author): " + authorRepository.count());

		logger.info("Count number of records (publisher): " + publisherRepository.count());

		for (Publisher pub : publisherRepository.findAll()) {
//			for (Book bk : pub.getBooks()) {
				logger.info("Books that was published by publisher " + pub);
//			}
		}


	}
}
