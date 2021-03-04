package com.introduction.spring.IntroductionToSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class IntroductionToSpringApplication {

	public static void main(String[] args) {

		int[] array = {89,67,24,1,45,3,89,9};
		int searchElement = 45;
		boolean elementFound;

		System.out.println("Ques1 Tight coupling Example");
		BinarySearchTightCoupled binarySearchTightCoupled = new BinarySearchTightCoupled();
		elementFound = binarySearchTightCoupled.search(array,searchElement);
		if(elementFound)
		System.out.println(searchElement + " found in array.");

		System.out.println("\nQues2 Loose coupling Example");
		searchElement = 1;
		BinarySearchLooseCoupled binarySearchLooseCoupled = new BinarySearchLooseCoupled(new InsertionSortLooseCoupled());
		elementFound = binarySearchLooseCoupled.getSearchElement(array,searchElement);
		if(elementFound)
			System.out.println(searchElement + " found in array.");


		ApplicationContext applicationContext = SpringApplication.run(IntroductionToSpringApplication.class, args);
		System.out.println("\n(3) Use @Compenent and @Autowired annotations to in Loosely Coupled code for dependency management did for all the looselycoupled classes \n" +
				"\n" +
				"(4) Get a Spring Bean from application context and display its properties.\n" +
				"\n" +
				"(5) Demonstrate how you will resolve ambiguity while autowiring bean used @Primary for BubbleSortLooseCoupled\n" +
				"\n" +
				"(6) Perform Constructor Injection in a Spring Bean -> Done in BinarySearchLooselyCoupled class");
		BinarySearchLooseCoupled binarySearchLooseCoupled2 = applicationContext.getBean(BinarySearchLooseCoupled.class);
		searchElement = 89;
		System.out.println("\nProperties of the BinarySearchLooseCoupled class");
		System.out.println("alterName :" + binarySearchLooseCoupled2.getAlterName());
		System.out.println("timeComplexity :" + binarySearchLooseCoupled2.getTimeComplexity()+"\n");
		elementFound = binarySearchLooseCoupled2.getSearchElement(array,searchElement);
		if(elementFound)
			System.out.println(searchElement + " found in array.");
	}
}
