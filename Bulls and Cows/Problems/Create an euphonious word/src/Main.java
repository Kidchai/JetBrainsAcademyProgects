import java.util.*;

public class Main {
    public static boolean isVowel(char loweCh) {
        var ch = Character.toUpperCase(loweCh);
        return ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' || ch == 'Y';
    }

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var word = scanner.next();
        var chars = word.toCharArray();

        var similarInRow = 0;
        var addLetter = 0;

        var isPreviousLetterVowel = isVowel(chars[0]);
        for (var i = 1; i < chars.length; i++) {
            var isLetterVowel = isVowel(chars[i]);
            if (isLetterVowel == isPreviousLetterVowel) {
                similarInRow++;
                if (similarInRow % 2 == 0) {
                    addLetter++;
                    similarInRow = 0;
                }
            } else {
                similarInRow = 0;
            }
            isPreviousLetterVowel = isLetterVowel;
        }
        System.out.println(addLetter);
    }
}