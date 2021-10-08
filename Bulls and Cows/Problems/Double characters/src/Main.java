import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String output = "";
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            output += ch;
            output += ch;
        }
        System.out.println(output);
    }
}