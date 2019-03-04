package tests;

import Faker.Base;
import Faker.DateTime;
import Faker.Payment;
import Faker.BaseInternet;
import Faker.kz.kzPerson;
import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;

import static Faker.Base.randomElement;
import static Faker.kz.kzPerson.individualIdentificationNumber;
import static Faker.kz.kzPerson.phone;

public class KzPersonTest {
    private static Faker faker = new Faker();

    public static void main(String[] args) {

        BaseInternet baseInternet = new BaseInternet(faker);
        DateTime dateAndTime = new DateTime(faker);
        Payment payment = new Payment(faker);

        SimpleDateFormat dateFormat;
        dateFormat = new SimpleDateFormat("dd.MM.yy");
        String[] gender = {"M", "W"};

        System.out.print("KZ IIN" + Base.wordDistance("KZ IIN", 15));
        System.out.print("PHONE NUMBER" + Base.wordDistance("PHONE NUMBER", 12));
        System.out.print("EMAIL" + Base.wordDistance("EMAIL", 30));
        System.out.print("NAME" + Base.wordDistance("NAME", 13));
        System.out.print("SURNAME" + Base.wordDistance("SURNAME", 13));
        System.out.print("BIRTH DATE" + Base.wordDistance("BIRTH DATE", 10));
        System.out.print("GEN" + Base.wordDistance("GENDER", 7));
        System.out.print("PASSPORT" + Base.wordDistance("PASSPORT", 10));
        System.out.print("ID NUMBER" + Base.wordDistance("ID NUMBER", 10));
        System.out.print("PERMIT NUMBER" + Base.wordDistance("PERMIT NUMBER", 14));
        System.out.println("IBAN" + Base.wordDistance("IBAN", 30));

        for (int i = 0; i < 10; i++) {

            String name = kzPerson.firstName();
            String surname = kzPerson.lastName();
            long birthDate = dateAndTime.birthday().getTime();

            String gen = randomElement(gender);
            String idNumber = individualIdentificationNumber(birthDate, gen);
//            String email = baseInternet.email(name, surname);
            String email = baseInternet.emailLatinLetters();
            String phone = phone();
            String iban = payment.ibanNumber("KZ");
            String birthday = dateFormat.format(birthDate);
            String fakePassportNumber = kzPerson.randomPassportNumberKz();
            String fakeIdNumber = kzPerson.randomIdNumberKz();
            String fakePermitNumber = kzPerson.randomPermitNumber();

            System.out.print(idNumber + Base.wordDistance(idNumber, 15));
            System.out.print(phone + Base.wordDistance(phone, 12));
            System.out.print(email + Base.wordDistance(email, 30));
            System.out.print(name + Base.wordDistance(name, 13));
            System.out.print(surname + Base.wordDistance(surname, 13));
            System.out.print(birthday + Base.wordDistance(birthday, 10));
            System.out.print(gen + Base.wordDistance(gen, 4));
            System.out.print(fakePassportNumber + Base.wordDistance(fakePassportNumber, 10));
            System.out.print(fakeIdNumber + Base.wordDistance(fakeIdNumber, 10));
            System.out.print(fakePermitNumber + Base.wordDistance(fakePermitNumber, 14));
            System.out.println(iban + Base.wordDistance(iban, 30));
        }
    }
}
