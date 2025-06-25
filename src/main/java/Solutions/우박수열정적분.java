package Solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 우박수열정적분 {
    public static void main(String[] args) {
        int k = 5;
        int[][] ranges = {{0,0},{0,-1},{2,-3},{3,-3}};
        System.out.println(Arrays.toString(solution(k, ranges)));
    }

    public static double[] solution(int k, int[][] ranges){
        double[] answer = new double[ranges.length];
        List<Integer> seq = new ArrayList<>();
        seq.add(k);

        while(k > 1){
            if(k % 2 == 0) k /= 2;
            else k = k*3 + 1;
            seq.add(k);
        }
        int n = seq.size();
        double[] preArea = new double[n];
        for(int i = 0 ; i < n - 1 ; i++){
            double area = (seq.get(i) + seq.get(i + 1)) / 2.0;
            preArea[i + 1] = preArea[i] + area;
        }
        for(int i = 0 ; i < ranges.length ; i++){
            int a = ranges[i][0];
            int b = n - 1 + ranges[i][1];
            if(a > b) answer[i] = -1.0;
            else answer[i] = preArea[b] - preArea[a];
        }
        return answer;
    }
}
