package tests;
import Faker.Base;
import Faker.DateTime;
import Faker.BaseInternet;
import Faker.vi.viPerson;
import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;

import static Faker.Base.*;


public class ViPersonTest {
    private static Faker faker = new Faker();

    public static void main(String[] args) {
        BaseInternet baseInternet = new BaseInternet(faker);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        DateTime dateAndTime = new DateTime(faker);
        String[] gender = {"M", "W"};

        System.out.print("NAME" + Base.wordDistance("NAME", 15));
        System.out.print("MIDDLE NAME" + Base.wordDistance("NAME", 15));
        System.out.print("SURNAME" + Base.wordDistance("SURNAME", 20));
        System.out.print("PHONE NUMBER" + Base.wordDistance("PHONE NUMBER", 15));
        System.out.print("IBAN" + Base.wordDistance("IBAN", 20));
        System.out.print("BIRTH DATE" + Base.wordDistance("BIRTH DATE", 15));
        System.out.print("GENDER" + Base.wordDistance("GENDER", 10));
        System.out.print("ID" + Base.wordDistance("ID", 20));
        System.out.println("EMAIL" + Base.wordDistance("EMAIL", 40));

        for (int i = 0; i < 10; i++) {
            String name = viPerson.firstName();
            String middleName = viPerson.middleName();
            String lastName = viPerson.lastName();
            String phone = viPerson.phone();
            String email = baseInternet.email(name, lastName);
            String gen = randomElement(gender);
            long birthDate = dateAndTime.birthday().getTime();
            String iban = viPerson.randomIbanVietnam();
            String birthday = dateFormat.format(birthDate);
            Integer year = Integer.valueOf(birthday.substring(6));
            String id = viPerson.getId(gen, year);

            System.out.print(name + Base.wordDistance(name,15));
            System.out.print(middleName + Base.wordDistance(middleName, 22));
            System.out.print(lastName + Base.wordDistance(lastName, 20));
            System.out.print(phone + Base.wordDistance(phone, 15));
            System.out.print(iban + Base.wordDistance(iban, 20));
            System.out.print(birthday + Base.wordDistance(birthday, 15));
            System.out.print(gen + Base.wordDistance(gen, 10));
            System.out.print(id + Base.wordDistance(id, 20));
            System.out.println(email);
        }
    }
}
