package Faker.lv;

import java.text.SimpleDateFormat;

public class lvPerson extends Faker.Person {

    public static final String MALE_NAMES = "src/test/resources/lv/lvMaleNames.json";
    public static final String FEMALE_NAMES = "src/test/resources/lv/lvFemaleNames.json";
    public static final String LAST_NAMES = "src/test/resources/lv/lvLastNames.json";

    /**
     * @param |string|null $gender 'male', 'female' or null for any
     * @return string
     * @example 'John'
     */
    public static String firstName() {

        String gender = randomElement(titleFormat);
        String firstName;

        if (gender.equals("male")) {
            firstName = firstName(MALE_NAMES);
        } else {
            firstName = firstName(FEMALE_NAMES);
        }
        return firstName;
    }

    /**
     * @return string
     * @example 'Doe'
     */
    public static String lastName() {
        return lastName(LAST_NAMES);
    }

    /**
     * National Personal Identity number (personas kods)
     *
     * @param \DateTime $birthdate
     * @return string on format XXXXXX-XXXXX
     * @link https://en.wikipedia.org/wiki/National_identification_number#Latvia
     */
    public static String personalIdentityNumber(long localDate) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyy");
        int partTwo = Integer.parseInt(concatenateDigits(11, numberBetween(11, 99)));
        String secondPart = dateFormat.format(localDate) + partTwo;

        String[] integerStrings = secondPart.split("");
        int[] integers = new int[integerStrings.length];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = Integer.parseInt(integerStrings[i]);
        }

        int sum = 0;
        int[] weight = {10, 5, 8, 4, 2, 1, 6, 3, 7, 9};
        for (int i = 0; i < 10; i++) {
            sum += (integers[i]) * weight[i];
        }
        sum = (sum + 1) % 11 % 10;

        return dateFormat.format(localDate) + " " + partTwo + sum;
    }

    /**
     * @example '555-123-546'
     */
    public static String phone() {
        String number = "2" + randomNumber(8, true);
        return number;
    }
}
