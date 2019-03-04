package tests;

import Faker.Base;
import Faker.Payment;
import Faker.DateTime;
import Faker.BaseInternet;
import Faker.pl.plPerson;
import com.github.javafaker.Faker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import static Faker.pl.plPerson.*;

public class PlPersonTest {
    private static Faker faker = new Faker();

    public static void main(String[] args) {

        BaseInternet baseInternet = new BaseInternet(faker);
        Payment payment = new Payment(faker);
        DateTime dateAndTime = new DateTime(faker);
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String[] gender = {"M","W"};

        System.out.print("NAME" + Base.wordDistance("NAME", 15));
        System.out.print("SURNAME" + Base.wordDistance("SURNAME", 15));
        System.out.print("PL ID NUMBER" + Base.wordDistance("PL ID NUMBER", 15));
        System.out.print("DOC NUMBER" + Base.wordDistance("DOC NUMBER", 12));
        System.out.print("EMAIL" + Base.wordDistance("EMAIL", 35));
        System.out.print("POSTCODE" + Base.wordDistance("POSTCODE", 10));
        System.out.print("PHONE NUMBER" + Base.wordDistance("PHONE NUMBER", 15));
        System.out.print("IBAN" + Base.wordDistance("IBAN", 30));
//        System.out.print("BANK" + Base.wordDistance("BANK", 50));
        System.out.print("BIRTH DATE" + Base.wordDistance("BIRTH DATE", 20));
        System.out.println();

        for (int i = 0; i < 10; i++) {

            String name = plPerson.firstName();
            String surname = plPerson.lastName();
            long birthDate = dateAndTime.birthday(20, 75).getTime();
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
            System.out.print(email + Base.wordDistance(email, 35));
            System.out.print("00001" + Base.wordDistance("00001", 10));
            System.out.print(phone + Base.wordDistance(phone, 15));
            System.out.print(iban + Base.wordDistance(iban, 30));
//            System.out.print(bank + Base.wordDistance(bank, 50));
            System.out.println(dateFormat.format(birthDate) + Base.wordDistance(dateFormat.format(birthDate), 20));
        }
    }
}
