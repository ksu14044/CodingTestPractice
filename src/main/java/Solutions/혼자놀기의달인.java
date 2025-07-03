package Solutions;
import java.util.*;

class 혼자놀기의달인 {
    public static void main(String[] args) {
        int[] cards = {8,6,3,7,2,5,1,4};
        혼자놀기의달인 s = new 혼자놀기의달인();
        System.out.println(s.solution(cards));
    }
    List<List<Integer>> result = new ArrayList<>();
    public int solution(int[] cards) {
        int answer = 0;
        boolean[] visited = new boolean[cards.length + 1];
        for(int i = 0 ; i < cards.length ; i++){
            if(!visited[i]){
                dfs(new ArrayList<>(), visited, i, cards);
            }
        }
        Collections.sort(result, (a, b) -> b.size() - a.size());
        if(result.size() < 2) return 0;
        return result.get(0).size() * result.get(1).size();
    }
    public void dfs(List<Integer> arr, boolean[] visited, int next, int[] cards){
        if(next < 0 || next >= cards.length || visited[next]) result.add(new ArrayList<>(arr));
        else {
            visited[next] = true;
            arr.add(cards[next]);
            dfs(arr, visited, cards[next] - 1, cards);
        }
    }
}
