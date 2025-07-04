package Solutions;

import java.util.ArrayList;
import java.util.List;

public class 비밀코드해독 {
    static int count = 0;
    public static void main(String[] args) {
        int[][] q = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {3, 7, 8, 9, 10},
                {2, 5, 7, 9, 10},
                {3, 4, 5, 6, 7}
        };
        int n = 10;
        int[] ans = {2,3,4,3,3};
        System.out.println(solution(n, q, ans));
    }

    public static int solution(int n, int[][] q, int[] ans){
        makeCombi(new ArrayList<>(), n, 1, q, ans);
        return count;
    }

    public static void makeCombi(List<Integer> cur, int n , int start, int[][] q, int[] ans){
        if(cur.size() == 5){
            if(isValid(cur, q, ans)){
                count++;
            }
            return;
        }
        for(int i = start ; i <= n ; i++){
            cur.add(i);
            makeCombi(cur, n, i + 1, q, ans);
            cur.remove(cur.size() - 1);
        }
    }

    public static boolean isValid(List<Integer> cur, int[][] q, int[] ans){
        for(int i = 0 ; i < q.length ; i++){
            int match = 0;
            for(int num : q[i]){
                if(cur.contains(num)) match++;
            }
            if(match != ans[i]) return false;
        }
        return true;
    }

}
