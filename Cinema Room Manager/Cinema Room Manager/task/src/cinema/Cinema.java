package cinema;
import java.util.Scanner;

public class Cinema {
    static boolean shouldWork = true;
    static int purchasedTickets = 0;
    static int currentIncome = 0;
    static int numberOfRows = 0;
    static int numberOfSeatsInRow = 0;

    public static void main(String[] args) {
        int[] ticketInfo = new int[2];
        System.out.println("Enter the number of rows:");
        Scanner scanner = new Scanner(System.in);
        numberOfRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        numberOfSeatsInRow = scanner.nextInt();
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
        while (shouldWork) {
            System.out.println("1. Show the seats\n" +
                    "2. Buy a ticket\n" +
                    "3. Statistics\n" +
                    "0. Exit");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    showSeats(array);
                    break;
                case 2:
                    ticketInfo = buyTicket(array);
                    break;
                case 3:
                    showStatistics(ticketInfo);
                    break;
                case 0:
                    shouldWork = false;
                    break;
                default:
                    System.out.println("Error. Please, try again");
            }
        }
    }

    private static void showSeats(char[][] array) {
        System.out.println("Cinema:");
        for(char[] a : array) {
            for(char i : a) {
                System.out.print(i + " ");
            }
            System.out.print("\n");
        }
    }

    public static int[] buyTicket(char[][] array) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a row number:");
        int pickedRow = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int pickedSeat = scanner.nextInt();
        int price = 0;
        try {
            if (array[pickedRow][pickedSeat] == 'B') {
                System.out.println("That ticket has already been purchased!");
                buyTicket(array);
            } else {
                if (numberOfRows * numberOfSeatsInRow > 60 && pickedRow > numberOfRows / 2) {
                    price = 8;
                } else {
                    price = 10;
                }
                currentIncome += price;
                purchasedTickets++;
                array[pickedRow][pickedSeat] = 'B';
                System.out.println("Ticket price: $" + price);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Wrong input!");
            buyTicket(array);
        }
        return new int[] {currentIncome, purchasedTickets};
    }

    private static void showStatistics(int[] ticketInfo) {
        int totalIncome = 0;
        if (numberOfRows * numberOfSeatsInRow > 60) {
            totalIncome = numberOfSeatsInRow * (numberOfRows / 2) * 10 +
                    (numberOfRows - numberOfRows / 2) * numberOfSeatsInRow * 8;
        } else {
            totalIncome = numberOfRows * numberOfSeatsInRow * 10;
        }
        float allSeats = numberOfRows * numberOfSeatsInRow;
        float  purchasedTickets = ticketInfo[1];
        float percentage = purchasedTickets / allSeats * 100;
        System.out.printf("Number of purchased tickets: %d\n", ticketInfo[1]);
        System.out.printf("Percentage: %.2f%%\n", percentage);
        //System.out.println("Percentage: " + percentage + "%");
        System.out.printf("Current income: $%d\n", ticketInfo[0]);
        System.out.printf("Total income: $%d\n", totalIncome);
        System.out.println("");
    }
}