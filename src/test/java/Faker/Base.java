package Faker;

import java.lang.reflect.Array;
import java.util.*;

import static java.lang.Math.*;

public class Base {

    public static int mt_rand(int low, int high) {
        Random random = new Random();
        int result = random.nextInt(high - low) + low;
        return result;
    }

    public static int randomDigit() {
        return mt_rand(0, 9);
    }

    public static int randomDigitNotNull() {
        return mt_rand(1, 9);
    }

    public static int randomNumber(int nbDigits, boolean strict) {
        if (!strict) {
            try {
                throw new Exception("randomNumber() generates numbers of fixed width. " +
                        "To generate numbers between two boundaries, use numberBetween() instead.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (nbDigits == 0) {
            nbDigits = randomDigitNotNull();
        }
        int max = (int) pow(10, nbDigits) - 1;
        if (strict) {
            return mt_rand((int) pow(10, nbDigits - 1), max);
        }

        return mt_rand(0, max);
    }

    public static int numberBetween(int int1, int int2) {
        int min = int1 < int2 ? int1 : int2;
        int max = int1 < int2 ? int2 : int1;
        return mt_rand(min, max);
    }

    public static String[] randomElements(String[] array, int count, boolean allowDuplicates) {

        int numKeys = Array.getLength(array);

        String[] elements;
        if (!allowDuplicates && numKeys < count) {
            throw new IllegalArgumentException("Cannot get %d elements, only %d in array");
        } else {
            int highKey = numKeys - count;
            int num = mt_rand(0, highKey + 1);
            elements = Arrays.copyOfRange(array, num, num + count);
        }
        return elements;
    }

    public static char[] randomElementsChar(char[] array, int count, boolean allowDuplicates) {

        int numKeys = Array.getLength(array);

        char[] elements;
        if (!allowDuplicates && numKeys < count) {
            throw new IllegalArgumentException("Cannot get %d elements, only %d in array");
        } else {
            int highKey = numKeys - count;
            int num = mt_rand(0, highKey + 1);
            elements = Arrays.copyOfRange(array, num, num + count);
        }
        return elements;
    }

    public static String randomElement(String[] array) {
        String[] elements = randomElements(array, 1, true);
        return elements[0];
    }

    public static char randomElementChar(char[] array) {
        char[] elements = randomElementsChar(array, 1, true);
        return elements[0];
    }

    public static String concatenateDigits(int... digits) {
        StringBuilder sb = new StringBuilder(digits.length);
        for (int digit : digits) {
            sb.append(digit);
        }
        return sb.toString();
    }

    public static String wordDistance(String word, int length) {
        String nameSpace = "";
        if (word.length() > length) {
            length = Integer.parseInt(word + "  ");
        }
        for (int i = length - word.length(); i >= 0; i--) {
            nameSpace = nameSpace + " ";
        }
        return nameSpace;
    }
}
