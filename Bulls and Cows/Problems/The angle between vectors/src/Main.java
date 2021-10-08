import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();

        double dotProduct = x1 * x2 + y1 * y2;
        double lengthA = Math.sqrt(Math.pow(x1, 2) + Math.pow(y1, 2));
        double lengthB = Math.sqrt(Math.pow(x2, 2) + Math.pow(y2, 2));
        double angleInRadians = Math.acos(dotProduct / (lengthA * lengthB));
        double angleInDegrees = Math.toDegrees(angleInRadians);
        System.out.println(angleInDegrees);
    }
}