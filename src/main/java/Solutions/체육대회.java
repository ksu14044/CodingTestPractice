package Solutions;

public class 체육대회 {
    static int max = Integer.MIN_VALUE;
    static boolean[] visited;
    public static void main(String[] args) {
        int[][] ability = {{40, 10, 10}, {20, 5, 0}, {30, 30, 30}, {70, 0, 70}, {100, 100, 100}};
        visited = new boolean[ability.length];
        dfs(ability, 0, 0);
        System.out.println(max);
    }

    public static void dfs(int[][] ability, int event, int sum){
        if(event == ability[0].length){
            max = Math.max(max, sum);
            return;
        }
        for(int i = 0 ; i < ability.length; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(ability, event + 1, sum + ability[i][event]);
                visited[i] = false;
            }
        }
    }
}


