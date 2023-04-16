package mocktest;

import java.util.*;
import java.util.stream.IntStream;

public class MockTest1 {

    private static List<List<Integer>> newMatrix;

    public static int findMedian(List<Integer> arr) {
        arr.sort(Comparator.naturalOrder());
        return arr.get(arr.size()/2);

    }

    public static int flippingMatrix(List<List<Integer>> matrix) {
        // Write your code here
        int n = matrix.size()/2;

        int sum = 0;
        for (int x = 0; x< matrix.size(); x++) {
            sum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int max = Math.max(matrix.get(i).get(j),
                            matrix.get(2 * n - 1 - i).get(j));
                    int max1 = Math.max(matrix.get(i).get(2 * n - 1 - j),
                            matrix.get(2 * n - 1 - i).get(2 * n - 1 - j));
                    sum += Math.max(max, max1);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(0, new ArrayList<>(Arrays.asList(1,1,1,1)));
        matrix.add(1, new ArrayList<>(Arrays.asList(3,4,1,1)));
        matrix.add(2, new ArrayList<>(Arrays.asList(1,1,3,4)));
        matrix.add(3, new ArrayList<>(Arrays.asList(3,4,1,1)));
        int sum = flippingMatrix(matrix);
        System.out.println(sum);
    }
}
