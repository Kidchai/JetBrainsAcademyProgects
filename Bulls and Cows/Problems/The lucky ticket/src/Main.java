import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        char[] charsFromString = input.toCharArray();
        int a = Character.getNumericValue(charsFromString[0]);
        int b = Character.getNumericValue(charsFromString[1]);
        int c = Character.getNumericValue(charsFromString[2]);
        int d = Character.getNumericValue(charsFromString[3]);
        int e = Character.getNumericValue(charsFromString[4]);
        int f = Character.getNumericValue(charsFromString[5]);
        if (a + b + c == d + e + f) {
            System.out.println("Lucky");
        } else {
            System.out.println("Regular");
        }
    }
}