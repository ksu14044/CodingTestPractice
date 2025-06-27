package Solutions;

import java.util.*;

public class 인사고과 {
    public static void main(String[] args) {
        int[][] scores = {{2,2}, {1,4}, {3,2}, {3,2}, {2,1}};
        System.out.println(solution(scores));
    }

    public static int solution(int[][] scores){
        int[] wyanho = scores[0];

        Arrays.sort(scores, (a, b) -> {
            if(b[0] != a[0]) return b[0] - a[0];
            return a[1] - b[1];
        });
        System.out.println(Arrays.deepToString(scores));
        List<int[]> list = new ArrayList<>();
        int maxY = Integer.MIN_VALUE;
        for(int i = 0 ; i < scores.length ; i++){
            if(scores[i][1] >= maxY){
                list.add(scores[i]);
                maxY = Math.max(maxY, scores[i][1]);
            }
        }

        if(!list.contains(wyanho)) return -1;

        Collections.sort(list, (a, b) -> {
            int sumA = a[0] + a[1];
            int sumB = b[0] + b[1];
            return sumB - sumA;
        });
        Map<Integer, Integer> rank = new HashMap<>();
        int temp = 1;
        for(int[] i : list){
            int sum = i[0] + i[1];
            rank.put(sum, rank.getOrDefault(sum, temp));
            temp++;
        }
        System.out.println(rank);
        int point = wyanho[0] + wyanho[1];
        for(int[] i : list){
            System.out.println(Arrays.toString(i));
        }


        return rank.get(point);
    }
}
