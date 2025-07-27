package Solutions;
import java.util.*;
public class 아이템줍기 {

    static int[][] map;
    static int maxSize = 102; // 좌표 2배 확장 후 최대 크기 (50*2 + 여유)
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        map = new int[maxSize][maxSize];

        // 1. 모든 사각형 외곽선 그리기
        for (int[] r : rectangle) {
            int leftX = r[0] * 2;
            int leftY = r[1] * 2;
            int rightX = r[2] * 2;
            int rightY = r[3] * 2;

            // 외곽선 그리기
            for (int x = leftX; x <= rightX; x++) {
                map[leftY][x] = 1; // 아래
                map[rightY][x] = 1; // 위
            }
            for (int y = leftY; y <= rightY; y++) {
                map[y][leftX] = 1; // 왼쪽
                map[y][rightX] = 1; // 오른쪽
            }
        }

        // map을 다 만든다음에 지우기 만들면서 지우면 안됨;
        for(int[] r : rectangle){
            int lx = r[0] * 2;
            int ly = r[1] * 2;
            int rx = r[2] * 2;
            int ry = r[3] * 2;
            for(int x = lx + 1 ; x < rx ; x++){
                for(int y = ly + 1; y < ry ; y++){
                    map[y][x] = 0;
                }
            }
        }

        // 2. BFS로 최소 경로 탐색
        return bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2) / 2;
    }

    static int bfs(int startX, int startY, int targetX, int targetY) {
        boolean[][] visited = new boolean[maxSize][maxSize];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startX, startY, 0});
        visited[startY][startX] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], dist = cur[2];

            if (x == targetX && y == targetY) {
                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= maxSize || ny >= maxSize) continue;
                if (map[ny][nx] == 1 && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    q.offer(new int[]{nx, ny, dist + 1});
                }
            }
        }
        return -1; // 도달 불가
    }

    // 테스트
    public static void main(String[] args) {
        int[][] rectangle = {
                {1, 1, 7, 4},
                {3, 2, 5, 5},
                {4, 3, 6, 9},
                {2, 6, 8, 8}
        };
        int characterX = 1, characterY = 3, itemX = 7, itemY = 8;

        int result = solution(rectangle, characterX, characterY, itemX, itemY);
        System.out.println("최단 거리: " + result);
    }
}
