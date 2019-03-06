package Faker.vi;

import java.util.Random;

public class ViPerson extends Faker.Person {

    public static final String MALE_NAMES = "src/test/resources/vi/viMaleNames.json";
    public static final String FEMALE_NAMES = "src/test/resources/vi/viFemaleNames.json";
    public static final String MIDDLE_NAMES = "src/test/resources/vi/viLastNames.json";
    public static final String LAST_NAMES = "src/test/resources/vi/viMiddleNames.json";
    public Random random = new Random();

    public static String firstName() {

        String gender = randomElement(titleFormat);
        String firstName;
        String id;

        if (gender.equals("male")) {
            firstName = firstName(MALE_NAMES);
        } else {
            firstName = firstName(FEMALE_NAMES);
        }
        return firstName;
    }

    public static String lastName() {
        return lastName(LAST_NAMES);
    }

    public static String middleName() {
        return middleName(MIDDLE_NAMES);
    }

    public static String phone() {
        int[] numbers = new int[]{1, 9};
        Random random = new Random();
        int num = numbers[random.nextInt(numbers.length)];

        if (num == 1) {
            String number = "840" + num + randomNumber(9, true);
            return number;
        } else {
            String number = "840" + num + randomNumber(8, true);
            return number;
        }
    }

    public static String randomIbanVietnam() {
        String partOne = String.valueOf(randomNumber(7, true));
        String partTwo = String.valueOf(randomNumber(6, true));
        String partThree = String.valueOf(randomNumber(6, true));
        String iban = partOne + partTwo + partThree;
        return iban;
    }

    public static String getId(String gen, int birthDate) {
        String id = null;

        if (gen == "M") {
            if (birthDate <= 1990) {
                id = String.valueOf(randomNumber(9, true));
            } else if (birthDate >= 2000) {
                id = randomNumber(3, true) + "2" + randomNumber(8, true);
            } else {
                id = randomNumber(3, true) + "0" + randomNumber(8, true);
            }
        }

        if (gen == "W") {
            if (birthDate <= 1990) {
                id = String.valueOf(randomNumber(9, true));
            } else if (birthDate >= 2000) {
                id = randomNumber(3, true) + "3" + randomNumber(8, true);
            } else {
                id = randomNumber(3, true) + "1" + randomNumber(8, true);
            }
        }
        return id;
    }
}
