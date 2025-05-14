package Solutions;

import java.util.PriorityQueue;

public class 절대값힙구현하기 {
    public static void main(String[] args) {
        int n = 18;
        int[] sample = {1,-1, 0,0,0,1,1,-1,-1,2,-2,0,0,0,0,0,0,0};
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int firstAbs = Math.abs(o1);
            int secondAbs = Math.abs(o2);
            if(firstAbs == secondAbs){
            // 절대값이 같으면 음수 우선
                return o1 > o2 ? 1 : -1;
            }
            // 절대값이 작은 데이터 우선
            return firstAbs - secondAbs;
        });
        for(int i = 0 ; i < sample.length ; i++){
            if(sample[i] != 0){
                pq.offer(sample[i]);
            } else {
                if(pq.isEmpty()) System.out.println(0);
                else System.out.println(pq.poll());
            }
        }
    }
}
