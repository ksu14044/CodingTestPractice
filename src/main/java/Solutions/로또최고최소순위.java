package Solutions;

import java.util.HashMap;
import java.util.Map;

public class 로또최고최소순위 {
    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};

        int[] win_nums = {31, 10, 45, 1, 6, 19};
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < win_nums.length ; i++){
            map.put(lottos[i], map.getOrDefault(lottos[i], 0) + 1);
            map.put(win_nums[i], map.getOrDefault(win_nums[i], 0) + 1);
        }
        int fix = 0;
        int zero = map.get(0);
        for(int a : map.keySet()){
            if(map.get(a) == 2 && a != 0){
                fix++;
            }
        }
        System.out.println(fix);
        System.out.println(zero);
        int lowestRank = Math.min(6, 7 - fix);
        int highestRank = Math.min(6, 7 - (fix + zero));
        int[] answer = {highestRank, lowestRank};
        System.out.println(highestRank);
        System.out.println(lowestRank);


    }
}
