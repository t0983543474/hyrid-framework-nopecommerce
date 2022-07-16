package javaBasic;

import com.github.javafaker.Faker;

public class JavaFaker {
	public static void main(String[] args) {
		Faker faker = new Faker();
		
		System.out.println(faker.address().firstName());
		System.out.println(faker.address().fullAddress());
		System.out.println(faker.business().creditCardExpiry());
		System.out.println(faker.business().creditCardNumber());
	}
}
