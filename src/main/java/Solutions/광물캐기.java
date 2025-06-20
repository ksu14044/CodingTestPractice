package Solutions;

public class 광물캐기 {
    static int answer = Integer.MAX_VALUE;
    static int[][] tools = {{1,1,1}, {5,1,1}, {25,5,1}};
    public static void main(String[] args) {
        int[] picks = {0, 1, 1};
        String[] minerals = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};
        dfs(picks, minerals, 0, 0);
        System.out.println(answer);
    }

    public static void dfs(int[] picks, String[] minerals, int idx, int total){
        if(idx >= minerals.length || picks[0] + picks[1] + picks[2] == 0){
            answer = Math.min(answer, total);
            return;
        }
        for(int i = 0 ; i < 3 ; i++){
            if(picks[i] > 0){
                picks[i] --;
                int sum = 0;
                for(int j = idx ; j < idx + 5 && j < minerals.length ; j++){
                    int target = 0;
                    if(minerals[j].equals("diamond")) target = 0;
                    else if(minerals[j].equals("iron")) target = 1;
                    else if(minerals[j].equals("stone")) target = 2;
                    sum += tools[i][target];
                }
                dfs(picks, minerals, idx + 5, total + sum);
                picks[i]++;
            }
        }
    }
}
