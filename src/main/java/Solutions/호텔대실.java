package Solutions;

import java.util.*;

public class 호텔대실 {
    public static void main(String[] args) {
        String[][] bookTime = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
        Arrays.sort(bookTime, Comparator.comparingInt(a -> toMinutes(a[0])));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(String[] bt : bookTime){
            int start = toMinutes(bt[0]);
            int end = toMinutes(bt[1]) + 10;

            if(!pq.isEmpty() && pq.peek() <= start){
                pq.poll();
            }
            pq.add(end);
        }
        System.out.println(pq.size());
    }

    public static int toMinutes(String time){
        String[] t = time.split(":");
        int h = Integer.parseInt(t[0]);
        int m = Integer.parseInt(t[1]);
        return h * 60 + m;
    }
}
