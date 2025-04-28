package Solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 프로세스 {

    static class P {
        int priority;
        int index;
        public P(int priority, int index) {
            this.priority = priority;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        int[] priorities = {2,1,3,2};
        int location = 2;
        List<P> list = new ArrayList<>();
        for(int i = 0 ; i < priorities.length ; i++){
            list.add(new P(priorities[i], i));
        }

        Queue<P> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(list.get(i));
        }

        int count = 0;

        while(!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            for(P a : queue){
                max = Math.max(max,a.priority);
            }
            if(max == queue.peek().priority) {
                P p = queue.poll();
                count++;
                if(p.index == location) {
                    break;
                }
            } else {
                queue.offer(queue.poll());
            }
        }
    }
}
