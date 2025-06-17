package Solutions;

import java.util.*;

public class 여행경로 {
    static List<String> result = new ArrayList<>();
    static boolean[] used;
    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        System.out.println(Arrays.toString(solution(tickets)));
    }

    public static String[] solution(String[][] tickets){
        used = new boolean[tickets.length];
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        dfs("ICN", "ICN", tickets, 0);
        return result.get(0).split(" ");
    }

    public static void dfs(String cur, String path, String[][] tickets, int count){
        if(count == tickets.length){
            result.add(path);
            return;
        }
        for(int i = 0 ;i < tickets.length ; i++){
            if(!used[i] && tickets[i][0].equals(cur)){
                used[i] = true;
                dfs(tickets[i][1], path + " " + tickets[i][1], tickets, count + 1);
                used[i] = false;
            }
        }
    }
}
