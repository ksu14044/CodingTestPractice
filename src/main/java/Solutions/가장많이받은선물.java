package Solutions;

import java.util.HashMap;
import java.util.Map;

public class 가장많이받은선물 {
    public static void main(String[] args) {
        String[] frineds = {"muzi", "ryan", "frodo", "neo"};
        String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
        System.out.println(solution(frineds, gifts));
    }

    public static int solution(String[] friends, String[] gifts){
        int n = friends.length;
        Map<String, Integer> indexMap = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            indexMap.put(friends[i], i);
        }
        int[][] giftHistory = new int[n][n];
        int[] giftSent = new int[n];
        int[] giftReceived = new int[n];
        for(String gift : gifts){
            String[] s = gift.split(" ");
            int from = indexMap.get(s[0]);
            int to = indexMap.get(s[1]);
            giftHistory[from][to]++;
            giftSent[from]++;
            giftReceived[to]++;
        }
        int[] nextMonths = new int[n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(i == j) continue;
                if(giftHistory[i][j] > giftHistory[j][i]){
                    nextMonths[i]++;
                } else if(giftHistory[i][j] == giftHistory[j][i]){
                    int pointI = giftSent[i] - giftReceived[i];
                    int pointJ = giftSent[j] - giftReceived[j];
                    if(pointI > pointJ) nextMonths[i]++;
                }
            }
        }
        int ans = 0;
        for(int count : nextMonths){
            ans = Math.max(ans, count);
        }
        return ans;
    }
}
