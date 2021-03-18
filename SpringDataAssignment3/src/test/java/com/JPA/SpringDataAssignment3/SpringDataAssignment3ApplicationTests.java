package com.JPA.SpringDataAssignment3;

import com.JPA.SpringDataAssignment3.entities.Address;
import com.JPA.SpringDataAssignment3.entities.ManyToMany.AuthorManyToMany;
import com.JPA.SpringDataAssignment3.entities.ManyToMany.BookManyToMany;
import com.JPA.SpringDataAssignment3.entities.OneToMany.AuthorOneToMany;
import com.JPA.SpringDataAssignment3.entities.OneToMany.BookManyToOne;
import com.JPA.SpringDataAssignment3.entities.OneToManyUnidirectional.AuthorOneToManyUnidirectional;
import com.JPA.SpringDataAssignment3.entities.OneToManyUnidirectional.BookOneToManyUnidirectional;
import com.JPA.SpringDataAssignment3.entities.OneToOne.AuthorOneToOne;
import com.JPA.SpringDataAssignment3.entities.OneToOne.BookOneToOne;
import com.JPA.SpringDataAssignment3.entities.Ques3and4.Author;
import com.JPA.SpringDataAssignment3.entities.Ques3and4.Subject;
import com.JPA.SpringDataAssignment3.repositories.ManyToMany.AuthorRepoManyToMany;
import com.JPA.SpringDataAssignment3.repositories.OneToMany.AuthorRepoOneToMany;
import com.JPA.SpringDataAssignment3.repositories.OneToManyUnidirectional.AuthorRepoOneToManyUnidirectional;
import com.JPA.SpringDataAssignment3.repositories.OneToOne.AuthorRepoOneToOne;
import com.JPA.SpringDataAssignment3.repositories.Ques3and4.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;

@SpringBootTest
class SpringDataAssignment3ApplicationTests {

	@Autowired
	AuthorRepository authorRepository;

	@Autowired
	AuthorRepoOneToMany authorRepoOneToMany;

	@Autowired
	AuthorRepoOneToManyUnidirectional authorRepoOneToManyUnidirectional;

	@Autowired
	AuthorRepoOneToOne authorRepoOneToOne;

	@Autowired
	AuthorRepoManyToMany authorRepoManyToMany;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCreateAuthorWIthSubject(){
		Author author = new Author();
		author.setName("Jatin");

		Address address = new Address();
		address.setStreetNumber("123b");
		address.setLocation("faridabad");
		address.setState("Haryana");
		author.setAddress(address);

		Subject subject = new Subject();
		subject.setSubjectName("educational");

		Subject subject2 = new Subject();
		subject2.setSubjectName("Practical");

		Subject subject3 = new Subject();
		subject3.setSubjectName("theory");

		author.addSubjectName(subject);
		author.addSubjectName(subject2);
		author.addSubjectName(subject3);
		authorRepository.save(author);
	}

	@Test
	public void testOneToOneCreateAuthor(){
		AuthorOneToOne author = new AuthorOneToOne();
		author.setName("Rahul");

		Address address = new Address();
		address.setStreetNumber("25s");
		address.setLocation("lucknow");
		address.setState("up");
		author.setAddress(address);

		BookOneToOne book = new BookOneToOne();
		book.setBookName("Poems");
		book.setAuthor(author);
		author.setBook(book);

		authorRepoOneToOne.save(author);
	}

	@Test
	public void testCreateAuthorOneToManyUnidirectional(){
		AuthorOneToManyUnidirectional author = new AuthorOneToManyUnidirectional();
		author.setName("Daminee");

		Address address = new Address();
		address.setStreetNumber("123b");
		address.setLocation("mundka");
		address.setState("Delhi");
		author.setAddress(address);

		BookOneToManyUnidirectional book = new BookOneToManyUnidirectional();
		book.setBookName("java");

		BookOneToManyUnidirectional book2 = new BookOneToManyUnidirectional();
		book2.setBookName("spring boot");

		author.addBookName(book);
		author.addBookName(book2);

		authorRepoOneToManyUnidirectional.save(author);
	}

	@Test
	public void testCreateAuthorOneToMany(){
		AuthorOneToMany author = new AuthorOneToMany();
		author.setName("Daminee");

		Address address = new Address();
		address.setStreetNumber("123b");
		address.setLocation("mundka");
		address.setState("Delhi");
		author.setAddress(address);

		BookManyToOne book = new BookManyToOne();
		book.setBookName("java");

		BookManyToOne book2 = new BookManyToOne();
		book2.setBookName("spring boot");

		author.addBookName(book);
		author.addBookName(book2);

		authorRepoOneToMany.save(author);
	}

	@Test
	public void testManyToManyCreateAuthor(){
		AuthorManyToMany authorManyToMany = new AuthorManyToMany();
		authorManyToMany.setName("Divit");

		Address address = new Address();
		address.setStreetNumber("25s");
		address.setLocation("mumbai");
		address.setState("Maharashtra");
		authorManyToMany.setAddress(address);

		HashSet<BookManyToMany> books = new HashSet<>();
		BookManyToMany bookManyToMany = new BookManyToMany();
		bookManyToMany.setBookName("python");
		books.add(bookManyToMany);

		authorManyToMany.setBooks(books);

		authorRepoManyToMany.save(authorManyToMany);

	}

}
