package Solutions;

public class 피로도2 {
    static int maxDungeons = 0;
    public static void main(String[] args) {
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        int k = 80;
        System.out.println("탐색 가능한 던전 수: " + solution(dungeons, k));

    }

    public static int solution(int[][] dungeons, int k) {
        boolean[] isVisited = new boolean[dungeons.length];
        explore(k, isVisited, dungeons, 0);
        return maxDungeons;
    }

    public static void explore(int fatigue, boolean[] isVisited, int[][] dungeons, int count) {
        maxDungeons = Math.max(maxDungeons, count);
        for(int i = 0 ; i < dungeons.length; i++){
            if(!isVisited[i] && fatigue >= dungeons[i][0]){
                isVisited[i] = true;
                explore(fatigue - dungeons[i][1], isVisited, dungeons, count+1);
                isVisited[i] = false;
            }
        }
    }
}
