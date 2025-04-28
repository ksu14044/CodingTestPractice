package Solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 최대점수구하기 {
    static int timeLimit, n, answer = Integer.MIN_VALUE;
    public static void main(String[] args) {
        최대점수구하기 m = new 최대점수구하기();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        timeLimit = sc.nextInt();
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
            int score = sc.nextInt();
            int time = sc.nextInt();
            arr.get(i).add(score);
            arr.get(i).add(time);
        }
        m.dfs(0, 0,0, arr);
        System.out.println(answer);


    }
    public void dfs(int l, int sum, int time, List<List<Integer>> arr) {
        if(time > timeLimit){ return;}
        if(l == n) {
            answer = Math.max(answer, sum);
        } else {
            dfs(l+1, sum+arr.get(l).get(0), time+arr.get(l).get(1), arr);
            dfs(l+1, sum, time, arr);
        }
    }
}
