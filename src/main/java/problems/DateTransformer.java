package problems;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateTransformer {
    private static void dateTransformer(String inputDate) {
        SimpleDateFormat inputDateFormatter = new SimpleDateFormat("hh:mm:ssa");
        SimpleDateFormat outputDateFormatter = new SimpleDateFormat("HH:mm:ss");

        String result = null;
        try {
            result = outputDateFormatter.format(inputDateFormatter.parse(inputDate));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        dateTransformer("12:12:21AM");
    }
}
