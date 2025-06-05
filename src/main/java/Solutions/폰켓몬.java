package Solutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class 폰켓몬 {
    public static void main(String[] args) {
        int[] nums = {3,3,3,2,2,4};
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet::new));
        System.out.println(set);
        int n = nums.length;
        int k = n / 2;
        System.out.println(Math.min(k, set.size()));
    }
}
