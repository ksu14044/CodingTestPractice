package Solutions;

import java.util.*;

public class 숫자변환하기 {
    static int count;
    public static void main(String[] args) {
        int x = 10;
        int y = 40;
        int n = 5;

        Queue<int[]> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();

        q.offer(new int[]{x, 0});
        set.add(x);

        while(!q.isEmpty()){
            int[] arr = q.poll();
            int num = arr[0];
            count = arr[1];
            if(num == y) break;

            int[] nextNums = {num + n, num * 2, num * 3};
            for(int nextNum : nextNums){
                if(nextNum <= y && !set.contains(nextNum)){
                    q.offer(new int[]{nextNum, count+1});
                    set.add(nextNum);
                }
            }
        }
        System.out.println(count);
    }
}

// dfs => 시간 초과
//    static List<Integer> list = new ArrayList<>();
//    public static void main(String[] args) {
//        int x = 10;
//        int y = 40;
//        int n = 5;
//        dfs(x, y, n, 0);
//        int answer = Integer.MAX_VALUE;
//        for(int a : list){
//            answer = Math.min(answer, a);
//        }
//        if(list.isEmpty()){
//            answer = -1;
//        }
//        System.out.println(answer);
//    }
//
//    public static void dfs(int x, int y, int n, int count){
//        if(x > y) return ;
//        if(x == y) {
//            list.add(count);
//        }
//        else {
//            count++;
//            dfs(x+n, y, n, count);
//            dfs(x*2, y, n, count);
//            dfs(x*3, y, n, count);
//        }
//    }
//}
