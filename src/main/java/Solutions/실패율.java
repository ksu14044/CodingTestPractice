package Solutions;

import java.util.*;

public class 실패율 {
    public static void main(String[] args) {
        int n = 5;
        int[] stages = {2,1,2,6,2,4,3,3};
        Map<Integer, Integer> failed = new HashMap<>();
        for(int stage : stages) {
            failed.put(stage, failed.getOrDefault(stage, 0) + 1);
        }
        System.out.println(failed);

        Map<Integer, Integer> reached = new HashMap<>();
        for(int i = 1 ; i <= n ; i++) {
            int sum = 0;
            for(int key : failed.keySet()) {
                if(key >= i) {
                    sum += failed.get(key);
                }
            }
            reached.put(i, sum);
        }
        System.out.println(reached);
        Map<Integer, Double> failRate = new HashMap<>();
        for(int i = 1 ; i <= n ; i++) {
            failRate.put(i, (double)failed.getOrDefault(i, 0) / reached.get(i));
        }
        List<Map.Entry<Integer, Double>> sortedList = new ArrayList<>(failRate.entrySet());
        sortedList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        System.out.println(sortedList);
        int[] answer = new int[n];
        for(int i = 0 ; i < sortedList.size() ; i++){
            answer[i] = sortedList.get(i).getKey();
        }
        for(int a : answer){
            System.out.println(a);
        };

    }
}
