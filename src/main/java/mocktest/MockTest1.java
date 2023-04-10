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

        final int[] sum = {sumQuadrant(matrix, n)};

        //flip columns
        IntStream.range(0, matrix.size()).forEach(columnIndex -> {
            if (shouldFlipColumn(matrix, columnIndex)) {
                newMatrix = flipColumn(matrix, columnIndex);
                updateSumIfBigger(n, sum);
            }
        });
        System.out.println(sum[0]);

        //flip rows
        IntStream.range(0, matrix.size()).forEach(rowIndex -> {
            if (shouldFlipRow(matrix, rowIndex)) {
                newMatrix = flipRow(matrix, rowIndex);
                updateSumIfBigger(n, sum);
            }
        });
        return sum[0];
    }

    private static boolean updateSumIfBigger(int n, int[] sum) {
        int newSum = sumQuadrant(newMatrix, n);
        if (newSum > sum[0]) {
            sum[0] = newSum;
            return true;
        }
        return false;
    }

    private static boolean shouldFlipColumn(List<List<Integer>> matrix, int columnIndex) {
        int sumFirstHalf = 0;
        for (int i = 0; i < matrix.size()/2; i++) {
            sumFirstHalf += matrix.get(i).get(columnIndex);
        }
        int sumSecondHalf = 0;
        for (int i = matrix.size()/2; i < matrix.size(); i++) {
            sumSecondHalf += matrix.get(i).get(columnIndex);
        }
        if (sumSecondHalf > sumFirstHalf) {
            return true;
        } else return matrix.get(matrix.size() - 1).get(columnIndex) > matrix.get(0).get(columnIndex);
    }

    private static List<List<Integer>> flipColumn(List<List<Integer>> matrix, int columnIndex) {
        List<List<Integer>> newMatrix = new ArrayList<>(matrix.size());
        newMatrix.addAll(matrix);
        for (int i = 0; i < matrix.size()/2; i++) {
            Integer temp = newMatrix.get(i).get(columnIndex);
            newMatrix.get(i).set(columnIndex, newMatrix.get(newMatrix.size()-i-1).get(columnIndex));
            newMatrix.get(newMatrix.size()-i-1).set(columnIndex, temp);
        }
        return newMatrix;
    }

    private static boolean shouldFlipRow(List<List<Integer>> matrix, int rowIdx) {
        var sumOfFirstHalf = 0;
        for (int i = 0; i < matrix.size() / 2; i++) {
            sumOfFirstHalf += matrix.get(rowIdx).get(i);
        }

        var sumOfSecondHalf = 0;
        for (int i = matrix.size() / 2; i < matrix.size(); i++) {
            sumOfSecondHalf += matrix.get(rowIdx).get(i);
        }
        if (sumOfSecondHalf > sumOfFirstHalf) {
            return true;
        } else return matrix.get(rowIdx).get(matrix.size() - 1) > matrix.get(rowIdx).get(0);
    }

    private static List<List<Integer>> flipRow(List<List<Integer>> matrix, int rowIdx) {
        List<List<Integer>> newMatrix = new ArrayList<>(matrix.size());
        newMatrix.addAll(matrix);
        List<Integer> row = newMatrix.get(rowIdx);
        Collections.reverse(row);
        newMatrix.set(rowIdx, row);
        return newMatrix;
    }

    private static int sumQuadrant(List<List<Integer>> matrix, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            List<Integer> matrixRow = matrix.get(i);
            for (int j = 0; j < n; j++) {
                sum+=matrixRow.get(j);
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
