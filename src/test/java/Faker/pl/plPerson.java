package Faker.pl;

import java.text.SimpleDateFormat;

public class plPerson extends Faker.Person {

    public static final String MALE_NAMES = "src/test/resources/pl/plMaleNames.json";
    public static final String FEMALE_NAMES = "src/test/resources/pl/plFemaleNames.json";
    public static final String LAST_NAME_MALE = "src/test/resources/pl/plLastNameMale.json";
    public static final String LAST_NAME_FEMALE = "src/test/resources/pl/plLastNameFemale.json";

    public static String firstName() {

        String gender = randomElement(titleFormat);
        String firstName;

        if (gender.equals("male")) {
            String Path = MALE_NAMES;
            firstName = firstName(Path);
        } else {
            String Path = FEMALE_NAMES;
            firstName = firstName(Path);
        }
        return firstName;
    }

    public static String lastName() {

        String gender = randomElement(titleFormat);
        String firstName;

        if (gender.equals("male")) {
            String Path = LAST_NAME_MALE;
            firstName = firstName(Path);
        } else {
            String Path = LAST_NAME_FEMALE;
            firstName = firstName(Path);
        }
        return firstName;
    }

    public static String pesel(long localDate, String sex) {

        int[] weights = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};
        int length = weights.length;
        int gender = 0;
        String month;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
        SimpleDateFormat yearFormat = new SimpleDateFormat("yy");
        SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd");

        int partTwo = numberBetween(111, 999);

        if (sex.equals("M")) {
            gender = 1;
        }

        int fullYear = Integer.parseInt(dateFormat.format(localDate));

        if ((((fullYear / 100) - 14) % 5) * 20 != 0) {
            month = String.valueOf(Integer.parseInt(monthFormat.format(localDate)) + (((fullYear / 100) - 14) % 5) * 20);
        } else {
            month = monthFormat.format(localDate);
        }

        String year = yearFormat.format(localDate);
        String day = dayFormat.format(localDate);

        String datePart = year + month + day;
        String secondPart = datePart + partTwo + gender;

        String[] integerStrings = secondPart.split("");
        int[] integers = new int[integerStrings.length];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = Integer.parseInt(integerStrings[i]);
        }

        int checksum = 0;
        for (int i = 0; i < length; i++) {
            checksum += weights[i] * integers[i];
        }
        checksum = (10 - (checksum % 10)) % 10;

        return datePart + partTwo + gender + checksum;
    }

    public static String personalIdentityNumber() {
        // IF ID Card contains “O”, “Q”, “AA”, “AB”, “AC”, “AD”
        char[] range = {'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'P', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        char[] low = {'A', randomElementChar(range), randomElementChar(range)};
        StringBuilder first = new StringBuilder();
        StringBuilder last = new StringBuilder();
        int[] high = {randomDigit(), randomDigit(), randomDigit(), randomDigit(), randomDigit()};
        int[] weights = {7, 3, 1, 7, 3, 1, 7, 3};
        int checksum = 0;
        for (int i = 0; i < low.length; i++) {
            checksum += weights[i] * (CharToASCII(low[i]) - 55);
            first.append(low[i]);
        }
        for (int i = 0; i < high.length; i++) {
            checksum += weights[i + 3] * high[i];
            last.append(high[i]);
        }
        checksum %= 10;
        return first.toString() + checksum + last;
    }

    public static int CharToASCII(final char character) {
        return (int) character;
    }

    public static String phone() {
        String number = "79" + randomNumber(9, true);
        return number;
    }
}
