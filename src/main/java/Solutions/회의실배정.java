package Solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 회의실배정 {
    public static class Point implements Comparable<Point> {
        public int start, end;
        public Point(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Point o) {
            if(this.end == o.end) { return this.start - o.start; }
            else { return this.end - o.end; }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Point> points = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            points.add(new Point(start, end));
        }
        Collections.sort(points);
        int cnt = 0;
        int et = 0;
        for(Point p : points) {
            if( p.start >= et) {
                cnt++;
                et = p.end;
            }
        }
        System.out.println(cnt);
    }
}
