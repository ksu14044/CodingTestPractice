package Solutions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 송아지찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int answer = 0;
        int[] dis = {1, -1, 5};
        int[] ch = new int[10001];
        ch[n] = 1;

        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        int l = 0;
        while(!q.isEmpty()) {
            int len = q.size();
            for(int i = 0; i < len; i++) {
                int cur = q.poll();
                if( cur == m ) {
                    System.out.println(l);
                    return;
                }
                for(int j = 0; j < 3; j++) {
                    int ncur = cur + dis[j];
                    if(ncur >= 1 && ncur <= 10000 && ch[ncur] == 0) {
                        ch[ncur] = 1;
                        q.offer(ncur);
                    }
                }
            }
            l++;
        }
        System.out.println(l);
    }
}
