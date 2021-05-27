import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner;

    public static void main(String[] args) {

        if (!(args.length == 2)){
            System.out.println("Wrong input data, try restart the app.");
        } else {
            try {
                switch (Verification.findOutOperatingMode(args)) {
                    case CONSOLE:
                        workWithConsole();
                        break;
                    case FILE:
                        workWithFiles(args[0], args[1]);
                        break;
                    default:
                        System.out.println("Wrong input data, try restart the app.");
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void workWithFiles(String srcStringFile, String dstStringFile) {
            try {
                List<String> commandsAndValues = Files.readAllLines(Paths.get(srcStringFile));
                List<String> results = new ArrayList<>();
                String resultOFCalculation;
                for (String commandsAndValue : commandsAndValues) {
                    resultOFCalculation = Calculation.fromStringLine(commandsAndValue);
                    results.add(resultOFCalculation);
                }

                FileWriter writer = new FileWriter(dstStringFile);
                for(String result: results) {
                    writer.write(result + System.lineSeparator());
                }
                writer.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
    }

    private static void workWithConsole() {
        scanner = new Scanner(System.in);
        for (;;){
            System.out.print("->");
            String data = scanner.nextLine().trim();
            if (data.equalsIgnoreCase("q")){
                break;
            }
            System.out.println(Calculation.fromStringLine(data));
        }
    }
}

