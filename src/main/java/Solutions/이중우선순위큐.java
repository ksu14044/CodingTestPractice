package Solutions;

import java.util.Collections;
import java.util.PriorityQueue;

public class 이중우선순위큐 {
    public static class DoublePriorityQueue {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        public void insert(int n){
            minHeap.add(n);
            maxHeap.add(n);
        }

        public void deleteMax(){
            if(!maxHeap.isEmpty()){
                int max = maxHeap.poll();
                minHeap.remove(max);
            }
        }

        public void deleteMin(){
            if(!minHeap.isEmpty()){
                int min = minHeap.poll();
                maxHeap.remove(min);
            }
        }

        public int getMax(){
            return maxHeap.isEmpty() ? 0 : maxHeap.peek();
        }

        public int getMin(){
            return minHeap.isEmpty() ? 0 : minHeap.peek();
        }
    }

    public static void main(String[] args) {
        DoublePriorityQueue dpq = new DoublePriorityQueue();
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        for(String op : operations){
            if(op.startsWith("I")){
                dpq.insert(Integer.parseInt(op.substring(2, op.length())));
            } else if(op.equals("D -1")){
                dpq.deleteMin();
            } else if(op.startsWith("D 1")){
                dpq.deleteMax();
            }
        }
        int[] answer = new int[2];
        answer[0] = dpq.getMax();
        answer[1] = dpq.getMin();

        for(int a : answer){
            System.out.print(a + " ");
        }
    }
}


