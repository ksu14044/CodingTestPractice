package Solutions;

import java.util.*;

public class 이모티콘할인행사 {
    static List<List<Integer>> combi = new ArrayList<>();
    static double[] rates = {0.1, 0.2, 0.3, 0.4};
    public static void main(String[] args) {
        int[][] users = {
                {40, 2900},
                {23, 10000},
                {11, 5200},
                {5, 5900},
                {40, 3100},
                {27, 9200},
                {32, 6900}
        };
        int[] emoticons = {1300, 1500, 1600, 4900};
        int n = emoticons.length;

        makeCombi(new ArrayList<>(), n);
        int maxSubs = 0;
        Map<Integer, Integer> result = new HashMap<>();
        for(List<Integer> c : combi){
            System.out.println(c);
            int subs = 0;
            int total = 0;
            for(int i = 0 ; i < users.length ; i++){
                double wantRate = users[i][0] / 100.0;
                int limit = users[i][1];
                int price = 0;
                for(int j = 0 ; j < c.size() ; j++){
                    if(rates[c.get(j)] >= wantRate) {
                        price += emoticons[j] * (1-rates[c.get(j)]);
                    }
                }
                if(price >= limit) subs++;
                else total += price;
            }
            System.out.println(subs);
            if(subs >= maxSubs){
                if(result.getOrDefault(subs, 0) == 0) result.put(subs, total);
                else {
                    int curTotal = result.get(subs);
                    if(total > curTotal) result.put(subs, total);
                }
                maxSubs = subs;
            }
        }
        int[] answer = new int[]{maxSubs, result.get(maxSubs)};
        System.out.println(Arrays.toString(answer));
    }

    public static void makeCombi(List<Integer> arr, int n){
        if(arr.size() == n){
            combi.add(new ArrayList<>(arr));
            return;
        }
        for(int i = 0 ; i < 4 ; i++){
                arr.add(i);
                makeCombi(arr, n);
                arr.remove(arr.size()-1);
        }
    }

}
