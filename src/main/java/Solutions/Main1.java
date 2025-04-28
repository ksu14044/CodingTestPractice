package Solutions;

import java.util.*;

public class Main1 {
    static int max = Integer.MIN_VALUE;
    public static class Lecture implements Comparable<Lecture> {
        public int money, time;
        public Lecture(int money, int time) {
            this.money = money;
            this.time = time;
        }
        public int compareTo(Lecture o) {
            return o.time - this.time;
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Lecture> lectures = new ArrayList<>();
        for(int i = 0 ;i < n ; i++) {
            int money = sc.nextInt();
            int time = sc.nextInt();
            lectures.add(new Lecture(money, time));
            if(time > max) max = time;
        }
        int answer = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(lectures);

        int j = 0;
        for(int i = max ; i >= 1 ; i--){
            for( ; j < n ; j++){
                if(lectures.get(j).time < i ) break;
                else pQ.offer(lectures.get(j).money);
            }
            if(!pQ.isEmpty()) answer += pQ.poll();
        }
        System.out.println(answer);


    }


}
