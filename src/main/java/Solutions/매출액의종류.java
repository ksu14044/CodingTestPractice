package Solutions;

import java.util.*;

public class 매출액의종류 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] sales = new int[n];
        for (int i = 0; i < n; i++) {
            sales[i] = sc.nextInt();
        }
        List<Integer> answer = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ;i < k-1 ; i++){
            map.put(sales[i], map.getOrDefault(sales[i], 0) + 1);
        }
        int lt = 0;
        for(int rt = k-1 ; rt < n ; rt++) {
            map.put(sales[rt], map.getOrDefault(sales[rt], 0) + 1);
            answer.add(map.size());
            map.put(sales[lt], map.get(sales[lt]) - 1);
            if(map.get(sales[lt]) == 0){
                map.remove(sales[lt]);
            }
            lt++;
        }
        for(int a : answer){
            System.out.print(a+" ");
        }
    }
}

        // Time Limit Exceeded
//        int cnt = 0;
//        int p = 0;
//        List<Integer> list = new ArrayList<>();
//        Map<Integer, Integer> map = new HashMap<>();
//        for(int i = 0 ; i< n - k + 1; i++) {
//            for(int j = i; j < i + k ; j++) {
//                if(!map.containsKey(sales[j])) {
//                    cnt++;
//                    map.put(sales[j], map.getOrDefault(sales[j], 0) + 1);
//                }
//                map.put(sales[j], map.getOrDefault(sales[j], 0) - 1);
//            }
//            map.clear();
//            list.add(cnt);
//            cnt = 0;
//        }
//        for(int a : list) {
//            System.out.print(a+ " ");
//        }

