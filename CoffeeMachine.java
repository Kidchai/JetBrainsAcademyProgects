package machine;

import java.util.Scanner;

public class CoffeeMachine {
    int waterAmount;
    int milkAmount;
    int beansAmount;
    int cupsAmount;
    int moneyAmount;
    static boolean shouldWork = true;

    enum Options {
        BUY, FILL, TAKE, REMAINING, EXIT
    }

    public void showState() {
        System.out.println("The coffee machine has:");
        System.out.println(waterAmount + " of water");
        System.out.println(milkAmount + " of milk");
        System.out.println(beansAmount + " of coffee beans");
        System.out.println(cupsAmount + " of disposable cups");
        System.out.println("$" + moneyAmount + " of money");
    }

    public void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        Scanner scanner = new Scanner(System.in);
        String coffeeType = scanner.next();

        switch (coffeeType) {
            case "1": //espresso
                if (waterAmount >= 250 && beansAmount >= 16 && cupsAmount >= 1) {
                    System.out.println("I have enough resources, making you a coffee!");
                    this.waterAmount -= 250;
                    this.beansAmount -= 16;
                    this.cupsAmount--;
                    this.moneyAmount += 4;
                    break;
                } else if (waterAmount < 250) {
                    System.out.println("Sorry, not enough water!");
                    break;
                } else if (beansAmount < 16) {
                    System.out.println("Sorry, not enough coffee beans!");
                    break;
                } else {
                    System.out.println("Sorry, not enough disposable cups!");
                    break;
                }

            case "2": //latte
                if (waterAmount >= 350 && milkAmount >= 75 && beansAmount >= 20 && cupsAmount >= 1) {
                    System.out.println("I have enough resources, making you a coffee!");
                    this.waterAmount -= 350;
                    this.milkAmount -= 75;
                    this.beansAmount -= 20;
                    this.cupsAmount--;
                    this.moneyAmount += 7;
                    break;
                } else if (waterAmount < 350) {
                    System.out.println("Sorry, not enough water!");
                    break;
                } else if (milkAmount < 75) {
                    System.out.println("Sorry, not enough milk");
                    break;
                } else if (beansAmount < 20) {
                    System.out.println("Sorry, not enough coffee beans!");
                    break;
                } else {
                    System.out.println("Sorry, not enough disposable cups!");
                    break;
                }

            case "3": //cappuccino
                if (waterAmount >= 200 && milkAmount >= 100 && beansAmount >= 12 && cupsAmount >= 1) {
                    System.out.println("I have enough resources, making you a coffee!");
                    this.waterAmount -= 200;
                    this.milkAmount -= 100;
                    this.beansAmount -= 12;
                    this.cupsAmount--;
                    this.moneyAmount += 6;
                    break;
                } else if (waterAmount < 200) {
                    System.out.println("Sorry, not enough water!");
                    break;
                } else if (milkAmount < 100) {
                    System.out.println("Sorry, not enough milk");
                    break;
                } else if (beansAmount < 12) {
                    System.out.println("Sorry, not enough coffee beans!");
                    break;
                } else {
                    System.out.println("Sorry, not enough disposable cups!");
                    break;
                }
            default:
                break;
        }
    }

    public void fill() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water do you want to add:");
        int addWater = scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        int addMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        int addBeans = scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int addCups = scanner.nextInt();

        this.waterAmount += addWater;
        this.milkAmount += addMilk;
        this.beansAmount += addBeans;
        this.cupsAmount += addCups;
    }

    public void take() {
        System.out.println("I gave you $" + moneyAmount);
        this.moneyAmount = 0;
    }

    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine();
        {
            machine.waterAmount = 400;
            machine.milkAmount = 540;
            machine.beansAmount = 120;
            machine.cupsAmount = 9;
            machine.moneyAmount = 550;
        }
        while (shouldWork) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.next().toUpperCase();
            machine.defineAction(input);
        }
    }

    public void defineAction(String getOptions) {
        Options options = Options.valueOf(getOptions);

        switch (options) {
            case BUY:
                buy();
                break;
            case FILL:
                fill();
                break;
            case TAKE:
                take();
                break;
            case REMAINING:
                showState();
                break;
            case EXIT:
                shouldWork = false;
                break;
            default:
                System.out.println("Error. Please, try again");
        }
    }
}