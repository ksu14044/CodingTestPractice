package Solutions;

import java.util.HashMap;
import java.util.Map;

public class 스타수열 {
    public static void main(String[] args) {
        int[] a = {0,3,3,0,7,2,0,2,2,0};
        System.out.println(solution((a)));
    }
    public static int solution(int[] a){
        int n = a.length;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : a){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int num : map.keySet()){
            if(map.get(num) * 2 <= max) continue;
            int cnt = 0;
            for(int i = 0 ; i < n - 1 ; i++){
                if(a[i] != a[i+1] && (a[i] == num || a[i+1] == num)){
                    cnt ++;
                    i++;
                }
            }
            max = Math.max(max, cnt*2);
        }
        return max;
    }
}
