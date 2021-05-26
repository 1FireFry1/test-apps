
public class Calculation {

    public static String fromStringLine(String string){
        String[] data = string.split("\\s+");
        String[] stringsNumbers = new String[data.length - 1];
        System.arraycopy(data, 1, stringsNumbers, 0, stringsNumbers.length);

        try {
            switch (Verification.findOutCommands(data[0])) {
                case ADD:

                    return String.valueOf(Calculator.add(stringsNumbers));
                case MUL:
                    return String.valueOf(Calculator.mul(stringsNumbers));
                case MUL_TWO_ADD_THIRD:
                    return String.valueOf(Calculator.mulTwoAddThird(stringsNumbers[0], stringsNumbers[1], stringsNumbers[2]));
                case NOT_MATCH_ANY_COMMAND:
                    return "Wrong command";
                default:
                    return "0";
            }
        }catch (NumberFormatException exception){
            return "Number Format Exception";
        }
    }
}
