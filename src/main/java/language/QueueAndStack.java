package language;

import java.util.*;

public class QueueAndStack {
    // Write your code here.
    private List<Character> queue = new LinkedList<>();
    private List<Character> stack = new LinkedList<>();


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();

        // Convert input String to an array of characters:
        char[] s = input.toCharArray();

        // Create a Solution object:
        QueueAndStack p = new QueueAndStack();

        // Enqueue/Push all chars to their respective data structures:
        for (char c : s) {
            p.pushCharacter(c);
            p.enqueueCharacter(c);
        }

        // Pop/Dequeue the chars at the head of both data structures and compare them:
        boolean isPalindrome = true;
        for (int i = 0; i < s.length/2; i++) {
            if (p.popCharacter() != p.dequeueCharacter()) {
                isPalindrome = false;                
                break;
            }
        }

        //Finally, print whether string s is palindrome or not.
        System.out.println( "The word, " + input + ", is " 
                           + ( (!isPalindrome) ? "not a palindrome." : "a palindrome." ) );
    }

    private Character dequeueCharacter() {
        return queue.get(0);
    }

    private void enqueueCharacter(char c) {
        queue.add( c);
    }

    private Character popCharacter() {
        return stack.get(stack.size()-1);
    }

    private void pushCharacter(char c) {
        stack.add(c);
    }
}