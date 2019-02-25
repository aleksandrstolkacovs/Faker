package tests;

import Faker.Base;
import Faker.DateTime;
import Faker.Payment;
import Faker.BaseInternet;
import Faker.se.sePerson;
import com.github.javafaker.Faker;

import static Faker.Base.randomElement;
import static Faker.se.sePerson.personalIdentityNumber;
import static Faker.se.sePerson.phone;

public class SePersonTest {
    private static Faker faker = new Faker();

    public static void main(String[] args) {

        BaseInternet baseInternet = new BaseInternet(faker);
        DateTime dateAndTime = new DateTime(faker);
        Payment payment = new Payment(faker);
        String[] gender = {"M", "W"};

        System.out.print("SE ID NUMBER" + Base.wordDistance("SE ID NUMBER", 15));
        System.out.print("EMAIL" + Base.wordDistance("EMAIL", 40));
        System.out.print("PHONE NUMBER" + Base.wordDistance("PHONE NUMBER", 15));
        System.out.print("NAME" + Base.wordDistance("NAME", 15));
        System.out.print("SURNAME" + Base.wordDistance("SURNAME", 12));
        System.out.println("IBAN" + Base.wordDistance("IBAN", 30));

        for (int i = 0; i < 10; i++) {

            String name = sePerson.firstName();
            String surname = sePerson.lastName();
            long birthDate = dateAndTime.birthday().getTime();
            String gen = randomElement(gender);

            String idNumber = personalIdentityNumber(birthDate, gen);
            String email = baseInternet.email(name, surname);
            String phone = phone();
            String iban = payment.ibanNumber("SE");

            System.out.print(idNumber + Base.wordDistance(idNumber, 15));
            System.out.print(email + Base.wordDistance(email, 40));
            System.out.print(phone + Base.wordDistance(phone, 15));
            System.out.print(name + Base.wordDistance(name, 15));
            System.out.print(surname + Base.wordDistance(surname, 12));
            System.out.println(iban + Base.wordDistance(iban, 30));
        }
    }
}
