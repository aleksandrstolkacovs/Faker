package Faker;

import com.github.javafaker.Faker;
import com.github.javafaker.Internet;
import org.apache.commons.lang3.RandomStringUtils;

import static Faker.Base.*;

public class BaseInternet extends Internet {

    Faker faker = new Faker();

    public BaseInternet(Faker faker) {
        super(faker);
    }

    public String email(String firstName, String lastName) {
        return faker.internet().emailAddress(firstName + "." + lastName + numberBetween(11, 99));
    }

    public String emailLatinLetters() {
        String qa = "qaTest";
        return qa + "." + RandomStringUtils.randomAlphabetic(8) + numberBetween(11, 99) + "@test.com";
    }
}
