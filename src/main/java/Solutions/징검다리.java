package Solutions;

import java.util.Arrays;

public class 징검다리 {
    public static void main(String[] args) {
        int n = 2;
        int distance = 25;
        int[] rocks = {2, 14, 11, 21, 17};
        System.out.println(solution(distance, rocks, n));
    }

    public static int solution(int distance, int[] rocks, int n){
        Arrays.sort(rocks);
        int answer = 0;
        int left = 1;
        int right = distance;
        int[] allRocks = new int[rocks.length + 1];
        for(int i = 0 ; i < rocks.length ; i++){
            allRocks[i] = rocks[i];
        }
        allRocks[rocks.length] = distance;
        while(left <= right){
            int mid = (left + right) / 2;
            int removed = 0;
            int prev = 0;
            for(int rock : allRocks){
                if(rock - prev < mid){
                    removed++;
                } else {
                    prev = rock;
                }
            }
            if(removed > n){
                right = mid - 1;
            } else {
                answer = mid;
                left = mid + 1;
            }
        }
        return answer;
    }
}
