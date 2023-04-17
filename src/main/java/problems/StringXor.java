package problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StringXor {

    private static String xor(String s1, String s2) {
        long l1 = Integer.parseInt(s1, 2);
        long l2 = Integer.parseInt(s2, 2);

        long result = l1 ^ l2;
        return Long.toString(result, 2);
    }

    public static void main(String args[]) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s1 = bufferedReader.readLine();
        String s2 = bufferedReader.readLine();

        String result = StringXor.xor(s1, s2);
        System.out.println(result);

        bufferedReader.close();
    }
}
