package cinema;
import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        System.out.println("Enter the number of rows:");
        Scanner scanner = new Scanner(System.in);
        int numberOfRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int numberOfSeatsInRow = scanner.nextInt();
        int totalIncome = 0;
        if (numberOfRows * numberOfSeatsInRow <= 60) {
            totalIncome = numberOfRows * numberOfSeatsInRow * 10;
        } else {
            if (numberOfRows % 2 == 0) {
                int frontAndBackRows = numberOfRows / 2;
                totalIncome = (frontAndBackRows * numberOfSeatsInRow * 10) + (frontAndBackRows * numberOfSeatsInRow * 8);
            } else {
                int frontRows = numberOfRows / 2;
                int backRows = numberOfRows / 2 + 1;
                totalIncome = (frontRows * numberOfSeatsInRow * 10) + (backRows *numberOfSeatsInRow * 8);
            }
        }
        System.out.println("Total income:");
        System.out.println("$" + totalIncome);
    }
}