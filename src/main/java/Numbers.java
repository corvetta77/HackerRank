import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Numbers {

    public static void main(String[] args) {
        System.out.println(findUnique(Arrays.asList(1,2,3,4,3,2,1)));
    }

    private static Integer findUnique(List<Integer> a) {
        for (Integer element : a) {
            long count = a.stream().filter(el -> el.equals(element)).count();
            if (count == 1) {
                return element;
            }
        }
        throw new RuntimeException("Unique element not found");

    }


}
