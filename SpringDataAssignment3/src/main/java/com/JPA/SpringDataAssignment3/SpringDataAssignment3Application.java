package com.JPA.SpringDataAssignment3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataAssignment3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataAssignment3Application.class, args);
	}


	/*
	src->main->java->entities
	src->main->java->repositories
	src->test->SpringDataAssignment3ApplicationTests class

	* Ques 1 => entities package -> Address class

	* Ques 2 => entities package -> Ques3an4->Author class

	* Ques 3 => entities package -> Ques3and4 package -> Subject class

	* Ques 4 => entities package -> Ques3and4 package and SpringDataAssignment3ApplicationTests class -> testCreateAuthorWIthSubject()

	* Ques 5 => entities package -> OneToOne package -> Book class

	* Ques 6 => entities package -> OneToOne package and SpringDataAssignment3ApplicationTests class -> testOneToOneCreateAuthor()

	* Ques 7 => entities package -> OneToMany package and SpringDataAssignment3ApplicationTests class -> testCreateAuthorOneToMany()

	* Ques 8 => entities package -> ManyToMany package and SpringDataAssignment3ApplicationTests class -> testManyToManyCreateAuthor()


	* Ques 9 - Which method on the session object can be used to remove an object from the cache?
	* 		=> evict() method can be used on the session object to remove an object from the cache.

	* Ques 10 - What does @transactional annotation do?
	* 		=> Classes that declare @Transactional on the class or on members are proxied by Spring.
	* 		   At runtime, the proxy is largely unnoticed. It allows Spring to inject behaviours into
	* 		   the object that is being proxied before, after, or around method calls. One of the habits
	* 		   that can be hooked in is transaction management. Another are security tests.

	*/
}
