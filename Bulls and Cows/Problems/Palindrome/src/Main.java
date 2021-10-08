import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder reverseInput = new StringBuilder(input).reverse();
        System.out.println(input.equals(reverseInput.toString()) ? "yes" : "no");
    }
}