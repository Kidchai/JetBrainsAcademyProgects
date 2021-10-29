package bullscows;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Please, enter the secret code's length:");
        var scanner = new Scanner(System.in);
        var checkCodeLength = scanner.nextLine();
        int codeLength;
        try { codeLength = Integer.parseInt(checkCodeLength); }
        catch (Exception e) {
            System.out.println("Error: " + "\"" + checkCodeLength + "\"" + " isn't a valid number.");
            return;
        }
        if (codeLength <= 0) {
            System.out.println("Error: it's not possible to generate a code with a length of " + codeLength + " symbols.");
            return;
        }
        System.out.println("Input the number of possible symbols in the code:");
        var checkNumberOfSymbols = scanner.nextLine();
        int numbersOfSymbols;
        try { numbersOfSymbols = Integer.parseInt(checkNumberOfSymbols); }
        catch (Exception e) {
            System.out.println("Error: " + "\"" + checkNumberOfSymbols + "\"" + " isn't a valid number.");
            return;
        }
        if (numbersOfSymbols < codeLength) {
            System.out.println("Error: it's not possible to generate a code with a length of " + codeLength +
                    " with " + numbersOfSymbols + " unique symbols.");
            return;
        }
        var secretCode = generateRandomCode(codeLength, numbersOfSymbols);
        System.out.println(infoOfCode(codeLength, numbersOfSymbols));
        System.out.println("Okay, let's start a game!");
        checkAnswer(codeLength, secretCode);
    }

    static String infoOfCode(int codeLength, int numbersOfSymbols) {
        String star = "";
        do {
            star += "*";
        } while (star.length() < codeLength);
        String chars = "0123456789abcdefghijklmnopqrstuvwxyz";
        var lastNumber = (numbersOfSymbols >= 10) ? 9 : numbersOfSymbols - 1;
        var firstChar = (numbersOfSymbols >= 11) ? 'a' : null;
        var lastChar = (numbersOfSymbols >= 11) ? chars.charAt(numbersOfSymbols - 1) : null;

        if(firstChar != null) {
            return "The secret is prepared: " + star + " (" + 0 + "-" + lastNumber + ", " + firstChar + "-" + lastChar + ").";
        } else {
            return "The secret is prepared: " + star + " (" + 0 + "-" + lastNumber + ", " + firstChar + ").";
        }
    }

    static void checkAnswer(int codeLength, String code) {
        char[] charsCode = code.toCharArray();
        var isAnswerRight = false;

        var bulls = 0;
        var cows = 0;
        var y = 1;

        while (!isAnswerRight) {
            System.out.println("Turn " + y + ":");
            var scanner = new Scanner(System.in);
            var guess = scanner.next().toCharArray();
            for (var i = 0; i < codeLength; i++) {
                if (charsCode[i] == guess[i]) {
                    bulls++;
                }
                if (new String(charsCode).indexOf(guess[i]) != -1 && charsCode[i] != guess[i]) {
                    cows++;
                }
            }
            showGrade(bulls, cows, codeLength);
            if (bulls == codeLength) {
                isAnswerRight = true;
            }
            bulls = 0;
            cows = 0;
            y++;
        }
    }

    static void showGrade(int bulls, int cows, int codeLength) {
        var bull_s = (bulls > 1) ? " bulls" : " bull";
        var cow_s = (cows > 1) ? " cows" : " cow";

        if (bulls != 0 && cows != 0) {
            System.out.println("Grade: " + bulls + bull_s + " and " + cows + cow_s);
        } else if (bulls != 0 && bulls < codeLength && cows == 0) {
            System.out.println("Grade: " + bulls + bull_s);
        } else if (bulls == 0 && cows != 0) {
            System.out.println("Grade: " + cows + cow_s);
        }
        if (bulls == 0 && cows == 0) {
            System.out.println("Grade: None");
        }
        if (bulls == codeLength) {
            System.out.println("Grade: " + bulls + bull_s);
            System.out.println("Congratulations! You guessed the secret code.");
        }
    }

    static String generateRandomCode(int codeLength, int numberOfSymbols) {
        if (codeLength > 36) {
            System.out.println("Error: can't generate a secret number with a length of " + codeLength +
                               " because there aren't enough unique digits.");
            System.exit(0);
        }
        String chars = "0123456789abcdefghijklmnopqrstuvwxyz";
        String finalChars = null;
        try { finalChars = chars.substring(0, numberOfSymbols); }
        catch (StringIndexOutOfBoundsException e) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            System.exit(0);
        }
        var random = new Random();
        var code = "";
        do {
            var x = finalChars.charAt(random.nextInt(finalChars.length()));
            var y = String.valueOf(x);
            if (!code.contains(y)) {
                code += y;
            }
        } while (code.length() < codeLength);
        return code;
    }
}