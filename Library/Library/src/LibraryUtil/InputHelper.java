package LibraryUtil;
import java.util.Scanner;

public class InputHelper {
    private static final Scanner sc = new Scanner(System.in);

    private InputHelper(){

    }

    public static int readInt(String prompt, int i, int i1) {
        while (true) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                int value = sc.nextInt();
                sc.nextLine(); // съедаем перевод строки
                return value;
            } else {
                System.out.println("Ошибка: введите целое число.");
                sc.nextLine(); // очищаем буфер от мусора
            }
        }
    }

    public static String readString(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }
}
