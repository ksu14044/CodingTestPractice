package Solutions;

import java.util.LinkedList;
import java.util.Queue;

public class 경주로건설 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static class Node {
        int x; int y; int direction; int cost;
        Node(int x, int y, int direction, int cost) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.cost = cost;
        }
    }
    static int N;
    static int[][][] visited;

    public static void main(String[] args) {
//        int[][] board = {{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}};
        int[][] board = {{0,0,0},{0,0,0},{0,0,0}};
        N = board.length;
        visited = new int[N][N][4];
        int answer = Integer.MAX_VALUE;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, -1, 0));
        while(!q.isEmpty()){
            Node cur = q.poll();
            for(int i = 0 ; i < 4 ; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(isBlocked(nx, ny, board)) continue;
                int newCost = calculateCost(i, cur.direction, cur.cost);
                if(nx == N -1 && ny == N - 1){
                    answer = Math.min(answer, newCost);
                } else {
                    if(isShouldUpdate(nx, ny, i, newCost)){
                        q.offer(new Node(nx, ny, i, newCost));
                        visited[nx][ny][i] = newCost;
                    }
                }
            }
        }
        System.out.println(answer);
    }

    public static boolean isValid(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    public static boolean isBlocked(int x, int y, int[][] board){
        return !isValid(x, y) || board[x][y] == 1;
    }

    public static int calculateCost(int direction, int previousDirection, int cost){
        if(previousDirection == -1 || (previousDirection - direction) % 2  == 0) return cost + 100;
        return cost + 600;
    }

    public static boolean isShouldUpdate(int x, int y, int direction, int cost){
        return visited[x][y][direction] == 0 || visited[x][y][direction] > cost ;
    }
}
