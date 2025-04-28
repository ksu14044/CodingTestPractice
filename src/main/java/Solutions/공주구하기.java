package Solutions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 공주구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1 ; i <= n ; i++) {
            q.offer(i);
        }
        int cnt = 0;
        while(q.size()!=1) {
            cnt ++;
            if(cnt == k) {
                q.poll();
                cnt = 0;
            } else {
                q.offer(q.poll());
            }
        }
        System.out.println(q.peek());
    }
}
