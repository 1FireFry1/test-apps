import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

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
                List<String> results = commandsAndValues.stream().map(Calculation::fromStringLine).
                        collect(Collectors.toList());

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
        for (;;){
            System.out.print(">");
            String data = scanner.nextLine().trim();
            if (data.equalsIgnoreCase("q")){
                break;
            }
            System.out.println(Calculation.fromStringLine(data));
        }
    }
}

