package Solutions;

import java.util.Arrays;

public class 양궁대회 {
    static int max;
    static int[] apeach;
    static int[] answer;

    static int getScore(int[] ryan){
        int score = 0;
        for(int i = 0 ; i <= 10 ; i++){
            if(apeach[i] + ryan[i] > 0){
                score += ryan[i] > apeach[i] ? 10 - i : -(10 - i);
            }
        }
        return score;
    }

    static void calculateDiff(int[] ryan){
        int score = getScore(ryan);
        if(max < score){
            max = score;
            answer = ryan.clone();
        } else if(max > 0 && max == score){
            for(int i = 10 ; i >= 0 ; i--){
                if(answer[i] != ryan[i]){
                    if(answer[i] < ryan[i]){
                        answer = ryan.clone();
                    }
                    break;
                }
            }
        }
    }
    static void dfs(int n, int idx, int[] ryan){
        if(n == 0){
            calculateDiff(ryan);
            return;
        }
        for(int i = idx ; i <= 10 ; i++){
            int cnt = Math.min(n, apeach[i] + 1);
            ryan[i] = cnt;
            dfs(n - cnt, i + 1, ryan);
            ryan[i] = 0;
        }
    }

    static int[] solution(int n, int[] info){
        apeach = info;
        max = 0;
        dfs(n, 0, new int[11]);
        return max == 0 ? new int[]{-1} : answer;
    }

    public static void main(String[] args) {
        int[] info = {2,1,1,1,0,0,0,0,0,0,0};
        int n = 5;
        System.out.println(Arrays.toString(solution(n, info)));
    }
}
