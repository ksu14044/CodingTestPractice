package Solutions;

import java.util.Arrays;

public class 가장큰수 {
    public static void main(String[] args) {
        int[] numbers = {3, 30, 34, 5, 9};
        String[] strNumbers = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        Arrays.sort(strNumbers, (a,b) -> (b+a).compareTo(a+b));
        System.out.println(String.join("", strNumbers));
    }
}
