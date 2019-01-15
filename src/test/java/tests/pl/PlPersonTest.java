package tests.pl;

import Faker.Base;
import Faker.Payment;
import Faker.DateTime;
import Faker.BaseInternet;
import Faker.pl.plPerson;
import com.github.javafaker.Faker;
import com.sun.javaws.exceptions.InvalidArgumentException;
import static Faker.pl.plPerson.*;

public class PlPersonTest {
    private static Faker faker = new Faker();

    public static void main(String[] args) throws InvalidArgumentException {

        BaseInternet baseInternet = new BaseInternet(faker);
        Payment payment = new Payment(faker);
        DateTime dateAndTime = new DateTime(faker);
        String[] gender = {"M","W"};

        System.out.print("NAME" + Base.wordDistance("NAME", 15));
        System.out.print("SURNAME" + Base.wordDistance("SURNAME", 15));
        System.out.print("PL ID NUMBER" + Base.wordDistance("PL ID NUMBER", 15));
        System.out.print("DOC NUMBER" + Base.wordDistance("DOC NUMBER", 12));
        System.out.print("EMAIL" + Base.wordDistance("EMAIL", 40));
        System.out.print("POSTCODE" + Base.wordDistance("POSTCODE", 10));
        System.out.print("PHONE NUMBER" + Base.wordDistance("PHONE NUMBER", 15));
        System.out.print("IBAN" + Base.wordDistance("IBAN", 35));
        System.out.print("BANK" + Base.wordDistance("BANK", 55));
        System.out.println();

        for (int i = 0; i < 10; i++) {

            String name = plPerson.firstName();
            String surname = plPerson.lastName();
            long birthDate = dateAndTime.birthday().getTime();
            String gen = randomElement(gender);
            String idNumber = pesel(birthDate, gen);
            String email = baseInternet.email(plPerson.firstName(),plPerson.lastName());
            String phone = phone();
            String document = personalIdentityNumber();
            String iban = payment.ibanNumber("PL");
            String bank = payment.PLbank();

            System.out.print(name + Base.wordDistance(name, 15));
            System.out.print(surname + Base.wordDistance(surname, 15));
            System.out.print(idNumber + Base.wordDistance(idNumber, 15));
            System.out.print(document + Base.wordDistance(document, 12));
            System.out.print(email + Base.wordDistance(email, 40));
            System.out.print("0001" + Base.wordDistance("0001", 10));
            System.out.print(phone + Base.wordDistance(phone, 15));
            System.out.print(iban + Base.wordDistance(iban, 35));
            System.out.println(bank + Base.wordDistance(bank, 55));
        }
    }
}
