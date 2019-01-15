package Faker.se;

import java.text.SimpleDateFormat;

public class sePerson extends Faker.Person {

    public static final String MALE_NAMES = "src/test/resources/se/seMaleNames.json";
    public static final String FEMALE_NAMES = "src/test/resources/se/seFemaleNames.json";
    public static final String LAST_NAMES = "src/test/resources/se/seLastNames.json";

    private static final String[] genderMale = {"1", "3", "5", "7", "9"};
    private static final String[] genderFemale = {"0", "2", "4", "6", "8"};

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
     * National Personal Identity number (personnummer)
     *
     * @param \DateTime $birthdate
     * @param |string   $gender Person::GENDER_MALE || Person::GENDER_FEMALE
     * @return string on format XXXXXX-XXXX
     * @link http://en.wikipedia.org/wiki/Personal_identity_number_(Sweden)
     */
    public static String personalIdentityNumber(long localDate, String sex) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
        String datePart = dateFormat.format(localDate);
        String randomDigits;

        if (sex.equals("M")) {
            randomDigits = randomNumber(2, true) + randomElement(genderMale);
        } else if (sex.equals("W")) {
            randomDigits = randomNumber(2, true) + randomElement(genderFemale);
        } else {
            randomDigits = String.valueOf(randomNumber(3, true));
        }

        int checksum = computeCheckDigit(datePart + randomDigits);

        return datePart + "-" + randomDigits + checksum;
    }

    /**
     * @param |partialNumber
     * @return string
     */
    public static int computeCheckDigit(String partialNumber) {
        int checkDigit = checksum(partialNumber + "0");
        if (checkDigit == 0) {
            return 0;
        }

        return (10 - checkDigit);
    }

    /**
     * @param |string $number
     *                Utility class for generating and validating Luhn numbers.
     *                Luhn algorithm is used to validate credit card numbers, IMEI numbers, and
     *                National Provider Identifier numbers.
     * @return int
     * @see |http://en.wikipedia.org/wiki/Luhn_algorithm
     */
    public static int checksum(String ccNumber) {
        int sum = 0;
        boolean alternate = false;
        for (int i = ccNumber.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(ccNumber.substring(i, i + 1));
            if (alternate) {
                n *= 2;
                if (n > 9) {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            alternate = !alternate;
        }
        return (sum % 10);
    }

    public static String phone() {
        String number = "2" + randomNumber(8, true);
        return number;
    }
}
