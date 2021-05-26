import java.util.Arrays;

public class Calculator {
    public static int add(String[] stringNumbers) throws NumberFormatException{
        return Arrays.asList(stringNumbers).stream().mapToInt(Integer::parseInt).sum();
    }

    public static int mul(String[] stringNumbers) throws NumberFormatException{
        return Arrays.asList(stringNumbers).stream().mapToInt(Integer::parseInt).reduce((i1, i2) -> i1 * i2).orElse(0);
    }

    public static int mulTwoAddThird(String firstNumber, String secondNumber, String thirdNumber) throws NumberFormatException{
        return Integer.parseInt(firstNumber) * Integer.parseInt(secondNumber) + Integer.parseInt(thirdNumber);
    }
}
