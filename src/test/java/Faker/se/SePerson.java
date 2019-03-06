package Faker.se;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.stream.Collectors;

public class SePerson extends Faker.Person {
    ClassLoader classLoader = getClass().getClassLoader();
    private static File jsonFile;
    private static int i;

    public SePerson() {
        jsonFile = new File(classLoader.getResource("se/seClearingNumber.json").getFile());
    }

    public static final String MALE_NAMES = "src/test/resources/se/seMaleNames.json";
    public static final String FEMALE_NAMES = "src/test/resources/se/seFemaleNames.json";
    public static final String LAST_NAMES = "src/test/resources/se/seLastNames.json";
    public static final String JSON = "src/test/resources/se/seClearingNumber.json";


    private static final String[] genderMale = {"1", "3", "5", "7", "9"};
    private static final String[] genderFemale = {"0", "2", "4", "6", "8"};

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

    public static String lastName() {
        return lastName(LAST_NAMES);
    }

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

    public static int computeCheckDigit(String partialNumber) {
        int checkDigit = checksum(partialNumber + "0");
        if (checkDigit == 0) {
            return 0;
        }

        return (10 - checkDigit);
    }

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

    public static RangeList getClearingAccountNumber() throws IOException {
        File resource = new File(JSON);
        BufferedReader reader = new BufferedReader(new FileReader(resource));
        String jsonToParse = reader.lines().collect(Collectors.joining());
        ObjectMapper mapper = new ObjectMapper();
        RangeList ranges = mapper.readValue(jsonToParse, RangeList.class);
        return ranges;
    }

    public static Integer clearingNumber() throws IOException {
        i = numberBetween(1, getClearingAccountNumber().getRangeList().size());
        int min = getClearingAccountNumber().getRangeList().get(i).getMin();
        int max = getClearingAccountNumber().getRangeList().get(i).getMax();
        return numberBetween(min, max);
    }

    public static Integer bankAccountNumber() throws IOException {
        int bankAccountNumber = getClearingAccountNumber().getRangeList().get(i).getNumbersToGenerate();
        return randomNumber(bankAccountNumber, true);
    }
}
