package Faker;

import com.github.javafaker.Faker;
import com.github.javafaker.Internet;
import static Faker.Base.*;

public class BaseInternet extends Internet {

    Faker faker = new Faker();

    public BaseInternet(Faker faker) {
        super(faker);
    }

    public String email(String firstName, String lastName) {
        return faker.internet().emailAddress(firstName + "." + lastName + numberBetween(11, 99));
    }
}
