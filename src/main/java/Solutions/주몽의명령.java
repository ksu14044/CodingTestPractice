package Solutions;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class 주몽의명령 {
    public static void main(String[] args) {
        int[] ingredients = {2,1,3,7,5,4};
        int target = 9;
        Arrays.sort(ingredients);
        int lt = 0;
        int rt = ingredients.length - 1;
        int count = 0;
        while(lt < rt){
            int sum = ingredients[lt] + ingredients[rt];
            if(sum > target){
                rt--;
            } else if(sum < target){
                lt++;
            } else {
                count++;
                rt--;
                lt++;
            }
        }
        System.out.println(count);
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        q.offer(1);
        q.offer(2);
        q.offer(3);
        while(!q.isEmpty()){
            System.out.println(q.poll());
        }
    }
}
