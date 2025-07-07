package Solutions;


import java.util.*;

public class 호텔방배정 {
    static Map<Long, Long> map = new HashMap<>();
    public static void main(String[] args) {
        long k = 10;
        long[] room_number = {1,3,4,1,3,1};
        long[] answer = new long[room_number.length];
        for(int i = 0 ; i < answer.length ; i++){
            answer[i] = find(room_number[i]);
        }
        System.out.println(Arrays.toString(answer));
    }
    public static long find(long room){
        if(!map.containsKey(room)){
            map.put(room, room+1);
            return room;
        }
        long next = find(map.get(room));
        map.put(room, next);
        return next;
    }
}
