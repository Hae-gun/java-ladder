package ladder.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int inputInteger(String question) {
        System.out.println(question);
        return Integer.parseInt(scanner.nextLine());
    }

    public static String inputString(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
}