package utilities;

import java.util.Locale;

import com.github.javafaker.Faker;

public class DataHelper {
	private Locale local = new Locale("vi");
	Faker faker = new Faker();
	
	public static DataHelper getdataHelper() {
		return new DataHelper();
	}
	
	public String getFirstName() {
		return faker.address().firstName();
		
	}
	public String getLastName() {
		return faker.address().lastName();
		
	}
	public String getEmail()
	{
		return faker.internet().emailAddress();
	}
	
	public String getPassword() {
		return faker.internet().password(6, 8, true, true);
	}
}
