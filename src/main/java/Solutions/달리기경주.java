package Solutions;

import java.util.*;

public class 달리기경주 {
    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        System.out.println(Arrays.toString(solution(players, callings)));
    }

    public static String[] solution(String[] players, String[] callings){
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0 ; i < players.length ; i++){
            map.put(players[i], i);
        }
        for(String c : callings){
            int idx = map.get(c);
            String frontName = players[idx - 1];
            players[idx] = frontName;
            players[idx - 1] = c;
            map.put(c, idx - 1);
            map.put(frontName, idx);
        }
        return players;
    }
}
