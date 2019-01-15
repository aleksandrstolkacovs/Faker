package Faker;

import com.github.javafaker.Faker;
import com.github.javafaker.Internet;
import static Faker.Base.*;

public class BaseInternet extends Internet {

    Faker faker = new Faker();
    public static final String[] freeEmailDomain = {"gmail.com", "yahoo.com", "hotmail.com"};
    public static final String[] tld = {"com", "biz", "info", "net", "org"};

    public BaseInternet(Faker faker) {
        super(faker);
    }

    /**
     * Returns a random email, using faker library
     * @return string
     */
    public String email(String firstName, String lastName) {
        return faker.internet().emailAddress(firstName + "." + lastName + numberBetween(11, 99));
    }
}
