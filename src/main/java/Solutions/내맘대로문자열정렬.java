package Solutions;

import java.util.Arrays;
import java.util.Comparator;

public class 내맘대로문자열정렬 {
    public static void main(String[] args) {
        String[] arr = {"sun", "bed", "car"};
        int n = 1;

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                char c1 = o1.charAt(n);
                char c2 = o2.charAt(n);
                if( c1 == c2 ) {
                    return o1.compareTo(o2);
                }
                return c1 - c2;
            }
        });

        System.out.println(Arrays.toString(arr));
    }
}
