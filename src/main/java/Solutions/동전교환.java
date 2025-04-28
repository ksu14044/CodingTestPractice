package Solutions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 동전교환 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();
        int l = 0;
        int[] ch = new int[501];
        q.offer(0);
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int cur = q.poll();
                if( cur == target ) {
                    System.out.println(l);
                    return;
                } else  {
                    for(int j = 0 ; j<arr.length; j++) {
                        int nc = cur + arr[j];
                        if(nc >= 1 && nc <= 501 && ch[nc] == 0) {
                            ch[nc] = 1;
                            q.offer(nc);
                        }
                    }
                }
            }
            l++;
        }
        System.out.println(l);
    }
}
