package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class CountingSort {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 1, 3, 2, 1);
        System.out.println(countingSort(list));
    }

    public static List<Integer> countingSort(List<Integer> arr) {
        List<Integer> list = new ArrayList<>(Arrays.asList(new Integer[arr.size()]));
        Collections.fill(list, 0);
        for (int i = 0; i < arr.size(); i++) {
            Integer index = arr.get(i);
            Integer val = list.get(index);
            val += 1;
            list.set(index, val);
        }

        return list;

    }

}
