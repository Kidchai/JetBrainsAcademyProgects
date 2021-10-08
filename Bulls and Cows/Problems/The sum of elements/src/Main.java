import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int a;
        do {
            a = scanner.nextInt();
            sum += a;
        } while (a != 0);
        System.out.println(sum);
    }
}