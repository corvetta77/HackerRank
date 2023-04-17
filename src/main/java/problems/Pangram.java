package problems;

import java.util.regex.Pattern;

public class Pangram {
    public static void main(String[] args) {
        String string1 = "The quick brown fox jumps over the lazy dog";
        System.out.println(pangrams(string1));
        String string2 = "We promptly judged antique ivory buckles for the prize";
        System.out.println(pangrams(string2));

    }

    private static String pangrams(String string) {
        String lowerCased = string.toLowerCase();
        for (char letter = 'a'; letter <='z'; letter++ ) {
            if (!lowerCased.contains(String.valueOf(letter))) {
             return "non pangram";
            }
        }
        return "pangram";

    }
}
