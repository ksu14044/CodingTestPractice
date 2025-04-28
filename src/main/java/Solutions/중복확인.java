package Solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 중복확인 {
    public static void main(String[] args) {
        String answer = "";
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for(int a : map.keySet()) {
            if(map.get(a) > 1) {
                answer = "D";
                break;
            } else {
                answer = "U";
            }
        }
        System.out.println(answer);
    }
}
