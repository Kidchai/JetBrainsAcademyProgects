package cinema;
import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        System.out.println("Enter the number of rows:");
        Scanner scanner = new Scanner(System.in);
        int numberOfRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int numberOfSeatsInRow = scanner.nextInt();
        char[][] array = new char[numberOfRows + 1][numberOfSeatsInRow + 1];
        int REDIX = 10;
        for(int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == 0 && j == 0) {
                    array[i][j] = ' ';
                } else if (i == 0) {
                    array[i][j] = Character.forDigit(j, REDIX);
                } else if (j == 0) {
                    array[i][j] = Character.forDigit(i, REDIX);
                } else {
                    array[i][j] = 'S';
                }
            }
        }
        System.out.println("Cinema:");
        for(char[] a : array) {
            for(char i : a) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
        System.out.println("Enter a row number:");
        int pickedRow = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int pickedSeat = scanner.nextInt();
        int price = 0;
        if (numberOfRows * numberOfSeatsInRow > 60 && pickedRow > numberOfRows / 2) {
            price = 8;
        } else {
            price = 10;
        }
        array[pickedRow][pickedSeat] = 'B';
        System.out.println("Ticket price: $" + price);
        System.out.println("Cinema:");
        for(char[] a : array) {
            for(char i : a) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }
}