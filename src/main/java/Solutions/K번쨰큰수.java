package Solutions;

import java.util.*;

public class K번쨰큰수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i <nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0 ; i < nums.length -2 ; i++) {
            for(int j = i+1 ; j < nums.length -1 ; j ++) {
                for(int s = j+1 ; s < nums.length ; s++ ) {
                    int sum = 0;
                    sum += nums[i] + nums[j] + nums[s];
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }
        List<Integer> keys = new ArrayList<>();
        for(int key : map.keySet()) {
            keys.add(key);
            System.out.println("key: " + key);
        }
        Collections.sort(keys);
        if(keys.size() >= k) {
            System.out.println(keys.get(keys.size()-k));
        } else {
            System.out.println(-1);
        }
    }
}
