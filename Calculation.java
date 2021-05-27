import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculation {

    public static String fromStringLine(String string){
        List<List<String>> toDo = whatToDo(string);
        String result = "";

        if (toDo == null){
            return "Incorrect  content";
        }
        for (List<String> strings : toDo) {
            List<String> listForCalculation = strings.stream().skip(1).collect(Collectors.toList());
            listForCalculation.add(0, result);
            listForCalculation.removeAll(Arrays.asList(null,""));
            try {
                switch (Verification.findOutCommands(strings.get(0))) {
                    case ADD:
                        result = String.valueOf(Calculator.add(listForCalculation));
                        break;
                    case MUL:
                        result = String.valueOf(Calculator.mul(listForCalculation));
                        break;
                    case SUB:
                        result = String.valueOf(Calculator.sub(listForCalculation));
                        break;
                    case DIV:
                        result = String.valueOf(Calculator.div(listForCalculation));
                        break;
                    default:
                        return "default 0";
                }
            } catch (NumberFormatException exception) {
                return "Number Format Exception";
            } catch (ArithmeticException exception){
                return "Warning! Division on zero!";
            }
        }
        return result;
    }

    private static List<List<String>> whatToDo(String string){
        String[] data = string.split("\\s+");

        List<List<String>> toDo = new ArrayList<>();
        List<String> listCommandsNumbers = null;

        for (int i = 0; i < data.length; i++){
            if (i == 0 && !Verification.isCommands(data[0])){
                return null;
            } else if (Verification.isCommands(data[i])){
                listCommandsNumbers = new ArrayList<>();
                listCommandsNumbers.add(data[i]);
                toDo.add(listCommandsNumbers);
            } else if (Verification.isNumbers(data[i])){
                listCommandsNumbers.add(data[i].trim().replace("\\D",""));
            } else {
                return null;
            }
        }
        if (toDo.get(0).size() < 3){
            return null;
        }
        for (int i = 1; i < toDo.size(); i++){
            if (toDo.get(i).size() < 2){
                return null;
            }
        }
        return toDo;
    }
}
