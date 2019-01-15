package Faker;

import java.lang.reflect.Array;
import java.util.*;
import static java.lang.Math.*;

public class Base {

    /**
     * Returns a random number between 0 and 9
     *
     * @return integer
     */
    public static int mt_rand(int low, int high){
        Random random = new Random();
        int result = random.nextInt(high - low) + low;
        return result;
    }

    /**
     * Returns a random number between 0 and 9
     * @return integer
     */
    public static int randomDigit()
    {
        return mt_rand(0, 9);
    }

    /**
     * Returns a random number between 1 and 9
     * @return integer
     */
    public static int randomDigitNotNull()
    {
        return mt_rand(1, 9);
    }

    /**
     * Generates a random digit, which cannot be except
     * @param except  except
     * @return int
     */
    public static int randomDigitNot(int except)
    {
        int result = numberBetween(0, 8);
        if (result >= except) {
            result++;
        }
        return result;
    }

    /**
     * Returns a random integer with 0 to $nbDigits digits.
     *
     * The maximum value returned is mt_getrandmax()
     *
     * @param nbDigits Defaults to a random number between 1 and 9
     * @param strict   Whether the returned number should have exactly $nbDigits
     * @example 79907610
     *
     * @return integer
     */
    public static int randomNumber(int nbDigits, boolean strict)
    {
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

    /**
     * Show largest possible random value
     * @return integer
     */
    public static int mt_getrandmax()
    {
        int min = 0;
        int max = 2147483640;
        return mt_rand(min, max);
    }

    /**
     * Return a random float number
     *
     * @param nbMaxDecimals
     * @param |float $min
     * @param |float $max
     * @example 48.8932
     * @return float
     */
    public static float randomFloat(int nbMaxDecimals, int min, int max)
    {
        Random random = new Random();
        if (nbMaxDecimals == 0) {
            nbMaxDecimals = randomDigit();
        }

        if (max == 0) {
            max = randomNumber(0, false);
            if (min > max) {
                max = min;
            }
        }

        if (min > max) {
            int tmp = min;
            min = max;
            max = tmp;
        }
        double scale = Math.pow(10, nbMaxDecimals);
        float generatedFloat = min + new Random().nextFloat() * (max - min);

        return (float) (Math.round(generatedFloat * scale) / scale);
    }

    /**
     * Returns a random number between $int1 and $int2 (any order)
     *
     * @param |int1 default to 0
     * @param |int2 defaults to 32 bit max integer, ie 2147483647
     * @example 79907610
     * @return integer
     */
    public static int numberBetween(int int1, int int2)
    {
        int min = int1 < int2 ? int1 : int2;
        int max = int1 < int2 ? int2 : int1;
        return mt_rand(min, max);
    }

    /**
     * Returns a random letter from a to z
     * @return string
     */
    public static char randomLetter()
    {
        return (char) (mt_rand(97, 122));
    }

    /**
     * Returns a random ASCII character (excluding accents and special chars)
     */
    public static char randomAscii()
    {
        return (char) (mt_rand(33, 126));
    }

    /**
     * Returns randomly ordered subsequence of $count elements from a provided array
     *
     * @param  |array            $array           Array to take elements from. Defaults to a-f
     * @param  |integer          $count           Number of elements to take.
     * @param  |boolean          $allowDuplicates Allow elements to be picked several times. Defaults to false
     * @throws \LengthException When requesting more elements than provided
     *
     * @return array New array with $count elements from $array
     */
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

    /**
     * Returns randomly ordered subsequence of $count elements from a provided array
     *
     * @param  |array            $array           Array to take elements from. Defaults to a-f
     * @param  |integer          $count           Number of elements to take.
     * @param  |boolean          $allowDuplicates Allow elements to be picked several times. Defaults to false
     * @throws \LengthException When requesting more elements than provided
     *
     * @return array New array with $count elements from $array
     */
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
    /**
     * Returns a random element from a passed array
     * @param  |array $array
     * @return mixed
     */
    public static String randomElement(String[] array)
    {
        String[] elements = randomElements(array, 1, true);
        return elements[0];
    }

    /**
     * Returns a random element from a passed char array
     * @param  |array $array
     * @return mixed
     */
    public static char randomElementChar(char[] array)
    {
        char[] elements = randomElementsChar(array, 1, true);
        return elements[0];
    }

    /**
     * Returns string, which become from givet integers
     * @param  |array of integers
     * @return String
     */
    public static String concatenateDigits(int... digits) {
        StringBuilder sb = new StringBuilder(digits.length);
        for (int digit : digits) {
            sb.append(digit);
        }
        return sb.toString();
    }

    /**
     * Return spaces of different length.
     *
     * This function need to client generator output
     * It make dynamic distance between words.
     *
     * @param |String some word | int length of field
     * @return array The shuffled set
     */

    public static String wordDistance(String word, int length) {
        String nameSpace = "";
        if(word.length() > length){
            length = Integer.parseInt(word + "  ");
        }
        for (int i = length - word.length(); i >= 0; i--) {
            nameSpace = nameSpace + " ";
        }
        return nameSpace;
    }


    /**
     * Returns a shuffled version of the array.
     *
     * This function does not mutate the original array. It uses the
     * Fisher–Yates algorithm, which is unbiased, together with a Mersenne
     * twister random generator. This function is therefore more random than
     * PHP's shuffle() function, and it is seedable.
     *
     * @link http://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle
     *
     * @example $faker->shuffleArray([1, 2, 3]); // [2, 1, 3]
     *
     * @param |array $array The set to shuffle
     * @return array The shuffled set
     */
    public static  int[] shuffleArray(int[] original)
    {
        int originalLength = original.length;
        Random random = new Random();
        int[] result = new int[originalLength];

        for (int i = 0; i < originalLength; i++) {
            int j = random.nextInt(i+1);
            result[i] = result[j];
            result[j] = original[i];
        }
        return result;
    }

    /**
     * Returns a shuffled version of the string.
     *
     * This function does not mutate the original string. It uses the
     * Fisher–Yates algorithm, which is unbiased, together with a Mersenne
     * twister random generator. This function is therefore more random than
     * PHP's shuffle() function, and it is seedable. Additionally, it is
     * UTF8 safe if the mb extension is available.
     *
     * @link http://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle
     *
     * @example $faker->shuffleString('hello, world'); // 'rlo,h eold!lw'
     *
     * @param |string $string The set to shuffle
     * @param |string $encoding The string encoding (defaults to UTF-8)
     * @return string The shuffled set
     */
    public static String shuffleString(String string)
    {
        List<String> letters = Arrays.asList(string.split(""));
        Collections.shuffle(letters);
        String shuffled = "";
        for (String letter : letters) {
            shuffled += letter;
        }
        return shuffled;
    }

    /**
     * Returns a random key from a passed associative array
     *
     * @param  |array $array
     * @return int|string|null
     */
    public static String randomKey(String[] array)
    {
        if (array == null) {
            return null;
        }
        String key = array[mt_rand(0, array.length - 1)];

        return key;
    }
}
