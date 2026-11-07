import java.util.Scanner;

public class otvet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        int result;
        if(a >=h) {
            result = 1;
        } else if (a <= b) {
            result = -1;
        } else {
            result = (h - a + (a - b) - 1) / (a - b) + 1;
        }

        System.out.print(result);
    }
}




























