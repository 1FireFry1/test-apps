import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Verification {

    public static OperatingMode findOutOperatingMode(String[] args)  throws IOException {

        Pattern pattern = Pattern.compile("(.+\\.txt)");
        Matcher matcherForArg0 = pattern.matcher(args[0]);
        Matcher matcherForArg1 = pattern.matcher(args[1]);

        if (matcherForArg0.matches() && matcherForArg1.matches()){
            if (!Files.exists(Paths.get(args[0])) || !Files.exists(Paths.get(args[1]))){
                throw new IOException("Source file or destination file or both does not exists");
            }
            return OperatingMode.FILE;
        }
        if (args[0].equals("-") && args[1].equals("-")){
            return OperatingMode.CONSOLE;
        }
        return OperatingMode.NOT_MATCH_ANY_MODE;
    }

    public static Commands findOutCommands(String data) {
        Pattern pattern = Pattern.compile("(?<add>add)|(?<mul>mul)|(?<sub>sub)|(?<div>div)");
        Matcher matcher = pattern.matcher(data.toLowerCase());

        if (!matcher.matches()){
            return Commands.NOT_MATCH_ANY_COMMAND;
        }

        if (!(matcher.group("add") == null)){
            return Commands.ADD;
        }
        if (!(matcher.group("mul") == null)){
            return Commands.MUL;
        }
        if (!(matcher.group("sub") == null)){
            return Commands.SUB;
        }
        return Commands.DIV;
    }

    public static boolean isCommands(String string) {
        Pattern pattern = Pattern.compile("(add)|(mul)|(sub)|(div)");
        Matcher matcher = pattern.matcher(string.toLowerCase().trim());
        return matcher.matches();
    }

    public static boolean isNumbers(String string) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(string.toLowerCase());
        return matcher.matches();
    }
}
