package Solutions;

import java.util.HashSet;
import java.util.Set;

public class 두수로특정값만들기 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 8};
        int target = 6;
        Set<Integer> s = new HashSet<>();
        for (int a : arr) s.add(a);
        boolean answer = false;
        for (int a : arr) {
            if (s.contains(target - a)) answer = true;
        }
        System.out.println(answer);
    }
}
