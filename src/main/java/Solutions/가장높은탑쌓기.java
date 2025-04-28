package Solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 가장높은탑쌓기 {
    public static class Brick implements Comparable<Brick> {
        int s;
        int h;
        int w;

        public Brick(int s, int h, int w) {
            this.s = s;
            this.h = h;
            this.w = w;
        }
        @Override
        public int compareTo(Brick b) {
            return b.s - this.s;
        }
    }


    static int[] dy;

    public int solution(List<Brick> bricks) {
        int answer = 0;
        Collections.sort(bricks);
        for(Brick brick : bricks) {
            System.out.println("s: " + brick.s + " h: " + brick.h + " w: " + brick.w);
        }
        dy[0] = bricks.get(0).h;
        answer = dy[0];
        for(int i = 1; i < bricks.size(); i++) {
            int max_h = 0;
            for(int j = i-1 ; j >= 0 ; j--) {
                if(bricks.get(j).w > bricks.get(i).w && dy[j] > max_h) {
                    max_h = dy[j];
                }
            }
            dy[i] = max_h + bricks.get(i).h;
            answer = Math.max(answer, dy[i]);
        }

        return answer;
    }
    public static void main(String[] args) {
        가장높은탑쌓기 T = new 가장높은탑쌓기();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Brick> bricks = new ArrayList<Brick>();
        dy = new int[n];
        for(int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int h = sc.nextInt();
            int w = sc.nextInt();
            bricks.add(new Brick(s, h, w));
        }

        System.out.println(T.solution(bricks));
    }
}
