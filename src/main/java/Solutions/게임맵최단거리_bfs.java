package Solutions;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리_bfs {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static class Node {
        int r; int c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
        int n = maps.length;
        int m = maps[0].length;
        int[][] dist = new int[n][m];
        dist[0][0] = 1;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0));
        while(!q.isEmpty()){
            Node cur = q.poll();
            for(int i = 0 ; i < 4 ; i++){
                int nr = cur.r + dx[i];
                int nc = cur.c + dy[i];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && dist[nr][nc] == 0 && maps[nr][nc] != 0){
                    q.add(new Node(nr, nc));
                    dist[nr][nc] = dist[cur.r][cur.c] + 1;
                }
            }
        }
        System.out.println(dist[n-1][m-1] == 0 ? -1 : dist[n-1][m-1]);
//        System.out.println(bfs(n,m,maps));
    }

//    public static int bfs(int n, int m, int[][] maps) {
//        Queue<int[]> queue = new LinkedList<>();
//        queue.add(new int[]{0, 0, 1});
//        boolean[][] visited = new boolean[n][m];
//        visited[0][0] = true;
//
//        while(!queue.isEmpty()) {
//            int[] cur = queue.poll();
//            int x = cur[0]; int y = cur[1]; int dist = cur[2];
//            if( x == n-1 && y == m-1 ) { return dist;}
//
//            for(int i = 0 ; i < 4 ; i ++) {
//                int nx = x + dx[i]; int ny = y + dy[i];
//                if( nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1 && !visited[nx][ny]) {
//                    queue.add(new int[]{nx, ny, dist + 1});
//                    visited[nx][ny] = true;
//                }
//            }
//        }
//
//
//        return -1;
//    }
}
