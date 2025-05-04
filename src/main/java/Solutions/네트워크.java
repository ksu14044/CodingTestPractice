package Solutions;

public class 네트워크 {
    static int answer;
    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1,1,0}, {1,1,1}, {0,1,1}};
        boolean[] isVisited = new boolean[n];
        int answer = 0;
        for(int i = 0 ; i < n ; i++){
            if(!isVisited[i]){
                dfs(computers, i, isVisited);
                answer ++;
            }
        }
        System.out.println(answer);
    }

    public static void dfs(int[][] computers, int node, boolean[] isVisited) {
       isVisited[node] = true;
       for(int i = 0 ; i < computers[node].length ; i++){
           if(computers[node][i] == 1 && !isVisited[i]){
               dfs(computers, i, isVisited);
           }
       }

    }
}
