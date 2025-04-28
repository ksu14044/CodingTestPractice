package Solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 결혼식 {
    public static class Time implements Comparable<Time> {
        public int time;
        public char state;
        Time(int time, char state) {
            this.time = time;
            this.state = state;
        }
        public int compareTo(Time o) {
            if(this.time == o.time) return this.state - o.state;
            else return this.time - o.time;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Time> times = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int st = sc.nextInt();
            int et = sc.nextInt();
            times.add(new Time(st, 's'));
            times.add(new Time(et, 'e'));
        }
        Collections.sort(times);
        int cnt = 0;
        int max = Integer.MIN_VALUE;
        for(Time t : times) {
            if(t.state == 's') cnt++;
            else if(t.state == 'e') cnt--;
            max = Math.max(max, cnt);
        }
        System.out.println(max);
    }
}
