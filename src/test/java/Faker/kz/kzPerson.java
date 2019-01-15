package Faker.kz;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class kzPerson extends Faker.Person {

    public static final String MALE_NAMES = "src/test/resources/kz/kzMaleNames.json";
    public static final String FEMALE_NAMES = "src/test/resources/kz/kzFemaleNames.json";
    public static final String LAST_NAMES = "src/test/resources/kz/kzLastNames.json";

    public static final int GENDER_MALE = 0;
    public static final int GENDER_FEMALE = 1;

    private static final int CENTURY_19TH = 0;
    private static final int CENTURY_20TH = 1;
    private static final int CENTURY_21ST = 2;

    private static final int MALE_CENTURY_19TH = 1;
    private static final int MALE_CENTURY_20TH = 3;
    private static final int MALE_CENTURY_21ST = 5;

    private static final int FEMALE_CENTURY_19TH = 2;
    private static final int FEMALE_CENTURY_20TH = 4;
    private static final int FEMALE_CENTURY_21ST = 6;

    /**
     * @var array
     */
    private static final int[] firstSequenceBitWeights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

    /**
     * @var array
     */
    private static final int[] secondSequenceBitWeights = {3, 4, 5, 6, 7, 8, 9, 10, 11, 1, 2};

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
        return lastName(LAST_NAMES);
    }

    /**
     * National Individual Identification Numbers
     *
     * @param \DateTime $birthDate
     * @param |integer  $gender
     * @param localDate
     * @return string 12 digits, like 780322300455
     * @link http://egov.kz/wps/portal/Content?contentPath=%2Fegovcontent%2Fcitizen_migration%2Fpassport_id_card%2Farticle%2Fiin_info&lang=en
     * @link https://ru.wikipedia.org/wiki/%D0%98%D0%BD%D0%B4%D0%B8%D0%B2%D0%B8%D0%B4%D1%83%D0%B0%D0%BB%D1%8C%D0%BD%D1%8B%D0%B9_%D0%B8%D0%B4%D0%B5%D0%BD%D1%82%D0%B8%D1%84%D0%B8%D0%BA%D0%B0%D1%86%D0%B8%D0%BE%D0%BD%D0%BD%D1%8B%D0%B9_%D0%BD%D0%BE%D0%BC%D0%B5%D1%80
     */
    public static String individualIdentificationNumber(long localDate, String sex) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
        SimpleDateFormat centryFormat = new SimpleDateFormat("y");
        int population = mt_rand(1000, 2000);
        int century = getCenturyByYear(Integer.parseInt(centryFormat.format(localDate)));
        String iin = dateFormat.format(localDate);
        iin += genderCenturyMap(sex, century);
        iin += population;
        return iin + checkSum(iin);
    }

    /**
     * @param |string $iinValue
     * @return integer
     */
    public static int checkSum(String iinValue) {
        String[] inn = iinValue.split("");
        int controlDigit = getControlDigit(inn, firstSequenceBitWeights);

        if (controlDigit == 10) {
            return getControlDigit(inn, secondSequenceBitWeights);
        }
        return controlDigit;
    }

    /**
     * @param |string  $iinValue
     * @param |array   $sequence
     * @param iinValue
     * @return integer
     */
    protected static int getControlDigit(String[] iinValue, int[] sequence) {
        int sum = 0;
        for (int i = 0; i <= 10; i++) {
            sum += Integer.parseInt(iinValue[i]) * sequence[i];
        }
        return sum % 11;
    }

    /**
     * @var array
     */
    public static int genderCenturyMap(String sex, int sentry) {

        int genderCentrMap = 0;
        if (sex.equals("M")) {
            if (sentry == CENTURY_19TH) {
                genderCentrMap = MALE_CENTURY_19TH;
            } else if (sentry == CENTURY_20TH) {
                genderCentrMap = MALE_CENTURY_20TH;
            } else if (sentry == CENTURY_21ST) {
                genderCentrMap = MALE_CENTURY_21ST;
            }
        } else if (sex.equals("W")) {
            if (sentry == CENTURY_19TH) {
                genderCentrMap = FEMALE_CENTURY_19TH;
            } else if (sentry == CENTURY_20TH) {
                genderCentrMap = FEMALE_CENTURY_20TH;
            } else if (sentry == CENTURY_21ST) {
                genderCentrMap = FEMALE_CENTURY_21ST;
            }
        }
        return genderCentrMap;
    }

    /**
     * @param |integer $year
     * @return integer|null
     */
    public static int getCenturyByYear(int year) {

        if (year >= 2000 && year <= Integer.parseInt(LocalDate.now().format(DateTimeFormatter.ofPattern("yy")))) {
            return CENTURY_21ST;
        } else if (year >= 1900) {
            return CENTURY_20TH;
        } else
            return CENTURY_19TH;
    }

    /**
     * @example '555-123-546'
     */
    public static String phone() {
        String number = "7701" + randomNumber(6, true);
        return number;
    }
}
