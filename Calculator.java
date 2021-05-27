import java.util.List;

public class Calculator {
    public static int add(List<String> listForCalculation) throws NumberFormatException{
        return listForCalculation.stream().mapToInt(Integer::parseInt).sum();
    }

    public static int mul(List<String> listForCalculation) throws NumberFormatException{
        return listForCalculation.stream().mapToInt(Integer::parseInt).reduce((i1, i2) -> i1 * i2).orElse(0);
    }

    public static int sub(List<String> listForCalculation) throws NumberFormatException{
        return listForCalculation.stream().mapToInt(Integer::parseInt).reduce((i1, i2) -> i1 - i2).orElse(0);
    }

    public static int div(List<String> listForCalculation) throws NumberFormatException, ArithmeticException{
        return listForCalculation.stream().mapToInt(Integer::parseInt).reduce((i1, i2) -> i1 / i2).orElse(0);

    }
}
