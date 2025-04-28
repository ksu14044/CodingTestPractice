package Solutions;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;



public class 씨름선수 {
    public static class Body implements Comparable<Body> {
        public int h, w;
        Body(int h, int w) {
            this.h = h;
            this.w = w;
        }

        @Override
        public int compareTo(Body o) {
            return o.h - this.h;
        }
    }

    public static void main(String[] args) {
        씨름선수 m = new 씨름선수();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Body> arr = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            arr.add(new Body(h, w));
        }
        int cnt = 0;
        Collections.sort(arr);
        int max = Integer.MIN_VALUE;
        for(Body b : arr) {
            max = Math.max(max, b.w);
            if(b.w == Math.max(max, b.w)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}


