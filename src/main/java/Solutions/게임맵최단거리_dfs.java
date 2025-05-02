package Solutions;

public class 게임맵최단거리_dfs {
    static int distance = Integer.MAX_VALUE;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        dfs(0, 0, maps, 0);
        System.out.println(distance);
    }
    public static void dfs(int x, int y, int[][] maps, int count){
        if(x == maps.length-1 && y == maps.length-1){
            distance = Math.min(distance, count+1);
            return;
        } else {
            for(int i = 0 ; i < 4 ; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length && maps[nx][ny] == 1){
                    maps[nx][ny] = 0;
                    dfs(nx, ny, maps, count + 1);
                    maps[nx][ny] = 1;
                }
            }
        }
    }
}
