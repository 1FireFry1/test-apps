import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        if (args.length == 2) {
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
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private static void workWithFiles(String srcStringFile, String dstStringFile) {
            try {
                Calculation.fromFile(srcStringFile, dstStringFile);
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
