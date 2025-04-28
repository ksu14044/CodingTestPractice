package Solutions;
import java.util.*;

public class 다리를지나는트럭 {
    public static void main(String[] args) {
        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
        int time = 0;
        int bridgeWeight = 0;

        Queue<Integer> trucks = new LinkedList<>();
        for(int a : truck_weights) {
            trucks.offer(a);
        }

        Queue<Integer> onBridge = new LinkedList<>();
        for(int i = 0 ; i < bridge_length ; i++){
            onBridge.offer(0);
        }

        while(!trucks.isEmpty() || bridgeWeight > 0) {
            time++;
            bridgeWeight -= onBridge.poll();
            if(!trucks.isEmpty() && bridgeWeight + trucks.peek() <= weight) {
                int newTruck = trucks.poll();
                onBridge.offer(newTruck);
                bridgeWeight += newTruck;
            } else {
                onBridge.offer(0);
            }
        }
        System.out.println(time);
    }
}
